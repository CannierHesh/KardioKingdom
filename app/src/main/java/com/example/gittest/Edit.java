package com.example.gittest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Edit extends AppCompatActivity {
     private Button Button7;
    private Button Button8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Button7 = (Button)findViewById(R.id.button7);
        Button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Edit.this,test04.class);
                startActivity(intent);
            }
        });

        Button8 = (Button)findViewById(R.id.button8);
        Button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Edit.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
