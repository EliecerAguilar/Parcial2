package com.example.parcial2;

import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.SharedPreferences;


public class PerfilActivity extends AppCompatActivity {

    ImageView imageView;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        imageView = (ImageView) findViewById(R.id.perfilfoto);
        //--Evento que espera que a la imagen se le de click
        imageView.setOnClickListener(new View.OnClickListener(){
             public void onClick(View arg0)
            {
                //--Mostrara un mensaje tostada al dar click a la imagen
                Toast.makeText(getApplicationContext(), "foto de perfil", Toast.LENGTH_SHORT).show();
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.estado2);
        String[] lista = {"DISPONIBLE","OCUPADO","REUNION"};
        spinner.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, lista));
    }

    public void seleccion(){
        String selectedItem = "";
        selectedItem = spinner.getSelectedItem().toString();
        SharedPreferences prefs = this.getSharedPreferences("estadochat", Context.MODE_PRIVATE);

        EditText var = (EditText)findViewById(R.id.prueba);

        SharedPreferences.Editor ed = prefs.edit();
        ed.putString("Nombre","");
    }
}
