package smart.lytn.smartcook;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;


/**
 * Demonstrate Firebase Authentication using a Google ID Token.
 */
public class LoginActivity  extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    private GoogleApiClient googleApiClient;
    private SignInButton signInButton;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private ProgressBar processLogIn;
    public static final int SIGN_IN_CODE = 777;
    public static final String LOGIN_ERROR = "Error al iniciar sesión";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Dice como se va a autenticar el usuario
        GoogleSignInOptions options = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                //para recibir un token
                .requestIdToken(getString(R.string.default_web_client_id))
                //para tener le email del usuario autenticado
                .requestEmail()
                .build();

        googleApiClient = new GoogleApiClient.Builder(this)
                //permite gestionar el ciclo de vida de google api client con el de la activity
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, options)
                .build();

        signInButton = findViewById(R.id.signGoogleButton);

        //Se abrirá el inicio de sesión para una cuenta Google
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                //Cuando se inicia se espera un resultado
                startActivityForResult(intent, SIGN_IN_CODE);
            }
        });

        firebaseAuth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            //Este metodo mira si estamos auntenticados o no
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                //Se ejecuta cuando cambia el estado de autenticación
                //Obtenemos el usuario actual
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){
                    //Si no es nulo vamos a la pagina principal
                    goPrincipalScreen();
                }
            }
        };

        processLogIn = (ProgressBar) findViewById(R.id.processLogIn);
        processLogIn.setVisibility(View.GONE);
    }

    //Aqui se le asigna al firebaseAuth su listener
    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(authStateListener);
    }

    //Este metodo se ejecuta cuando algo sale mal en la conexión
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    //Aqui llegan los resultados de la autenticacion
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SIGN_IN_CODE){
            //Obtenemos un objeto resultado
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            //Con este metodo podemos manejar el resultado
            handleSignInResult(result);
        }else{

        }
    }

    //Comprobamos si la operación ha salido con éxito
    private void handleSignInResult(GoogleSignInResult result) {
        if (result.isSuccess()){
            //Este metodo lleva al usuario a la activity correspondiente
            //goPrincipalScreen();
            //metodo para autenticar con google cuando se ha hecho con firebase
            firebaseAuthWithGoogle(result.getSignInAccount());
        }else{
            //Le mostramos un mensaje al usuario
            Toast.makeText(this, LOGIN_ERROR, Toast.LENGTH_SHORT).show();
        }
    }

    //Proceso de inicio de sesion con Firebase
    private void firebaseAuthWithGoogle(GoogleSignInAccount googleSignInAccount) {
        //Manejamos el progressbar para la autenticación, mostramos el progressbar y ocultamos el boton de google
        processLogIn.setVisibility(View.VISIBLE);
        signInButton.setVisibility(View.GONE);
        //Creamos una credencial y le pasamos el token que se obtiene de la cuenta
        AuthCredential credential = GoogleAuthProvider.getCredential(googleSignInAccount.getIdToken(), null);
        //Empieza la autenticacion con firebase y poner otro listener para que nos diga cuando ha terminado
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            //Nos dice lo que se ejecuta cuando el proceso termina
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //Ocultamos el progressbar cuando termine la autenticación y mostramos el boton de google
                processLogIn.setVisibility(View.GONE);
                signInButton.setVisibility(View.VISIBLE);
                if(!task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "No se pudo autenticar con FireBase", Toast.LENGTH_SHORT).show();;
                }
            }
        });
    }

    private void goPrincipalScreen() {
        Intent intent = new Intent(this, PrincipalActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    //Sirve para detender al listener de firebase
    @Override
    protected void onStop() {
        super.onStop();
        if(authStateListener != null){
            firebaseAuth.removeAuthStateListener(authStateListener);
        }else{

        }
    }
}
