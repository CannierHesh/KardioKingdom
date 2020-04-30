package com.example.kardiokingdom;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class payment extends AppCompatActivity {


    EditText cardNo, expiryDate, cvv,holdername;
    Button btnSave1, btnEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment);


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
                if(TextUtils.isEmpty(holdername.getText())) {
                    holdername.setError("Enter Name");
                    holdername.requestFocus();
                }else if(TextUtils.isEmpty(cardNo.getText())){
                    cardNo.setError("Enter Card Number");
                    cardNo.requestFocus();
                }else if(TextUtils.isEmpty(cvv.getText())){
                    cvv.setError("Enter CVV");
                    cvv.requestFocus();
                }
                else if(TextUtils.isEmpty(expiryDate.getText())){
                    expiryDate.setError("Enter Expiry date");
                    expiryDate.requestFocus();
                }
                else {
                    DB pdbHandler = new DB(getApplicationContext());
                    long newID = pdbHandler.addInfo(holdername.getText().toString(), cardNo.getText().toString(), expiryDate.getText().toString(), cvv.getText().toString());
                    Toast.makeText(payment.this, "Details Added under Payment ID: " + newID, Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}
