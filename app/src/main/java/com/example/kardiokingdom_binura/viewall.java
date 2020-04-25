package com.example.kardiokingdom_binura;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class viewall extends AppCompatActivity {

    PDBHandler myDb;
    EditText editExercise,editDescription,editWorkout,editRest,editRound;
    Button btnAdd;
    private int selectedID;
    private String selectedName;
    public static final String EXTRA_MESSAGE = "com.example.gittest.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewall);

        myDb = new PDBHandler(this);
        editExercise = (EditText)findViewById(R.id.editText2);
        editDescription = (EditText)findViewById(R.id.editText3);
        editWorkout = (EditText)findViewById(R.id.editText4);
        editRest = (EditText)findViewById(R.id.editText5);
        editRound = (EditText)findViewById(R.id.editText7);

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
        editRest.setText(selectedName);

        //DELETE

        btnAdd = (Button)findViewById(R.id.button2);

        DeleteData();

        myDb = new PDBHandler(this);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editExercise = (EditText) findViewById(R.id.editText2);
                String message1 = editExercise.getText().toString();

                editDescription = (EditText) findViewById(R.id.editText3);
                String message2 = editDescription.getText().toString();

                editWorkout = (EditText) findViewById(R.id.editText4);
                String message3 = editWorkout.getText().toString();

                editRest = (EditText) findViewById(R.id.editText5);
                String message4 = editRest.getText().toString();

                editRound = (EditText) findViewById(R.id.editText6);
                String message5 = editRound.getText().toString();

                Intent intent = new Intent(viewall.this,addexercises.class);
                intent.putExtra("EXERCISE",message1);
                intent.putExtra("DESCRIPTION",message2);
                intent.putExtra("WORKOUT",message3);
                intent.putExtra("REST",message4);
                intent.putExtra("ROUND",message5);
                startActivity(intent);

            }
        });


    }
    public void DeleteData(){
        btnAdd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deleteRows = myDb.deleteData(editExercise.getText().toString());
                        if(deleteRows > 0) {
                            Toast.makeText(viewall.this, "Data Deleted !!", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(viewall.this,MainActivity.class);
                            startActivity(intent);
                        }

                        else
                            Toast.makeText(viewall.this, "Data not Deleted !!", Toast.LENGTH_SHORT).show();

                    }

                }


        );
    }



}
