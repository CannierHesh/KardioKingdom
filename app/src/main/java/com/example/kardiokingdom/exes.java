package com.example.kardiokingdom;

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

public class exes extends AppCompatActivity {
    private static  final String TAG = "MainActivity";
    private Button myButton;
    private Button Button3;
    private Button Button_add;
    PDBHandler myDb;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exes);
        mListView = (ListView) findViewById(R.id.listView);
        myDb = new PDBHandler(this);

        populateListView();


        myButton = (Button)findViewById(R.id.button_add);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(exes.this,addexercises.class);
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
                String description = "";
                String workout ="";
                String rest ="";
                String round ="";
                while (data.moveToNext()) {
                    itemID = data.getInt(0);
                    description = data.getString(2);
                    workout = data.getString(3);
                    rest = data.getString(4);
                    round = data.getString(5);

                }
                if(itemID > -1){
                    Log.d(TAG,"onItemClick:The ID is." + itemID);
                    Intent editScreenIntent = new Intent(exes.this,editexercise.class);
                    editScreenIntent.putExtra("id",itemID);
                    editScreenIntent.putExtra("exercise",name);
                    editScreenIntent.putExtra("description",description);
                    editScreenIntent.putExtra("workout",workout);
                    editScreenIntent.putExtra("rest",rest);
                    editScreenIntent.putExtra("round",round);
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
