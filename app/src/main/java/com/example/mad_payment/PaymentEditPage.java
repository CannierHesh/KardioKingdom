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
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

// Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView2);
        textView.setText(message);

        TextView textView2 = findViewById(R.id.textView2);
        textView2.setText(message);

        TextView textView3 = findViewById(R.id.textView2);
        textView3.setText(message);

    }

    public void displayToast(View v) {
        Toast.makeText(PaymentEditPage.this, "Successfully saved", Toast.LENGTH_SHORT).show();
    }

    public void displayToast1(View v) {
        Toast.makeText(PaymentEditPage.this, "Successfully removed", Toast.LENGTH_SHORT).show();
    }


    }





