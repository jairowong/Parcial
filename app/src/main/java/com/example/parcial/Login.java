package com.example.parcial;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    EditText usuario,passwor;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        usuario=findViewById(R.id.loginNombre);
        passwor=findViewById(R.id.loginPassword);
        btn1=findViewById(R.id.logear);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = usuario.getText().toString();
                String contrasenia = passwor.getText().toString();

                boolean usuarioEncontrado = false;
                for (Usuario usuario : Registro.usuarios) {
                    if (usuario.getNombre().equals(nombre) && usuario.getPassword().equals(contrasenia)) {
                        usuarioEncontrado = true;
                        break;

                    }
                }
                if (usuarioEncontrado) {
                    Toast.makeText(Login.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                    // Navegar a la actividad de bienvenida

                }
                else {
                    Toast.makeText(Login.this, "Nombre o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}