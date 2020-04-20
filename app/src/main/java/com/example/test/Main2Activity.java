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

                // Get the Intent that started this activity and extract the string
                Intent intent1 = getIntent();
                String message1 = intent1.getStringExtra(MainActivity.EXTRA_MESSAGE);

                Intent intent2 = getIntent();
                String message2 = intent2.getStringExtra(MainActivity.EXTRA_MESSAGE);

                Intent intent3= getIntent();
                String message3 = intent3.getStringExtra(MainActivity.EXTRA_MESSAGE);

                // Capture the layout's TextView and set the string as its text
                EditText editText4 = findViewById(R.id.editText4);
                editText4.setText(message1);

                EditText editText5 = findViewById(R.id.editText5);
                editText4.setText(message2);

                EditText editText6 = findViewById(R.id.editText6);
                editText4.setText(message3);



    }

    public void displayToast(View v) {
        Toast.makeText(Main2Activity.this, "Successfully saved", Toast.LENGTH_SHORT).show();
    }

    public void displayToast1(View v) {
        Toast.makeText(Main2Activity.this, "Successfully removed", Toast.LENGTH_SHORT).show();
    }


}





