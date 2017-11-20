package com.example.angelus.preferencias;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView miCampo = (TextView) findViewById(R.id.textView);


        SharedPreferences misPreferencias = getSharedPreferences("Mis Preferencias", Activity.MODE_PRIVATE);
        String nombre = misPreferencias.getString("nombre","");
        String dni = misPreferencias.getString("dni","");
        String fechaNacimiento = misPreferencias.getString("fechaNacimiento","");
        String sexo = misPreferencias.getString("sexo","");


        miCampo.setText("Nombre : "+nombre +"\nDni: "+dni+ "\nFechaNacimiento: "+fechaNacimiento+ "\nSexo: "+sexo);


    }
}
