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

    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, test04.class);
        EditText editText_b = (EditText) findViewById(R.id.editText_b);
        String message1 = editText_b.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message1); startActivity(intent);

        EditText editText_sn = (EditText) findViewById(R.id.editText_sn);
        String message2 = editText_sn.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message2); startActivity(intent);

        EditText editText_l = (EditText) findViewById(R.id.editText_l);
        String message3 = editText_l.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message3); startActivity(intent);

        EditText editText_s = (EditText) findViewById(R.id.editText_s);
        String message4 = editText_s.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message4); startActivity(intent);

        EditText editText_d = (EditText) findViewById(R.id.editText_d);
        String message5 = editText_d.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message5); startActivity(intent);



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
