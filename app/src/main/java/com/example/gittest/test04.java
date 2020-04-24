package com.example.gittest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.gittest.R;

public class test04 extends AppCompatActivity {

     Button Button2;
     EditText editTextb,editTexts,editTextl,editTextsn,editTextd;
     DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test04);

////////////////////////////////////////GETTING PREVIOUS PAGE VALUES/////////////////////////////////////////////


         editTextb = (EditText) findViewById(R.id.editText_b);
         editTexts = (EditText) findViewById(R.id.editText_sn);
         editTextl = (EditText) findViewById(R.id.editText_l);
         editTextsn = (EditText) findViewById(R.id.editText_s);
         editTextd = (EditText) findViewById(R.id.editText_d);


        editTextb.setText(getIntent().getStringExtra("BREAKFAST"));
        editTexts.setText(getIntent().getStringExtra("SNACK"));
        editTextl.setText(getIntent().getStringExtra("LUNCH"));
        editTextsn.setText(getIntent().getStringExtra("SNACKS"));
        editTextd.setText(getIntent().getStringExtra("DINNER"));

        Button2 = (Button)findViewById(R.id.button2);

        myDb = new DatabaseHelper(this);

        editTextb = (EditText) findViewById(R.id.editText_b);
        editTexts = (EditText) findViewById(R.id.editText_sn);
        editTextl = (EditText) findViewById(R.id.editText_l);
        editTextsn = (EditText) findViewById(R.id.editText_s);
        editTextd = (EditText) findViewById(R.id.editText_d);

        UpdateData();


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    }
    public void UpdateData(){
        Button2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdated = myDb.updateData(editTextb.getText().toString(),editTexts.getText().toString(),editTextl.getText().toString(),editTextsn.getText().toString(),editTextd.getText().toString());
                        if(isUpdated == true) {
                            Toast.makeText(test04.this, "Your Meal plan Updated", Toast.LENGTH_LONG).show();

                            Intent intent = new Intent(test04.this, MainActivity.class);
                            startActivity(intent);
                        }

                        else
                            Toast.makeText(test04.this, "Data not Updated!", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }


}