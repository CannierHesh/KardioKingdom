package com.example.gittest;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.content.Intent;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static  final String TAG = "MainActivity";
    private Button Button;
    private Button Button3;
    private Button Button_add;
    DatabaseHelper myDb;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.listView);
        myDb = new DatabaseHelper(this);

        populateListView();


        Button = (Button)findViewById(R.id.button_add);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,test03.class);
                startActivity(intent);
            }
        });

        Button = (Button) findViewById(R.id.button3);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Edit.class);
                startActivity(intent);
            }
        });
///////////////////////////// VIEW
                    }
           private void populateListView()      {
               Log.d(TAG,"populateListView:display data in the ListView.");
               Cursor data =myDb.getData();
               ArrayList<String> listData = new ArrayList<>();
               while (data.moveToNext()){
                   listData.add(data.getString(1));

               }
               ListAdapter adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listData);
               mListView.setAdapter(adapter);
           }
                    private void toastMessage(String message){
                        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
                    }
}