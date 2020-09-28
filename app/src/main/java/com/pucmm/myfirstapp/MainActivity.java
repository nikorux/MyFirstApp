package com.pucmm.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";

    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    String Nombre;
    String Apellido;
    EditText Name, LastName;
    RadioGroup Lenguajes;
    RadioButton Si, No;
    CheckBox Java, Python, JS, GoLand, CC, CS;
    Button Enviar, Limpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText) findViewById(R.id.txtNombre);
        LastName = (EditText) findViewById(R.id.txtApellido);

        mDisplayDate = (TextView) findViewById(R.id.tvDate);

        final Spinner mySpinner = (Spinner) findViewById(R.id.spinner1);

        final ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        Lenguajes = (RadioGroup) findViewById(R.id.rgmegusta);
        Si = (RadioButton) findViewById(R.id.rbsi);
        No = (RadioButton) findViewById(R.id.rbno);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Calendar cal = Calendar.getInstance();
                    int year = cal.get(Calendar.YEAR);
                    int month = cal.get(Calendar.MONTH);
                    int day = cal.get(Calendar.DAY_OF_MONTH);

                    DatePickerDialog dialog = new DatePickerDialog(
                            MainActivity.this,
                            android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                            mDateSetListener,
                            year, month, day);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                mDisplayDate.setText(date);

            }
        };



        Java = (CheckBox) findViewById(R.id.cbJava);
        Python = (CheckBox) findViewById(R.id.cbPython);
        JS = (CheckBox) findViewById(R.id.cbJS);
        GoLand = (CheckBox) findViewById(R.id.cbgol);
        CC = (CheckBox) findViewById(R.id.cbCC);
        CS = (CheckBox) findViewById(R.id.cbCS);

        Enviar = (Button) findViewById(R.id.btnEnviar);
        Limpiar = (Button) findViewById(R.id.btnLimpiar);

        Lenguajes.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (Si.isChecked()) {
                    Toast.makeText(MainActivity.this, "ACTIVO", Toast.LENGTH_SHORT).show();
                    Java.setClickable(true);
                    //Java.setEnabled(true);
                    Python.setClickable(true);
                    JS.setClickable(true);
                    GoLand.setClickable(true);
                    CC.setClickable(true);
                    CS.setClickable(true);


                }
                else if (No.isChecked()) {
                    Toast.makeText(MainActivity.this, "INACTIVO", Toast.LENGTH_SHORT).show();
                    Java.setClickable(false);
                    Python.setClickable(false);
                    JS.setClickable(false);
                    GoLand.setClickable(false);
                    CC.setClickable(false);
                    CS.setClickable(false);

                }
            }
        });

        Enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nameValue = Name.getText().toString();
                String secnameValue = LastName.getText().toString();
                String fecha = mDisplayDate.getText().toString();
                String genero = mySpinner.getSelectedItem().toString();

                if (nameValue.isEmpty() || secnameValue.isEmpty() || genero.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Estos datos deben ser obligatorios", Toast.LENGTH_SHORT).show();
                }
                else {

                    String megusta = "";

                    if (Si.isChecked()) {

                        megusta = "Me gusta programar. Mis lenguajes \nfavoritos son: ";
                        if (Java.isChecked()) {
                            megusta = megusta+"Java, ";
                        }
                        if (Python.isChecked()) {
                            megusta = megusta+"Python, ";
                        }
                        if (JS.isChecked()) {
                            megusta = megusta+"JS, ";
                        }
                        if (GoLand.isChecked()) {
                            megusta = megusta+"Go, ";
                        }
                        if (CC.isChecked()) {
                            megusta = megusta+"C/C++, ";
                        }
                        if (CS.isChecked()) {
                            megusta = megusta+"C#, ";
                        }
                        megusta = megusta+".";

                    }
                    else if (No.isChecked()) {
                        megusta = "No me gusta programar.";
                    }

                    String mg = megusta.toString();

                    Intent intent = new Intent (MainActivity.this, SecondActivity.class);
                    intent.putExtra("NOMBRE", nameValue);
                    intent.putExtra("APELLIDO", secnameValue);
                    intent.putExtra("FECHA", fecha);
                    intent.putExtra("GENERO", genero);
                    intent.putExtra("MEGUSTA", mg);
                    startActivity(intent);
                    /*else if (No.isChecked()) {

                    }*/


                    /*if (Java.isEnabled()) {
                        megusta = megusta+"Java, ";
                    }
                    if (Python.isEnabled()) {
                        megusta = megusta+"Python, ";
                    }
                    if (JS.isEnabled()) {
                        megusta = megusta+"JS, ";
                    }
                    if (GoLand.isEnabled()) {
                        megusta = megusta+"Go, ";
                    }
                    if (CC.isEnabled()) {
                        megusta = megusta+"C/C++, ";
                    }
                    if (CS.isEnabled()) {
                        megusta = megusta+"C#, ";
                    }*/



                }

                /*    megusta = "No me gusta programar.";

                }

                String mg = megusta.toString();

                Intent intent = new Intent (MainActivity.this, SecondActivity.class);
                intent.putExtra("NOMBRE", nameValue);
                intent.putExtra("APELLIDO", secnameValue);
                intent.putExtra("FECHA", fecha);
                intent.putExtra("GENERO", genero);
                intent.putExtra("MEGUSTA", mg);
                startActivity(intent);*/
            }
          }


        );


    }
}