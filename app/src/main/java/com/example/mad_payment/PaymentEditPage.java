package com.example.mad_payment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class PaymentEditPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_edit_page);
    }
    public void displayToast(View v){
        Toast.makeText(PaymentEditPage.this,"Successfully saved",Toast.LENGTH_SHORT).show();
    }
    public void displayToast1(View v){
        Toast.makeText(PaymentEditPage.this,"Successfully removed",Toast.LENGTH_SHORT).show();
    }
}
