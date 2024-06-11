package com.example.parcial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Registro extends AppCompatActivity {

    EditText reusu,repass;
    Button registrar;
    Spinner spiner;

    RadioGroup radiogro;
    RadioButton radiob;
    public static ArrayList<Usuario> usuarios = new ArrayList<>(); // Almacena los usuarios


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro);

        reusu=findViewById(R.id.regisNombre);
        repass=findViewById(R.id.regisPassword);
        registrar=findViewById(R.id.crearUsu);
        spiner=findViewById(R.id.spinner2);
        radiogro=findViewById(R.id.grupo);
        




        String[] data = {"Estudiante", "Administrador", "Jefe", "Docente"};

        // Crear un ArrayAdapter usando la lista de datos y un diseño por defecto para los elementos del Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, data);

        // Especificar el diseño a usar cuando la lista de opciones aparezca
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Aplicar el adaptador al Spinner
        spiner.setAdapter(adapter);


        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = reusu.getText().toString();
                String contrasenia = repass.getText().toString();

                if (!nombre.isEmpty() && !contrasenia.isEmpty()) {
                    Usuario usuario = new Usuario(nombre, contrasenia);
                    usuarios.add(usuario);
                    Toast.makeText(Registro.this, "Usuario registrado con éxito", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(Registro.this, Login.class);

                    startActivity(intent);
                }else {
                    Toast.makeText(Registro.this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}