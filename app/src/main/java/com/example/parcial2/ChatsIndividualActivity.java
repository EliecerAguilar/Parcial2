package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.parcial2.chat;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

public class ChatsIndividualActivity extends AppCompatActivity {

    //declaracion de variables de los controles
    private ImageView imgT;
    private TextView tvName;
    private TextView tvStatus;
    private ListView listViewchats;
    private List<chat> chatsInlist = new ArrayList<>();
    private EditText chatEnviar;
    private ImageButton imgEnviar;
    private ImageButton imgRsc;
    private ImageButton imgIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        this.load();
        this.adapterSet();


    }

    private void load(){

        tvName = (TextView)findViewById(R.id.tvName);
        tvName.setText(getIntent().getStringExtra("usr").toString());//pasar nombre del usuario desde otra activity


        tvStatus = (TextView)findViewById(R.id.tv_status);
        this.imgRedondeada(R.drawable.bat,R.id.imgB);//imagen redondeada

        chatEnviar = (EditText)findViewById(R.id.et_chat);

        listViewchats = (ListView) findViewById(R.id.ListChat);

        imgEnviar = (ImageButton) findViewById(R.id.enviar);
        imgEnviar.setImageResource(R.drawable.env);

        imgIcon = (ImageButton) findViewById(R.id.imgIcon);
        imgIcon.setImageResource(R.drawable.face_ico);

        imgRsc = (ImageButton)findViewById(R.id.rsc);
        imgRsc.setImageResource(R.drawable.clip);

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

    public void enviar(View view){
        int usr =1;
        String str = chatEnviar.getText().toString();
        chatsInlist.add(new chat(str,usr));
        ListAdapter adapter = new ListAdapter(this,chatsInlist);
        listViewchats.setAdapter(adapter);
    }

    private List<chat> lista(){
        List<chat> ch = new ArrayList<>();

        ch.add(new chat("Soy batman nadie me pude ganar, a todos le spondre F",1));
        ch.add(new chat("superman es mas buena onda",0));
        ch.add(new chat("ya valiste",1));
        ch.add(new chat("MEH!",0));

        return ch;
    }

    private void adapterSet(){
        chatsInlist = this.lista();
        ListAdapter adapter = new ListAdapter(this,chatsInlist);
        listViewchats.setAdapter(adapter);
    }



    public void rd(View view){
        Toast.makeText(getApplicationContext(),"funcional",Toast.LENGTH_LONG).show();
    }

}
