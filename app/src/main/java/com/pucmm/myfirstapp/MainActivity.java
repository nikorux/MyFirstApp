package com.pucmm.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String Nombre;
    String Apellido;
    EditText Name, LastName;
    Button Enviar, Limpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText) findViewById(R.id.txtNombre);
        LastName = (EditText) findViewById(R.id.txtApellido);

        Enviar = (Button) findViewById(R.id.btnEnviar);
        Limpiar = (Button) findViewById(R.id.btnLimpiar);

        Enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameValue = Name.getText().toString();
                String secnameValue = LastName.getText().toString();
                Intent intent = new Intent (MainActivity.this, SecondActivity.class);
                intent.putExtra("NOMBRE", nameValue);
                intent.putExtra("APELLIDO", secnameValue);
                startActivity(intent);
            }
                                  }


        );


    }
}