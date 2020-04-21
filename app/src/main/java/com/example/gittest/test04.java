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

        EditText editText_b = (EditText) findViewById(R.id.editText_b);
        EditText editText_s = (EditText) findViewById(R.id.editText_sn);
        EditText editText_l = (EditText) findViewById(R.id.editText_l);
        EditText editText_sn = (EditText) findViewById(R.id.editText_s);
        EditText editText_d = (EditText) findViewById(R.id.editText_d);

        editText_b.setText(getIntent().getStringExtra("BREAKFAST"));
        editText_s.setText(getIntent().getStringExtra("SNACK"));
        editText_l.setText(getIntent().getStringExtra("LUNCH"));
        editText_sn.setText(getIntent().getStringExtra("SNACKS"));
        editText_d.setText(getIntent().getStringExtra("DINNER"));





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