package com.example.angelus.preferencias;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private EditText nombre, dni, fechaNacimiento, sexo;
    private TextView miPrefe1;
    private SharedPreferences misPreferencias; //clase que guarda las preferencias
    private SharedPreferences.Editor miEditorPreferencias;//clase que edita las preferencias

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = (EditText) findViewById(R.id.nombre);//asociamos objetos java a objetos xml
        dni = (EditText) findViewById(R.id.dni);
        fechaNacimiento = (EditText) findViewById(R.id.FechaNacimiento);
        sexo = (EditText) findViewById(R.id.Sexo);
        miPrefe1 = (TextView) findViewById(R.id.textView2);
        misPreferencias = getSharedPreferences("Mis Preferencias", Activity.MODE_PRIVATE);//obtenemos y damos nombre al paquete de preferencias
        miEditorPreferencias = misPreferencias.edit(); //decimos que estas pueden ser editables


        if(misPreferencias.getInt("primeraVez", 1) == 1) { // he hecho este condicional, para que una vez que salgamos de la aplicacion, nos muestre las ultimas preferencias guardadas
            String nombre = misPreferencias.getString("nombre","");
            String dni = misPreferencias.getString("dni","");
            String fechaNacimiento = misPreferencias.getString("fechaNacimiento","");
            String sexo = misPreferencias.getString("sexo","");

            miPrefe1.setText("Nombre : "+nombre +"\nDni: "+dni+ "\nFechaNacimiento: "+fechaNacimiento+ "\nSexo: "+sexo);
        }
        Button miButton = (Button) findViewById(R.id.button);

        miButton.setOnClickListener(new View.OnClickListener() { //añadimos al boton su listener
            @Override
            public void onClick(View v) {
                //misPreferencias = getSharedPreferences("Mis Preferencias", Activity.MODE_PRIVATE);//obtenemos un paquete de preferencias y le damos un nombre
                //miEditorPreferencias = misPreferencias.edit(); //hacemos que las preferencias obtenidas puedan ser editadas con otra clase
                miEditorPreferencias.putString("nombre", nombre.getText().toString());//vamos colocando los valores con una key y un valor
                miEditorPreferencias.putString("dni", dni.getText().toString());
                miEditorPreferencias.putString("fechaNacimiento", fechaNacimiento.getText().toString());
                miEditorPreferencias.putString("sexo", sexo.getText().toString());
                miEditorPreferencias.putInt("primeraVez", 1);
                miEditorPreferencias.commit();

                Intent miIntento = new Intent(getApplicationContext(), Main2Activity.class);//creamos un intento del Main2Activity con su propio xml
                startActivity(miIntento);//lanzamos la actividad recibiendo como parametro el intento
            }
        });


    }

}
