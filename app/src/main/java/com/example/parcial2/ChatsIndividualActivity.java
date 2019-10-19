package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
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
        this.load();

    }

    private void load(){

        tvName = (TextView)findViewById(R.id.tvName);
        tvStatus = (TextView)findViewById(R.id.tv_status);
        this.imgRedondeada(R.drawable.bat,R.id.imgB);//imagen redondeada

    }

    private void imgRedondeada(int imgGet, int imgSet){
        //extraemos el drawable en un bitmap
        Drawable originalDrawable = getResources().getDrawable(imgGet);
        Bitmap originalBitmap = ((BitmapDrawable) originalDrawable).getBitmap();

        //creamos el drawable redondeado
        RoundedBitmapDrawable roundedDrawable = RoundedBitmapDrawableFactory.create(getResources(), originalBitmap);

        //asignamos el CornerRadius
        roundedDrawable.setCornerRadius(originalBitmap.getHeight());

        ImageView imageView = (ImageView) findViewById(imgSet);

        imageView.setImageDrawable(roundedDrawable);

    }


}
