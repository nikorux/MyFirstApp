package com.pucmm.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tv, tv1, tv2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv = (TextView) findViewById(R.id.txtName);
        tv1 = (TextView) findViewById(R.id.txtGeneroFecha);
        tv2 = (TextView) findViewById(R.id.txtmg);

        tv.setText("Hola!, mi nombre es: "+getIntent().getStringExtra("NOMBRE")+" "+getIntent().getStringExtra("APELLIDO")+".");
        tv1.setText("Soy "+getIntent().getStringExtra("GENERO")+", y nací en fecha "+getIntent().getStringExtra("FECHA")+".");
        tv2.setText(getIntent().getStringExtra("MEGUSTA"));

    }
}