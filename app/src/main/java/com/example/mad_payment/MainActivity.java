package com.example.mad_payment;

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

    TextView cardNo, expiryDate, cvv;
    Button btnSave1, btnEdit, btnRemove, btnSave2;
    DBHandler myDb;
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    { super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DBHandler(this);
        cardNo= findViewById(R.id.editText);
        expiryDate= findViewById(R.id.editText2);
        cvv = findViewById(R.id.editText3);
        btnSave1= findViewById(R.id.button2);
        btnEdit= findViewById(R.id.button);
        btnRemove= findViewById(R.id.button4);
        btnSave2= findViewById(R.id.button3);


    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, PaymentEditPage.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message); startActivity(intent);

        EditText editText2 = (EditText) findViewById(R.id.editText2);
        String message2 = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message); startActivity(intent);

        EditText editText3 = (EditText) findViewById(R.id.editText3);
        String message3 = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message); startActivity(intent);

    }


    @Override
    protected void onResume() {
        super.onResume();
        btnSave1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myDb.addInfo(cardNo.getText().toString(), expiryDate.getText().toString(), cvv.getText().toString())){
                    Toast.makeText(MainActivity.this,"Inserted successfully",Toast.LENGTH_LONG).show();
                } else
                    Toast.makeText(MainActivity.this,"Invalid insert",Toast.LENGTH_LONG).show();

            }
        });



        btnSave1.setOnClickListener(new View.OnClickListener() {
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

}















