package com.example.kardiokingdom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class adminPanel extends AppCompatActivity {
    AlertDialogManager alert = new AlertDialogManager();
    SessionManagement session;
    Button logout, exersices,addexersice,vvideo,addvideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        exersices = (Button)findViewById(R.id.exercises);
        addexersice = (Button)findViewById(R.id.addexercises);
        vvideo = (Button)findViewById(R.id.video);
        addvideo = (Button)findViewById(R.id.addvideo);

        exersices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(adminPanel.this, exes.class);
                startActivity(i);
            }
        });

        addexersice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(adminPanel.this, addexercises.class);
                startActivity(i);
            }
        });

        vvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(adminPanel.this, video.class);
                startActivity(i);
            }
        });

        addvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(adminPanel.this, addVideo.class);
                startActivity(i);
            }
        });

        session = new SessionManagement(getApplicationContext());

        logout = (Button) findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.logoutUser();
            }
        });

    }
}
