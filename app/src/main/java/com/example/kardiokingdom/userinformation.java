package com.example.kardiokingdom;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class userinformation extends AppCompatActivity {
    AlertDialogManager alert = new AlertDialogManager();
    SessionManagement session;
    Button logout,btnRemove;
    EditText prouser,proemail,propw;
    String name;
    LoginDatabaseHelper del;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinformation);

        session = new SessionManagement(getApplicationContext());
        TextView username = (TextView) findViewById(R.id.profileUsername);
        logout = (Button) findViewById(R.id.logout);
        btnRemove = (Button) findViewById(R.id.delete);

        session.checkLogin();

        HashMap<String, String> user = session.getUserDetails();

        name = user.get(SessionManagement.KEY_NAME);

        username.setText(Html.fromHtml(name));


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.logoutUser();
            }
        });

    }

}
