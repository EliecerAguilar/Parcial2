package com.example.parcial2;

import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
        this.load();

    }



    private void load(){

        imageView = (ImageView) findViewById(R.id.perfilfoto);
        //--Evento que espera que a la imagen se le de click
        imageView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0)
            {
                //--Mostrara un mensaje tostada al dar click a la imagen
                Toast.makeText(getApplicationContext(), "foto de perfil", Toast.LENGTH_SHORT).show();
            }
        });

        spinner = (Spinner) findViewById(R.id.estado2);
        String[] lista = {"SELECCIONE UN ESTADO","DISPONIBLE","OCUPADO","REUNION"};
        spinner.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, lista));

        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> spn,android.view.View v,int position,long id){
                        //Toast.makeText(spn.getContext(), "Has seleccionado " + spn.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
                        String color;
                        switch (spn.getItemAtPosition(position).toString()){
                            case "DISPONIBLE":
                                color="verde";
                                seleccion(color);
                            break;
                            case "OCUPADO":
                                color = "rojo";
                                seleccion(color);
                            break;

                            case "REUNION":
                                color = "amarillo";
                                seleccion(color);
                            break;

                            default:
                                if (spn.getItemAtPosition(position).toString() == "SELECCIONE UN ESTADO")
                                    break;
                                else
                                Toast.makeText(getApplicationContext(),"opcion no valida",Toast.LENGTH_LONG).show();
                        }
                    }
                    public void onNothingSelected(AdapterView<?> spn) {
                    }
                });
    }


    public void seleccion(String color){
        SharedPreferences prefs = getSharedPreferences("estadochat", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = prefs.edit();
        ed.putInt("color",obtenerColor(color));
        ed.commit();

    }

    private int obtenerColor(String color){

        switch (color){
            case "verde":
                return super.getColor(R.color.green);

            case "rojo":
                return super.getColor(R.color.red);

            case "azul":
                return super.getColor(R.color.blue);

            case "amarillo":
                return super.getColor(R.color.yelow);

            case "negro":
                return super.getColor(R.color.black);

            case "blanco":
                return super.getColor(R.color.white);
            default:
                Toast.makeText(getApplicationContext(),"color no reconocido",Toast.LENGTH_LONG).show();

        }
        return super.getColor(R.color.colorPrimary);
    }
}
