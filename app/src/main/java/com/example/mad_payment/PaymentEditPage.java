package com.example.mad_payment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class PaymentEditPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_edit_page);

        // Get the Intent that started this activity and extract the string
        Intent intent1 = getIntent();
        String message1 = intent1.getStringExtra(MainActivity.EXTRA_MESSAGE);
        Intent intent2 = getIntent();
        String message2 = intent2.getStringExtra(MainActivity.EXTRA_MESSAGE);
        Intent intent3 = getIntent();
        String message3 = intent3.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView1 = findViewById(R.id.textView1);
        textView1.setText(message1);

        TextView textView2 = findViewById(R.id.textView2);
        textView2.setText(message2);

        TextView textView3 = findViewById(R.id.textView3);
        textView3.setText(message3);

    }

    public void displayToast(View v) {
        Toast.makeText(PaymentEditPage.this, "Successfully saved", Toast.LENGTH_SHORT).show();
    }

    public void displayToast1(View v) {
        Toast.makeText(PaymentEditPage.this, "Successfully removed", Toast.LENGTH_SHORT).show();
    }


    }





