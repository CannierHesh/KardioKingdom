package com.example.mad_payment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button =(Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenActivity2();
            }
        });
    }
    public void OpenActivity2(){
        Intent intent= new Intent(this, PaymentEditPage.class);
        startActivity(intent);
    }
    public void displayToast(View v){
        Toast.makeText(MainActivity.this,"Successfully saved",Toast.LENGTH_SHORT).show();
    }
    public void displayToast1(View v){
        Toast.makeText(MainActivity.this,"Successfully removed",Toast.LENGTH_SHORT).show();
    }
}
