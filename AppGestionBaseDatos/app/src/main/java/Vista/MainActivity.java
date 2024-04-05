package Vista;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.exament7pabloperezserrano.R;

import Controlador.Adaptador;
import Controlador.ControladorGeneral;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    ControladorGeneral controlador = new ControladorGeneral(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));

        //Con un sharedpreferences controlo el metodo de ordenacion
        SharedPreferences settings = getSharedPreferences(getString(R.string.nombreSharedPreferences), Context.MODE_PRIVATE);
        rv.setAdapter(new Adaptador(controlador.obtenerMonumentos(settings.getBoolean(getString(R.string.ordenar), true)), this));
        setSupportActionBar(findViewById(R.id.materialToolbar));

        //gestiono un alertDialog para mostrar el estado en el que está actualmente el sistema de ordenación
        if(settings.getBoolean(getString(R.string.ordenar), true)){
            new AlertDialog.Builder(this)
                    .setTitle(getString(R.string.tituloAlertDialog))
                    .setMessage(getString(R.string.msgOrdenarCiudad))
                    .setPositiveButton(getString(R.string.botonAceptar), null)
                    .create().show();
        }else{
            new AlertDialog.Builder(this)
                    .setTitle(getString(R.string.tituloAlertDialog))
                    .setMessage(getString(R.string.msgOrdenarMonumento))
                    .setPositiveButton(getString(R.string.botonAceptar), null)
                    .create().show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        //aqui es donde le doy valor a la ordenacion y la controlo mediante un booleano, si el valor del boolean es true, se ordena por ciudad, si no por monumentos
        SharedPreferences settings = getSharedPreferences(getString(R.string.nombreSharedPreferences), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        if(item.getItemId() == R.id.itemOrdenarNombreCiudad){
            if(!settings.getBoolean(getString(R.string.ordenar), true)){
                editor.putBoolean(getString(R.string.ordenar), true);
                editor.apply();

                //Creo un intent para volver a cargar la pantalla y asi se actualice el estado de la lista
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
            }

        }else{
            //controlo si el estado ya es true, porque si es false significa que ya esta ordenando por monumento, entonces no quiero que se vuelva
            //a cargar la activity, hago lo mismo en el item de arriba
            if(settings.getBoolean(getString(R.string.ordenar), true)){
                editor.putBoolean(getString(R.string.ordenar), false);
                editor.apply();
                
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
            }
        }
        return true;
    }
}