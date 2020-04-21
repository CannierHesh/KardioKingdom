package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class Main2Activity extends AppCompatActivity {

    EditText cardNo, expiryDate, cvv,holdername;;
    Button btnSave2, btnRemove, btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        cardNo = findViewById(R.id.editText4);
        cvv = findViewById(R.id.editText6);
        expiryDate = findViewById(R.id.editText5);
        holdername = findViewById(R.id.editText8);
        btnSave2 = (Button) findViewById(R.id.button7);
        btnRemove = (Button) findViewById(R.id.button8);
        btnSearch = (Button) findViewById(R.id.button);


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DB pdbHandler = new DB(getApplicationContext());
                List hname = pdbHandler.readAllInfo(holdername.getText().toString());

                if (hname.isEmpty()){
                    Toast.makeText(Main2Activity.this, "No Details", Toast.LENGTH_SHORT).show();
                    holdername.setText(null);
                }
                else {

                    Toast.makeText(Main2Activity.this, "Details Found of "+hname.get(0).toString(), Toast.LENGTH_SHORT).show();
                    holdername.setText(hname.get(0).toString());
                    cardNo.setText(hname.get(1).toString());
                    expiryDate.setText(hname.get(2).toString());
                    cvv.setText(hname.get(3).toString());



                }

            }
        });

        btnSave2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DB pdbHandler = new DB(getApplicationContext());

                Boolean status = pdbHandler.updateInfo(holdername.getText().toString(),cardNo.getText().toString(),expiryDate.getText().toString(),cvv.getText().toString());
                if (status){
                    Toast.makeText(Main2Activity.this, "Successfully Updated", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Main2Activity.this, "Update Failed", Toast.LENGTH_SHORT).show();
                }

            }
        });


        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               DB pdbHandler = new DB(getApplicationContext());
                pdbHandler.deleteInfo(holdername.getText().toString());

                Toast.makeText(Main2Activity.this, "Successfully Removed", Toast.LENGTH_SHORT).show();

                holdername.setText(null);
                cardNo.setText(null);
                expiryDate.setText(null);
                cvv.setText(null);
            }
        });
    }
}
