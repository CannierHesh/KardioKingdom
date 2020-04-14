package com.example.gittest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Edit extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editBreakfast;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        myDb = new DatabaseHelper(this);
        editBreakfast = (EditText)findViewById(R.id.editText_b);
        btnDelete = (Button)findViewById(R.id.button_Delete);

        DeleteData();
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
