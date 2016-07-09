package com.example.user.librarylistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by User on 09/07/2016.
 */
public class AdapterCustom extends ArrayAdapter<Persona> {

    List<Persona> personas;
    int layout;

    public AdapterCustom(Context context, int resource) {
        super(context, resource);
    }

    public AdapterCustom(Context context, int resource, List<Persona> objects) {
        super(context, resource, objects);
        this.personas=objects;
        layout=resource;
    }


    class Holder{
        TextView txtNombre;
        TextView txtApellido;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=convertView;
        if(view==null){
            Holder holder= new Holder();

            LayoutInflater inflater= (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view= inflater.inflate(layout,null);
            holder.txtNombre=(TextView) view.findViewById(R.id.txtNombre);
            holder.txtApellido=(TextView) view.findViewById(R.id.txtApellido);
            view.setTag(holder);


        }

        Persona persona= getItem(position);
        Holder holder=(Holder)view.getTag();
        holder.txtNombre.setText(persona.getNombre());
        holder.txtApellido.setText(persona.getApellido());

        return view;
    }
}
