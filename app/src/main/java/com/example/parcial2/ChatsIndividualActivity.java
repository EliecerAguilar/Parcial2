package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
        this.alinear();

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
    private void alinear(){

        TextView txt = new TextView(getApplicationContext());
        txt.setId(1);
        txt.setText("hola");


        //obtener id del Layout donde esta el comtrol
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.RL_title);
        //definir variable para los cambios en los parametros del control
        RelativeLayout.LayoutParams relativeLayoutParamas;
        //establecer la configuracion inicial del Layout
        relativeLayoutParamas = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);

        //agregar regla de alinieacion del control
        relativeLayoutParamas.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        //enviar las reglas al control
        relativeLayout.addView(txt,relativeLayoutParamas);

    }


}
