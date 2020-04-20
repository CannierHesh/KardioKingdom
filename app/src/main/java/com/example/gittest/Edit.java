package com.example.gittest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class Edit extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editBreakfast,editSnack,editLunch,editSnacks,editDinner;
    Button btnDelete;
    Button btnEdit;
    public static final String EXTRA_MESSAGE = "com.example.gittest.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        myDb = new DatabaseHelper(this);
        editBreakfast = (EditText)findViewById(R.id.editText_b);
        editSnack = (EditText)findViewById(R.id.editText_sn);
        editLunch = (EditText)findViewById(R.id.editText_l);
        editSnacks = (EditText)findViewById(R.id.editText_s);
        editDinner = (EditText)findViewById(R.id.editText_d);

        //DELETE

        btnDelete = (Button)findViewById(R.id.button_Delete);
        btnEdit = (Button)findViewById(R.id.button_Edit);

        myDb = new DatabaseHelper(this);
        DeleteData();

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editBreakfast = (EditText) findViewById(R.id.editText_b);
                String message1 = editBreakfast.getText().toString();

                editSnack = (EditText) findViewById(R.id.editText_sn);
                String message2 = editSnack.getText().toString();

                editLunch = (EditText) findViewById(R.id.editText_l);
                String message3 = editLunch.getText().toString();

                editSnacks = (EditText) findViewById(R.id.editText_s);
                String message4 = editSnacks.getText().toString();

                editDinner = (EditText) findViewById(R.id.editText_d);
                String message5 = editDinner.getText().toString();

                Intent intent = new Intent(Edit.this,test04.class);
                intent.putExtra("BREAKFAST",message1);
                intent.putExtra("SNACK",message2);
                intent.putExtra("LUNCH",message3);
                intent.putExtra("SNACKS",message4);
                intent.putExtra("DINNER",message5);
                startActivity(intent);
            }
        });

    }

public void DeleteData(){

    btnDelete.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Integer deleteRows = myDb.deleteData(editBreakfast.getText().toString());
            if (deleteRows >0)

                    Toast.makeText(Edit.this," MealPlan Deleted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Edit.this,"Data not Deleted",Toast.LENGTH_LONG).show();

        }
    });
}

}
