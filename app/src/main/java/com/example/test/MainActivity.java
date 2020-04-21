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

    EditText cardNo, expiryDate, cvv;
    Button btnSave1, btnEdit, btnRemove, btnSave2,btnView;
    DB myDb;
    String description= "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DB(this);
        cardNo = findViewById(R.id.editText);
        cvv = findViewById(R.id.editText2);
        expiryDate = findViewById(R.id.editText3);
        btnSave1 = (Button) findViewById(R.id.button3);
        btnEdit = (Button) findViewById(R.id.button4);
        btnRemove = (Button) findViewById(R.id.button7);
        btnSave2 = (Button) findViewById(R.id.button8);
        btnView = (Button) findViewById(R.id.button);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    cardNo = (EditText) findViewById(R.id.editText);
                    String message1 = cardNo.getText().toString();

                    cvv = (EditText) findViewById(R.id.editText2);
                    String message2 = cvv.getText().toString();

                    expiryDate = (EditText) findViewById(R.id.editText3);
                    String message3 = expiryDate.getText().toString();

                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    intent.putExtra("DESCRIPTION", description);
                    intent.putExtra("NAME1", message1);
                    intent.putExtra("NAME2", message2);
                    intent.putExtra("NAME3", message3);
                    startActivity(intent);

                }
        });


    }


    @Override
    protected void onResume() {
        super.onResume();
        btnSave1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myDb.addInfo(cardNo.getText().toString(),cvv.getText().toString(), expiryDate.getText().toString() )){
                    Toast.makeText(MainActivity.this,"Inserted successfully",Toast.LENGTH_LONG).show();
                } else
                    Toast.makeText(MainActivity.this,"Invalid insert",Toast.LENGTH_LONG).show();

            }


        });


        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor newRowId = myDb.readAllInfo();
                if(newRowId!= null) {
                    while (newRowId.moveToNext()) {
                        Log.d("User record", "User" + newRowId.getString(2) + newRowId.getString(2));
                    }

                }else
                    showMessage();
            }
        });
    }

    private void showMessage() {
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Error");
        builder.setMessage("No user available");
        builder.show();
    }




    public void displayToast(View v) {
        Toast.makeText(MainActivity.this, "Successfully saved", Toast.LENGTH_SHORT).show();
    }

    public void displayToast1(View v) {
        Toast.makeText(MainActivity.this, "Successfully removed", Toast.LENGTH_SHORT).show();
    }
}















