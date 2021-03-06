package com.example.kardiokingdom;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class HomeFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home,container,false);

        String date_n = new SimpleDateFormat("MMMM dd", Locale.getDefault()).format(new Date());

        TextView date = (TextView) view.findViewById(R.id.dateText2);
        date.setText(date_n);

        return view;
    }


}
