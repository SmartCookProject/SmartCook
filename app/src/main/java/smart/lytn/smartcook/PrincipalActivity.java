package smart.lytn.smartcook;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class PrincipalActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    private TextView name;
    private TextView email;
    private TextView id;
    private ImageView image;
    private Button logout;
    private Button revoke;

    private GoogleApiClient googleApiClient;

    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        image = findViewById(R.id.foto);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        id = findViewById(R.id.id);

        logout = findViewById(R.id.logout);
        revoke = findViewById(R.id.revoke);

        logout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                logOut(view);
            }
        });

        revoke.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                revoke(view);
            }
        });

        GoogleSignInOptions signInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        //Esto se llama el login "silencioso"
        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, signInOptions)
                .build();

        firebaseAuth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            //Este metodo mira si estamos auntenticados o no
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                //Se ejecuta cuando cambia el estado de autenticación
                //Obtenemos el usuario actual
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){
                    //metodo para colocar los datos del usuario
                    setUserData(user);
                }else{
                    //Sino que le devuelva a la pantalla de login
                    goLogInScreen();
                }
            }
        };
    }

    private void setUserData(FirebaseUser user) {
        name.setText(user.getDisplayName());
        email.setText(user.getEmail());
        id.setText(user.getUid());
        //Manejamos la foto de perfil
        Glide.with(this).load(user.getPhotoUrl()).into(image);
    }

    //Se recibe el login "silencioso".
    @Override
    protected void onStart() {
        super.onStart();
        //Añadimos un listener
        firebaseAuth.addAuthStateListener(authStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(authStateListener != null){
            firebaseAuth.removeAuthStateListener(authStateListener);
        }else{

        }
    }

    //Dirige al usuario a la pagina de login
    private void goLogInScreen() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    //Cerrar sesión
    public void logOut(View view){
        //Cerramos sesion en firebase
        firebaseAuth.signOut();
        //Cerramos sesion en google
        Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                //Devuelve un objeto estatus para ver si ha salido con exito o no
                if(status.isSuccess()){
                    goLogInScreen();
                }else{
                    //Mensaje con el error
                    Toast.makeText(PrincipalActivity.this, "No se pudo cerrar la sesión", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //Con esto se cierra sesión pero eliminando cualquier vínculo con la app
    public void revoke(View view){
        //Cerramos sesion en firebase
        firebaseAuth.signOut();
        //Cerramos sesion en google
        Auth.GoogleSignInApi.revokeAccess(googleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                //Maneja el estado de este proceso
                if(status.isSuccess()){
                    goLogInScreen();
                }else{
                    Toast.makeText(PrincipalActivity.this, "No se pudo revocar la sesión", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
