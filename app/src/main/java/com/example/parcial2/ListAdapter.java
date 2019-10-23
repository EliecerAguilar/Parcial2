package com.example.parcial2;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends ArrayAdapter<chat> {

    private List<chat> info = new ArrayList<>();
    private int colorText;

    public ListAdapter(Context context, List<chat> datos){
        super(context,R.layout.activity_chat,datos);
        colorText = R.color.colorPrimary;
        info = datos;
    }

    public void setColorText(int color_text){
        this.colorText = color_text;
    }

    public int getColorText(){
        return this.colorText;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.activity_template_list,null);

        TextView msj = (TextView)item.findViewById(R.id.tv_msj);
        msj.setText(info.get(position).getMsj());


        int tipo = info.get(position).getUsr();

        switch (tipo){
            case 0:
                msj.setGravity(Gravity.RIGHT);
                msj.setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);
                //item.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            break;
            case 1:
                //msj.setTextAlignment(convertView.TEXT_ALIGNMENT_TEXT_END);
                msj.setGravity(Gravity.LEFT);
                msj.setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);
            break;
            default:
                Toast.makeText(getContext(),"error",Toast.LENGTH_LONG).show();
        }


        msj.setTextColor(info.get(position).getColor());

        return(item);

    }
/*
    private void alinear(int Tusr, String msj){

        TextView txt = new TextView(getContext());
        txt.setId(1);
        txt.setText(msj);

        //obtener id del Layout donde esta el comtrol
        RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.RL2);
        //definir variable para los cambios en los parametros del control
        RelativeLayout.LayoutParams relativeLayoutParamas;
        //establecer la configuracion inicial del Layout
        relativeLayoutParamas = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);

        //agregar regla de alinieacion del control
        if (Tusr == 0){
            relativeLayoutParamas.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        }
        else {
            if (Tusr == 1) {
                relativeLayoutParamas.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            }
        }

        //enviar las reglas al control
        relativeLayout.addView(txt,relativeLayoutParamas);

    } */
    //incluir en la activity de perfil

}
