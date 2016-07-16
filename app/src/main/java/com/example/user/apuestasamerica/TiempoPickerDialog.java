package com.example.user.apuestasamerica;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;


import java.util.Calendar;

/**
 * Created by User on 16/07/2016.
 */
public class TiempoPickerDialog extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Calendar calendar= Calendar.getInstance();
        final int hora= calendar.get(Calendar.HOUR);
        int minuto= calendar.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                Fragment fragment=getActivity().getSupportFragmentManager().findFragmentByTag("custom");
                Dialog view1=((CustomDialog)fragment).getDialog();
                ((TextView)view1.findViewById(R.id.txtHora)).setText(""+hora+":"+minute);



            }
        }, hora, minuto, DateFormat.is24HourFormat(getActivity()));


    }


}
