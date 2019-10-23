package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    ListView lstOpciones;
    ImageView imgUser;
    List<Titulos> opciones = new ArrayList<Titulos>();
    ListViewAdapterPropio adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        this.InitializeControls();
        this.LoadListViewTemplate();

    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menucontextual, menu);

    }


    @Override
    public boolean onContextItemSelected(MenuItem Item){

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) Item.getMenuInfo();
        switch(Item.getItemId()){
            case R.id.eliminar:
                Toast.makeText(getApplicationContext(),"posicion "+info.position,Toast.LENGTH_LONG).show();
                    opciones.remove(info.position);
                    adapter.notifyDataSetChanged();//se debe notificar los cambios en el List para poder mostrar los cambios
                return true;
                default:
                    return super.onContextItemSelected(Item);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu1,menu);
        return  true;

    }

    //seleccion de opcion del menu
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.item_perfil:
                Intent intent2 = new Intent(getApplicationContext(),PerfilActivity.class);
                startActivity(intent2);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



   private void InitializeControls() {

        lstOpciones = (ListView) findViewById(R.id.lstOpciones);
         registerForContextMenu(lstOpciones);
        final Intent intent = new Intent(this,ChatsIndividualActivity.class);
        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                String opcionSeleccionada =((Titulos) a.getItemAtPosition(position)).getUserName();
                Toast.makeText(ListViewActivity.this, "Opción seleccionada: " + opcionSeleccionada, Toast.LENGTH_LONG).show();
                opciones.get(position).setImgCheck(R.drawable.doublecheck);//enviar confirmacion imagen al list
                adapter.notifyDataSetChanged();//mostrar ganchos en azul de leidos
                // parametros actividad actual, Activity a donde se dirige
                intent.putExtra("usr",(((Titulos) a.getItemAtPosition(position)).getUserName()));//enviar nombre del usuario
                startActivity(intent);
            }
        });


    }


    public void LoadListViewTemplate(){
        opciones = this.GetElementsToListViewTemplate();

        adapter = new ListViewAdapterPropio(this, opciones);

        lstOpciones.setAdapter(adapter);
    }

    public List<Titulos> GetElementsToListViewTemplate(){

        opciones.add(new Titulos("Amy ", "Hola ",R.drawable.bat,R.drawable.doublecheckgray));
        opciones.add(new Titulos("Carlos ", "Mañana Gym ",R.drawable.bat,R.drawable.doublecheckgray));
        opciones.add(new Titulos("Deepak ", "Eriicccc ",R.drawable.bat,R.drawable.doublecheckgray));
        opciones.add(new Titulos("Boloncho ", "Pokemon ",R.drawable.bat,R.drawable.doublecheckgray));
        opciones.add(new Titulos("Magavillar ", "llegar temprano",R.drawable.bat,R.drawable.doublecheckgray));

        return  opciones;

    }
}
