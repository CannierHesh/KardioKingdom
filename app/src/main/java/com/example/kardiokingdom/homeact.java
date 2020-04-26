package com.example.kardiokingdom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class homeact extends AppCompatActivity {


    DatabaseHelper db;
    EditText mTextUsername;
    EditText mTextEmail;
    EditText mTextPassword;
    Button mButtonRegister;
    Button mTextLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeact);

        db = new DatabaseHelper(this);

        mTextUsername = (EditText)findViewById(R.id.regusername);
        mTextEmail = (EditText)findViewById(R.id.regemail);
        mTextPassword = (EditText)findViewById(R.id.regpassword);
        mButtonRegister = (Button)findViewById(R.id.regbtn);
        mTextLogin = (Button)findViewById(R.id.reglogin);

        mTextLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(homeact.this, login.class);
                startActivity(i);
            }
        });

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = mTextUsername.getText().toString().trim();
                String email = mTextEmail.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();

                if(pwd == null){
                    Toast.makeText(homeact.this, "Registration Error", Toast.LENGTH_SHORT).show();
                }
                else{
                    long val = db.addUser(user,email,pwd);
                    if (val > 0) {
                        Toast.makeText(homeact.this, "Registration Success", Toast.LENGTH_SHORT).show();
                        Intent moveToLogin = new Intent(homeact.this,login.class);
                        startActivity(moveToLogin);
                    } else{
                        Toast.makeText(homeact.this, "Registration Error", Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });
    }





}
