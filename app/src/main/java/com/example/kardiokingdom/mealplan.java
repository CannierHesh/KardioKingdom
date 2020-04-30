package com.example.kardiokingdom;

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

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class mealplan extends AppCompatActivity {
    private static  final String TAG = "MainActivity";
    private Button Button;
    private Button Button3;
    private Button Button_add;
    DatabaseHelper myDb;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mealplan);
        mListView = (ListView) findViewById(R.id.listView);
        myDb = new DatabaseHelper(this);

        populateListView();


        Button = (Button)findViewById(R.id.button_add);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mealplan.this,test03.class);
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
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

               ListAdapter adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listData);
               mListView.setAdapter(adapter);



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
                           Intent editScreenIntent = new Intent(mealplan.this,Edit.class);
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