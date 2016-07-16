package com.example.user.apuestasamerica;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent,false);
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
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
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
                    context.startActivity(new Intent(context,DetalleActivity.class));

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


            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    /*AlertDialog.Builder builder= new AlertDialog.Builder(context,R.style.MyDialogTheme);
                    builder.setTitle("Dialog");

// CTRL+/
                    //message
// builder.setMessage("aaaa");


*//*
//CTRL +SHIT+/
//Single choice
                    builder.setSingleChoiceItems(context.getResources().getStringArray(R.array.opcionesDialog), 1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(context,""+which,Toast.LENGTH_SHORT).show();
                        }
                    });
*//*

                    //multiple choice
                    *//*boolean b[]={true,false,false};
                    builder.setMultiChoiceItems(context.getResources().getStringArray(R.array.opcionesDialog),b, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            Log.d("xxxx","which "+which+" isChecked:"+isChecked);

                        }
                    });*//*


                    //layout
                    LayoutInflater layoutInflater=((Activity)context).getLayoutInflater();
                    final View view=layoutInflater.inflate(R.layout.dialog_custom,null);
                    builder.setView(view);



                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            RatingBar ratingBar=(RatingBar) view.findViewById(R.id.ratingBar2);
                            //DatePicker datePicker=(DatePicker) view.findViewById(R.id.datePicker);
                           // TimePicker timePicker=(TimePicker) view.findViewById(R.id.timePicker);

                            Log.d("xxxx","ratingBar.getRating(): "+ratingBar.getRating());
                            //Log.d("xxxx","datePicker: "+datePicker.getYear()+"/"+datePicker.getMonth()+"/"+datePicker.getDayOfMonth());

                            //Log.d("xxxx","timePicker: "+timePicker.getHour()+":"+timePicker.getMinute());

                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                    builder.create().show();


*/

                    DialogFragment dialogFragment= new CustomDialog();
                    dialogFragment.show(((AppCompatActivity)context).getSupportFragmentManager(),"custom");
                    return false;
                }
            });


        }
    }

    private void setAnimation(View view,int position){
        Animation animation= AnimationUtils.loadAnimation(context,android.R.anim.slide_in_left);
        view.startAnimation(animation);
    }
}
