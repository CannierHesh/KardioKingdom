package com.example.mad_payment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public static final String EXTRA_MESSAGE =
            "com.example.myfirstapp.MESSAGE";






    @Override
    protected void onCreate(Bundle savedInstanceState)
    { super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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