package com.example.kardiokingdom_binura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.EditTextPreference;
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
        selectedName= receivedIntent.getStringExtra("EXERCISE");
        editExercise.setText(selectedName);

        selectedName= receivedIntent.getStringExtra("DESCRIPTION");
        editDescription.setText(selectedName);

        selectedName= receivedIntent.getStringExtra("WORKOUT");
        editWorkout.setText(selectedName);

        selectedName= receivedIntent.getStringExtra("REST");
        editRest.setText(selectedName);

        selectedName= receivedIntent.getStringExtra("ROUND");
        editRound.setText(selectedName);

        //DELETE

        Button4 = (Button)findViewById(R.id.button4);
        Button3 = (Button)findViewById(R.id.button3);
        DeleteData();

        myDb = new PDBHandler(this);


        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editExercise = (EditText) findViewById(R.id.editText);
                String message1 = editExercise.getText().toString();

                editDescription = (EditText) findViewById(R.id.editText7);
                String message2 = editDescription.getText().toString();

                editWorkout = (EditText) findViewById(R.id.editText8);
                String message3 = editWorkout.getText().toString();

                editRest = (EditText) findViewById(R.id.editText9);
                String message4 = editRest.getText().toString();

                editRound = (EditText) findViewById(R.id.editText10);
                String message5 = editRound.getText().toString();

                Intent intent = new Intent(editexercise.this,viewall.class);
                intent.putExtra("EXERCISE",message1);
                intent.putExtra("DESCRIPTION",message2);
                intent.putExtra("WORKOUT",message3);
                intent.putExtra("REST",message4);
                intent.putExtra("ROUND",message5);
                startActivity(intent);

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








