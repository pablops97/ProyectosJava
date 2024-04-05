package Controlador;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import Modelo.Ciudad;
import Modelo.Monumento;

public class ControladorGeneral {

    public BDMonumento bdMonumento;
    public Context contexto;
    public SQLiteDatabase connexion;

    public ControladorGeneral(Context contexto) {
        this.contexto = contexto;
        bdMonumento = new BDMonumento(contexto);
    }

    //Utilizo como parametro el sharedpreference guardado para poder ordenarlo directamente mediante sentencia sql
    public ArrayList<Monumento> obtenerMonumentos(boolean ordenamiento){
        ArrayList<Monumento> monumentos = new ArrayList<>();
        connexion = bdMonumento.getReadableDatabase();

        //si es true, ordenar por ciudad, si no por monumento
        if(ordenamiento == true){
            Cursor cursor = connexion.rawQuery("SELECT M.nombre, C.id, C.nombre FROM monumento M JOIN ciudad C on M.ciudad_id = C.id order by C.nombre", null);
            while(cursor.moveToNext()){
                monumentos.add(new Monumento(cursor.getString(0), new Ciudad(cursor.getInt(1), cursor.getString(2))));
            }
        }else{
            Cursor cursor = connexion.rawQuery("SELECT M.nombre, C.id, C.nombre FROM monumento M JOIN ciudad C on M.ciudad_id = C.id order by M.nombre", null);
            while(cursor.moveToNext()){
                monumentos.add(new Monumento(cursor.getString(0), new Ciudad(cursor.getInt(1), cursor.getString(2))));
            }
        }

        return monumentos;
    }
}
