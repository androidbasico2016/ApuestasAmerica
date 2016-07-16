package com.example.user.apuestasamerica;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RatingBar;

/**
 * Created by User on 16/07/2016.
 */
public class CustomDialog extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.MyDialogTheme);
        builder.setTitle("Dialog");

// CTRL+/
        //message
// builder.setMessage("aaaa");


/*
//CTRL +SHIT+/
//Single choice
                    builder.setSingleChoiceItems(context.getResources().getStringArray(R.array.opcionesDialog), 1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(context,""+which,Toast.LENGTH_SHORT).show();
                        }
                    });
*/

        //multiple choice
                    /*boolean b[]={true,false,false};
                    builder.setMultiChoiceItems(context.getResources().getStringArray(R.array.opcionesDialog),b, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            Log.d("xxxx","which "+which+" isChecked:"+isChecked);

                        }
                    });*/


        //layout
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        final View view = layoutInflater.inflate(R.layout.dialog_custom, null);
        builder.setView(view);


        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                RatingBar ratingBar = (RatingBar) view.findViewById(R.id.ratingBar2);
                //DatePicker datePicker=(DatePicker) view.findViewById(R.id.datePicker);
                // TimePicker timePicker=(TimePicker) view.findViewById(R.id.timePicker);

                Log.d("xxxx", "ratingBar.getRating(): " + ratingBar.getRating());
                //Log.d("xxxx","datePicker: "+datePicker.getYear()+"/"+datePicker.getMonth()+"/"+datePicker.getDayOfMonth());

                //Log.d("xxxx","timePicker: "+timePicker.getHour()+":"+timePicker.getMinute());

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        return builder.create();

    }
}
