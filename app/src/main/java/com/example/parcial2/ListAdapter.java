package com.example.parcial2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends ArrayAdapter<chat> {

    private List<chat> info = new ArrayList<>();

    public ListAdapter(Context context, List<chat> datos){
        super(context,R.layout.activity_chat);
        info = datos;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.activity_template_list,null);

        TextView msj = (TextView)item.findViewById(R.id.tv_msj);
        msj.setText(info.get(position).getMsj());

        int tipo = info.get(position).getUsr();

        switch (tipo){
            case 0:
                    //k
            break;;
            case 1:
                    //k
            break;
            default:
                Toast.makeText(getContext(),"error de tipo de usuario",Toast.LENGTH_LONG).show();
        }

    }

}
