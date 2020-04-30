package com.example.kardiokingdom_binura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class viewall extends AppCompatActivity {

    Button Button2;
    EditText editExercise,editDescription,editWorkout,editRest,editRound,editThumbnail;
    PDBHandler myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editexercise);

////////////////////////////////////////GETTING PREVIOUS PAGE VALUES/////////////////////////////////////////////


        editExercise = (EditText) findViewById(R.id.editText);
        editDescription = (EditText) findViewById(R.id.editText7);
        editWorkout = (EditText) findViewById(R.id.editText8);
        editRest = (EditText) findViewById(R.id.editText9);
        editRound = (EditText) findViewById(R.id.editText10);


        editExercise.setText(getIntent().getStringExtra("EXERCISE"));
        editDescription.setText(getIntent().getStringExtra("DESCRIPTION"));
        editWorkout.setText(getIntent().getStringExtra("WORKOUT"));
        editRest.setText(getIntent().getStringExtra("REST"));
        editRound.setText(getIntent().getStringExtra("ROUND"));

        Button2 = (Button)findViewById(R.id.button5);

        myDb = new PDBHandler(this);

        editExercise = (EditText) findViewById(R.id.editText);
        editDescription = (EditText) findViewById(R.id.editText7);
        editWorkout = (EditText) findViewById(R.id.editText8);
        editRest = (EditText) findViewById(R.id.editText9);
        editRound = (EditText) findViewById(R.id.editText10);

        UpdateData();



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    }
    public void UpdateData(){
        Button2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdated = myDb.updateData(editExercise.getText().toString(),editDescription.getText().toString(),editWorkout.getText().toString(),editRest.getText().toString(),editRound.getText().toString());
                        if(isUpdated == true) {
                            Toast.makeText(viewall.this, "Your Exercise plan Updated", Toast.LENGTH_LONG).show();

                            Intent intent = new Intent(viewall.this, MainActivity.class);
                            startActivity(intent);
                        }

                        else
                            Toast.makeText(viewall.this, "Data not Updated!", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

}
