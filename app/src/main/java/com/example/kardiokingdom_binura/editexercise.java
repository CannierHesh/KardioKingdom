package com.example.kardiokingdom_binura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class editexercise extends AppCompatActivity {
    PDBHandler myDb;
    EditText editExercise,editDescription,editWorkout,editRest,editRound,editThumbnail;
    Button Button3;
    Button Button4;
    private int selectedID;
    private String selectedName;
    public static final String EXTRA_MESSAGE = "com.example.gittest.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editexercise);

        myDb = new PDBHandler(this);
        editExercise = (EditText)findViewById(R.id.editText);
        editDescription = (EditText)findViewById(R.id.editText7);
        editWorkout = (EditText)findViewById(R.id.editText8);
        editRest = (EditText)findViewById(R.id.editText9);
        editRound = (EditText)findViewById(R.id.editText10);

        //GET
        Intent receivedIntent = getIntent();
        selectedID = receivedIntent.getIntExtra("id",-1);
        selectedName= receivedIntent.getStringExtra("exercise");
        editExercise.setText(selectedName);

        selectedName= receivedIntent.getStringExtra("description");
        editDescription.setText(selectedName);

        selectedName= receivedIntent.getStringExtra("workout");
        editWorkout.setText(selectedName);

        selectedName= receivedIntent.getStringExtra("rest");
        editRest.setText(selectedName);

        selectedName= receivedIntent.getStringExtra("round");
        editRound.setText(selectedName);

        //DELETE

        Button4 = (Button)findViewById(R.id.button4);
        Button3 = (Button)findViewById(R.id.button);
        DeleteData();

        myDb = new PDBHandler(this);

               Button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        PDBHandler pdbHandler = new PDBHandler(getApplicationContext());
                        editExercise = (EditText) findViewById(R.id.editText);
                        editDescription = (EditText) findViewById(R.id.editText7);
                        editWorkout = (EditText) findViewById(R.id.editText8);
                        editRest = (EditText) findViewById(R.id.editText9);
                        editRound = (EditText) findViewById(R.id.editText10);

                       Boolean status = pdbHandler.updateData(editExercise.getText().toString(),editDescription.getText().toString(),editWorkout.getText().toString(),editRest.getText().toString(),editRound.getText().toString());
                        if (status){
                            Toast.makeText(editexercise.this, "Successfully Updated", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(editexercise.this, "Update Failed", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }

    public void DeleteData() {
        Button4.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deleteRows = myDb.deleteData(editExercise.getText().toString());
                        if (deleteRows > 0) {
                            Toast.makeText(editexercise.this, "Data Deleted !!", Toast.LENGTH_SHORT).show();


                            Intent intent = new Intent(editexercise.this, MainActivity.class);
                            startActivity(intent);
                        } else
                            Toast.makeText(editexercise.this, "Data not Deleted !!", Toast.LENGTH_SHORT).show();

                    }

                }


        );
    }
}








