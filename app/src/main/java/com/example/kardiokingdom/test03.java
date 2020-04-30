package com.example.kardiokingdom;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class test03 extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editBreakfast,editSnack,editLunch,editSnacks,editDinner;
    Button btnAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test03);
        myDb = new DatabaseHelper(this);

        editBreakfast = (EditText)findViewById(R.id.editText_b);
        editSnack = (EditText)findViewById(R.id.editText_sn);
        editLunch = (EditText)findViewById(R.id.editText_l);
        editSnacks = (EditText)findViewById(R.id.editText_s);
        editDinner = (EditText)findViewById(R.id.editText_d);
        btnAdd = (Button)findViewById(R.id.button_add);
        Add();
    }

    public void Add(){
        btnAdd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(TextUtils.isEmpty(editBreakfast.getText())){
                            editBreakfast.setError("Please Add a Breakfast");
                            editBreakfast.requestFocus();
                        }
                        else if(TextUtils.isEmpty(editSnack.getText())){
                            editSnack.setError("Please Add a Snack");
                            editSnack.requestFocus();
                        }
                        else if(TextUtils.isEmpty(editLunch.getText())){
                            editLunch.setError("Please Add a lunch");
                            editLunch.requestFocus();
                        }
                        else if(TextUtils.isEmpty(editSnacks.getText())){
                            editSnacks.setError("Please Add a Snack");
                            editSnacks.requestFocus();
                        }
                        else if(TextUtils.isEmpty(editDinner.getText())){
                            editDinner.setError("Please Add a Dinner");
                            editDinner.requestFocus();
                        }
                        else{
                            Boolean isInserted = myDb.insertData(editBreakfast.getText().toString(), editSnack.getText().toString(), editLunch.getText().toString(), editSnacks.getText().toString(), editDinner.getText().toString());
                            if (isInserted = true)
                                Toast.makeText(test03.this, " MealPlan Added", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(test03.this, "Data not Inserted", Toast.LENGTH_LONG).show();


                            Intent intent = new Intent(test03.this, mealplan.class);
                            startActivity(intent);
                        }
                    }
                }
        );


    }



}
