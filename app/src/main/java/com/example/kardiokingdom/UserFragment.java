package com.example.kardiokingdom;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.HashMap;


public class UserFragment extends Fragment{

    Button mTextuserinfo,exercises,meal,payment;
    TextView username;
    LoginDatabaseHelper db;
    String Username;
    AlertDialogManager alert = new AlertDialogManager();
    SessionManagement session;
    Button logout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_user,container,false);

        session = new SessionManagement(getActivity().getApplicationContext());

        TextView username = (TextView) view.findViewById(R.id.profileUsername);
        logout = (Button) view.findViewById(R.id.logout);

        session.checkLogin();



        HashMap<String, String> user = session.getUserDetails();

        String name = user.get(SessionManagement.KEY_NAME);

        username.setText(Html.fromHtml(name));

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.logoutUser();
            }
        });

        mTextuserinfo = view.findViewById(R.id.userinfo_user);
        exercises = view.findViewById(R.id.exercises);
        meal = view.findViewById(R.id.meal);
        payment = view.findViewById(R.id.payment);

        mTextuserinfo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), userinformation.class);
                startActivity(i);
            }
        });

        exercises.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), video.class);
                startActivity(i);
            }
        });

        meal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), mealplan.class);
                startActivity(i);
            }
        });

        payment.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), payment.class);
                startActivity(i);
            }
        });

        return view;
    }


}

