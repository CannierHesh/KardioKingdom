package com.example.kardiokingdom_binura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addexercises extends AppCompatActivity {

    PDBHandler myDb;
    EditText editExercise,editDescription,editWorkout,editRest,editRound,editThumbnail;
    Button btnAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addexercises);
        myDb = new PDBHandler(this);

        editExercise = (EditText)findViewById(R.id.editText2);
        editDescription = (EditText)findViewById(R.id.editText3);
        editWorkout = (EditText)findViewById(R.id.editText4);
        editRest = (EditText)findViewById(R.id.editText5);
        editRound = (EditText)findViewById(R.id.editText6);


        btnAdd = (Button)findViewById(R.id.button2);
        Add();
    }

    public void Add(){
        btnAdd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Boolean isInserted = myDb.insertData(editExercise.getText().toString(),editDescription.getText().toString(),editWorkout.getText().toString(),editRest.getText().toString(),editRound.getText().toString());
                        if (isInserted = true)
                            Toast.makeText(addexercises.this," MealPlan Added",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(addexercises.this,"Data not Inserted",Toast.LENGTH_LONG).show();


                        Intent intent = new Intent(addexercises.this,MainActivity.class);
                        startActivity(intent);
                    }
                }
        );


    }



}
