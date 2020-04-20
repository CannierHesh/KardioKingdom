package com.example.gittest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.example.gittest.R;

public class test04 extends AppCompatActivity {
    private Button Button2;
     DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test04);
        myDb = new DatabaseHelper(this);

        Intent intent = getIntent();
        String message1 = intent.getStringExtra(Edit.EXTRA_MESSAGE);
        String message2 = intent.getStringExtra(Edit.EXTRA_MESSAGE);
        String message3 = intent.getStringExtra(Edit.EXTRA_MESSAGE);
        String message4 = intent.getStringExtra(Edit.EXTRA_MESSAGE);
        String message5 = intent.getStringExtra(Edit.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        EditText editText_b = findViewById(R.id.editText_b);
        editText_b.setText(message1);

        EditText editText_sn = findViewById(R.id.editText_sn);
        editText_sn.setText(message2);

        EditText editText_l = findViewById(R.id.editText_l);
        editText_l.setText(message3);

        EditText editText_s = findViewById(R.id.editText_s);
        editText_s.setText(message4);

        EditText editText_d = findViewById(R.id.editText_d);
        editText_d.setText(message5);



        Button2 = (Button)findViewById(R.id.button2);
        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(test04.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}