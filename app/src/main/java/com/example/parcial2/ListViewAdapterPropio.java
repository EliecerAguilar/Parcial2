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
        ImageView image1 = (ImageView)item.findViewById(R.id.imageview);
        image1.setImageResource(opciones.get(position).getImgUser());
        TextView lblTitulo = (TextView)item.findViewById(R.id.lblTitulo);
        lblTitulo.setText(opciones.get(position).getTitulo());

        TextView lblSubtitulo = (TextView)item.findViewById(R.id.lblSubTitulo);
        lblSubtitulo.setText(opciones.get(position).getSubtitulo());

        TextView lblNota = (TextView)item.findViewById(R.id.lblNota);
        lblNota.setText(opciones.get(position).getNota());




        return(item);
    }
}
