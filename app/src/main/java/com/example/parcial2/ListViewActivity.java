package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
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
    ImageView imagevieww;
    List<Titulos> opciones = new ArrayList<Titulos>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        this.InitializeControls();
        this.LoadListViewTemplate();
        this.registerForContextMenu(lstOpciones);

    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menucontextual, menu);
    }

    public boolean onContextItemSelected(MenuItem Item)
    {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) Item.getMenuInfo();
        switch(Item.getItemId())
        {
            case R.id.eliminar:

                return true;
                default:

                    return super.onContextItemSelected(Item);

        }

    }
    private void eliminarcontacto(AdapterView.AdapterContextMenuInfo info)
    {
        opciones.remove(info.position);

    }

   private void InitializeControls() {

        lstOpciones = (ListView) findViewById(R.id.lstOpciones);


        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                String opcionSeleccionada =
                        ((Titulos) a.getItemAtPosition(position)).getTitulo();
                Toast.makeText(ListViewActivity.this, "Opción seleccionada: " + opcionSeleccionada, Toast.LENGTH_LONG).show();
                imagevieww=(ImageView)findViewById(R.id.imageview);
              ((Titulos) a.getItemAtPosition(position)).getImgUser();
                ((Titulos) lstOpciones.getItemAtPosition(position)).setImgUser(R.drawable.doublecheck);
                 imagevieww.setImageResource(R.drawable.doublecheck);

            }
        });



            }


    public void LoadListViewTemplate()
    {
        List<Titulos> opciones = this.GetElementsToListViewTemplate();

        ListViewAdapterPropio adapter = new ListViewAdapterPropio(this, opciones);

        lstOpciones.setAdapter(adapter);
    }

    public List<Titulos> GetElementsToListViewTemplate()
    {


        opciones.add(new Titulos("Amy ", "Hola ", "5min",R.drawable.doublecheckgray));
        opciones.add(new Titulos("Carlos ", "Mañana Gym ","3hr",R.drawable.doublecheckgray));
        opciones.add(new Titulos("Deepak ", "Eriicccc ","4hr",R.drawable.doublecheckgray));
        opciones.add(new Titulos("Boloncho ", "Pokemon ","5hr",R.drawable.doublecheckgray));
        opciones.add(new Titulos("Magavillar ", "llegar temprano","1hr",R.drawable.doublecheckgray));


        return  opciones;

    }
}
