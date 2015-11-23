package com.capstone.jhea.classmanager;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Che Balane on 11/19/2015.
 */
public class ScheduleFragment extends Fragment{

    Calendar calendar;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mainView = inflater.inflate(R.layout.fragment_schedule, container, false);

        TextView date = (TextView) mainView.findViewById(R.id.date);

        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd-MMM-yyy");
        Date d = new Date();
        String day = sdf.format(d);

        date.setText(day);

        return mainView;

    }
}
