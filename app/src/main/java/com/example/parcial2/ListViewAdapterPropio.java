package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapterPropio extends ArrayAdapter<Titulos>
{

    private List<Titulos> opciones = new ArrayList<>();

    public ListViewAdapterPropio(Context context, List<Titulos> datos){
        super(context, R.layout.activity_list_view_adapter_propio, datos);

        opciones= datos;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.activity_list_view_adapter_propio, null);

        ImageView imgPerfil = (ImageView)item.findViewById(R.id.imgPerfil);
        imgPerfil.setImageResource(opciones.get(position).getImgUser());

        TextView tvNameUser = (TextView)item.findViewById(R.id.tvUser);
        tvNameUser.setText(opciones.get(position).getUserName());

        TextView tvMsjUser = (TextView)item.findViewById(R.id.tvMsjUsr);
        tvMsjUser.setText(opciones.get(position).getUserMsj());

        ImageView imgChekerMsj = (ImageView)item.findViewById(R.id.imgCheck);
        imgChekerMsj.setImageResource(opciones.get(position).getImgCheck());

        return(item);
    }
}
