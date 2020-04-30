package com.example.kardiokingdom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {

    EditText mTextUsername;
    EditText mTextPassword;
    Button mButtonLogin;
    Button mTextRegister;
    LoginDatabaseHelper db;
    AlertDialogManager alert = new AlertDialogManager();
    SessionManagement session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new LoginDatabaseHelper(this);

        session = new SessionManagement(getApplicationContext());


        mTextUsername = (EditText)findViewById(R.id.loginusername);
        mTextPassword = (EditText)findViewById(R.id.loginpassword);
        mButtonLogin = (Button)findViewById(R.id.loginbtn);
        mTextRegister = (Button)findViewById(R.id.loginregister);


        mTextRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(login.this, register.class);
                startActivity(i);
            }
        });

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();


                if (user.equals("admin") && pwd.equals("admin123")){
                    session.createLoginSession("admin");
                    Intent adminlogin = new Intent(login.this, adminPanel.class);
                    startActivity(adminlogin);
                    Toast.makeText(login.this, "Successfully Logged In | Admin", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean res = db.checkUser(user,pwd);
                    if (res == true) {

                        session.createLoginSession(user);

                        Intent LoginSuccess = new Intent(login.this, homepage.class);
                        startActivity(LoginSuccess);
                        Toast.makeText(login.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(login.this, "Login Error", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }



}