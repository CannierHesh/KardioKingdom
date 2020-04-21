package com.example.test;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText cardNo, expiryDate, cvv,holdername;
    Button btnSave1, btnEdit;

    String description= "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cardNo = findViewById(R.id.editText);
        cvv = findViewById(R.id.editText2);
        expiryDate = findViewById(R.id.editText3);
        holdername = findViewById(R.id.editText7);
        btnSave1 = (Button) findViewById(R.id.button3);
        btnEdit = (Button) findViewById(R.id.button4);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Main2Activity.class);
                holdername.setText(null);
                cardNo.setText(null);
                expiryDate.setText(null);
                cvv.setText(null);
                startActivity(i);
            }
        });

        btnSave1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                DB pdbHandler = new DB(getApplicationContext());
                long newID = pdbHandler.addInfo(holdername.getText().toString(),cardNo.getText().toString(),expiryDate.getText().toString(),cvv.getText().toString());
                Toast.makeText(MainActivity.this, "Details Added under Payment ID: "+ newID, Toast.LENGTH_SHORT).show();


            }
        });




    }
}
