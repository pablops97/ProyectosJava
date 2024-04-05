package Controlador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exament7pabloperezserrano.R;

import java.util.ArrayList;

import Modelo.Monumento;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {

    ArrayList<Monumento> monumentos = new ArrayList<Monumento>();
    Context contexto;


    public Adaptador(ArrayList<Monumento> monumentos, Context contexto) {
        this.monumentos = monumentos;
        this.contexto = contexto;
    }

    @NonNull
    @Override
    public Adaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador.ViewHolder holder, int position) {

        holder.monumento.setText(monumentos.get(position).getNombre());
        holder.ciudad.setText(monumentos.get(position).getCiudad().getNombre());
    }

    @Override
    public int getItemCount() {
        return monumentos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView monumento;
        TextView ciudad;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            monumento = itemView.findViewById(R.id.nombreMonumento);
            ciudad = itemView.findViewById(R.id.nombreCiudad);
        }
    }
}
