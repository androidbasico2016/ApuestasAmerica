package com.example.user.apuestasamerica;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by User on 26/03/2016.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.CustomViewHolder> {

    private Context context;
    private List<Pais> data;

    public MyRecyclerAdapter(Context context, List<Pais> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row, null);
        CustomViewHolder customViewHolder = new CustomViewHolder(view);
        return customViewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Pais fila = data.get(position);
        holder.txtNombre.setText(fila.getNombre());
        holder.txtUbicacion.setText(fila.getDescripcion());
        holder.imgPais.setImageResource(fila.getImagen());
        setAnimation(holder.imgPais.getRootView(),position);
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView txtNombre;
        protected TextView txtUbicacion;
        protected ImageView imgPais;
        protected Button btnEliminar;

        public CustomViewHolder(View itemView) {
            super(itemView);
            this.txtNombre = (TextView) itemView.findViewById(R.id.txtPais);
            this.txtUbicacion = (TextView) itemView.findViewById(R.id.txtUbicacion);
            this.imgPais = (ImageView) itemView.findViewById(R.id.imgPais);
            this.btnEliminar = (Button) itemView.findViewById(R.id.btnEliminar);

            imgPais.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int i= getAdapterPosition();

                    Log.d("xxxx","llego "+data.get(i).getNombre());
                }
            });

            btnEliminar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position= getAdapterPosition();
                    data.remove(position);
                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position,data.size());
                }
            });


        }
    }

    private void setAnimation(View view,int position){
        Animation animation= AnimationUtils.loadAnimation(context,android.R.anim.slide_in_left);
        view.startAnimation(animation);
    }
}


//para insertar

/* animalsList.add(position,"" + itemLabel);
mAdapter.notifyItemInserted(position);
 // Scroll to newly added item position
mRecyclerView.scrollToPosition(position);*/
