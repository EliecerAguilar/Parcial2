package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ChatsIndividualActivity extends AppCompatActivity {

    //declaracion de variables de los controles
    private ImageView imgT;
    private TextView tvName;
    private TextView tvStatus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

    }

    private void load(){
        tvName = (TextView)findViewById(R.id.tvName);
    }


}
