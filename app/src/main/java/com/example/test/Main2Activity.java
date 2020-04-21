package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main2);

                EditText editText4 = (EditText) findViewById(R.id.editText4);
                EditText editText5 = (EditText) findViewById(R.id.editText5);
                EditText editText6 = (EditText) findViewById(R.id.editText6);

                editText4.setText(getIntent().getStringExtra("NAME1"));
                editText5.setText(getIntent().getStringExtra("NAME2"));
                editText6.setText(getIntent().getStringExtra("NAME3"));

    }

    public void displayToast(View v) {
        Toast.makeText(Main2Activity.this, "Successfully saved", Toast.LENGTH_SHORT).show();
    }

    public void displayToast1(View v) {
        Toast.makeText(Main2Activity.this, "Successfully removed", Toast.LENGTH_SHORT).show();
    }


}





