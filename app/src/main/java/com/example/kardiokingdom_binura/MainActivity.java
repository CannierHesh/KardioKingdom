package com.example.kardiokingdom_binura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static  final String TAG = "MainActivity";
    private Button Button;
    private Button Button3;
    private Button Button_add;
    PDBHandler myDb;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.viewall);
        myDb = new PDBHandler(this);

        populateListView();


        Button = (Button)findViewById(R.id.button2);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,addexercises.class);
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

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = adapterView.getItemAtPosition(i).toString();
                Log.d(TAG,"onItemClick:You click on." +name);

                Cursor data = myDb.getItemId(name);
                int itemID = -1;
                String snack = "";
                String lunch ="";
                String snacks ="";
                String dinner ="";
                while (data.moveToNext()) {
                    itemID = data.getInt(0);
                    snack = data.getString(2);
                    lunch = data.getString(3);
                    snacks = data.getString(4);
                    dinner = data.getString(5);

                }
                if(itemID > -1){
                    Log.d(TAG,"onItemClick:The ID is." + itemID);
                    Intent editScreenIntent = new Intent(MainActivity.this,viewall.class);
                    editScreenIntent.putExtra("id",itemID);
                    editScreenIntent.putExtra("breakfast",name);
                    editScreenIntent.putExtra("snack",snack);
                    editScreenIntent.putExtra("lunch",lunch);
                    editScreenIntent.putExtra("snacks",snacks);
                    editScreenIntent.putExtra("dinner",dinner);
                    startActivity(editScreenIntent);
                }
                else {
                    toastMessage("no ID");
                }
            }
        });
    }
    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
