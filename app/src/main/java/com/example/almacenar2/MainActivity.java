package com.example.almacenar2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText nombre, apellido, email, telefono, direccionU;
    Button btn_ejecutar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = findViewById(R.id.txtNombre);
        apellido = findViewById(R.id.txtTelefono);
        email = findViewById(R.id.txtEmail);
        telefono = findViewById(R.id.txtTelefono);
        direccionU = findViewById(R.id.txtDirec_usuario);
        btn_ejecutar = findViewById(R.id.buttonRegistrar);

        SharedPreferences pf = getSharedPreferences("datos", Context.MODE_PRIVATE);
        nombre.setText(pf.getString("nombre",""));
        apellido.setText(pf.getString("apellido",""));
        email.setText(pf.getString("email",""));
        telefono.setText(pf.getString("telefono",""));
        direccionU.setText(pf.getString("direccion",""));
        btn_ejecutar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferencias.edit();
                editor.putString("nombre", nombre.getText().toString());
                editor.putString("apellido", apellido.getText().toString());
                editor.putString("email", email.getText().toString());
                editor.putString("telefono", telefono.getText().toString());
                editor.putString("direccion", direccionU.getText().toString());
                editor.commit();
                finish();
            }
        });

    }
}