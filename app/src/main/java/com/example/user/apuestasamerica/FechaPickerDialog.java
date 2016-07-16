package com.example.user.apuestasamerica;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by User on 16/07/2016.
 */
public class FechaPickerDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private ListenerOyente oyente;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar calendar= Calendar.getInstance();
        int year= calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        int day= calendar.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(),this,year,month,day);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        oyente=(ListenerOyente)activity;

    }

    interface ListenerOyente{
        public void setearFecha(String fecha);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        Log.d("xxxx","year: "+year);
        Log.d("xxxx","month: "+monthOfYear);
        Log.d("xxxx","day: "+dayOfMonth);
        oyente.setearFecha(""+dayOfMonth+"/"+monthOfYear+"/"+year);

    }
}

