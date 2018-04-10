package smart.lytn.smartcook;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomMenu);
        text = findViewById(R.id.textView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            //Este metodo se ejecutara cada vez que se seleccione un item del menu de abajo
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId() == R.id.homeItem){
                    text.setText("HOME");
                }else if(item.getItemId() == R.id.receiptItem){
                    text.setText("RECETAS");
                }else if(item.getItemId() == R.id.profileItem){
                    text.setText("PERFIL");
                }


                return false;
            }
        });

    }
}
