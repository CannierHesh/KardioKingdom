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
    private static final String TAG = "test04";
    private Button Button2;
    private EditText editText_b,getEditText_s,getEditText_l,getEditText_sn,getEditText_d;
     DatabaseHelper myDb;

     private int selectedId;
     private String selectedName;
     private String selectedSnacks;
    private String selectedLunch;
    private String selectedSnack;
    private String selectedDinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test04);

////////////////////////////////////////GETTING PREVIOUS PAGE VALUES/////////////////////////////////////////////
        Button2 = (Button)findViewById(R.id.button2);
        EditText editText_b = (EditText) findViewById(R.id.editText_b);
        EditText editText_s = (EditText) findViewById(R.id.editText_sn);
        EditText editText_l = (EditText) findViewById(R.id.editText_l);
        EditText editText_sn = (EditText) findViewById(R.id.editText_s);
        final EditText editText_d = (EditText) findViewById(R.id.editText_d);

        editText_b.setText(getIntent().getStringExtra("BREAKFAST"));
        editText_s.setText(getIntent().getStringExtra("SNACK"));
        editText_l.setText(getIntent().getStringExtra("LUNCH"));
        editText_sn.setText(getIntent().getStringExtra("SNACKS"));
        editText_d.setText(getIntent().getStringExtra("DINNER"));

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        myDb= new DatabaseHelper(this);

        Intent receivedIntent = getIntent();

        selectedId = receivedIntent.getIntExtra("id",-1);
        selectedName = receivedIntent.getStringExtra("name");
        selectedSnacks = receivedIntent.getStringExtra("snacks");
        selectedLunch = receivedIntent.getStringExtra("lunch");
        selectedSnack = receivedIntent.getStringExtra("snack");
        selectedDinner = receivedIntent.getStringExtra("dinner");

        editText_b.setText(selectedName);
        editText_s.setText(selectedSnack);
        editText_l.setText(selectedLunch);
        editText_sn.setText(selectedSnacks);
        editText_d.setText(selectedDinner);



        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item =editText_d.getText().toString();
                if(!item.equals("")){
                    myDb.updateName(item,selectedId,selectedName);
                }
                else {
                    toastMessage("you must enter a dinner");
                }
                Intent intent = new Intent(test04.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void toastMessage(String message){

        Toast.makeText(this,message,  Toast.LENGTH_SHORT).show();
    }
}