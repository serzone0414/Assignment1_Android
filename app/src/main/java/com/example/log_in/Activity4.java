package com.example.log_in;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity4 extends AppCompatActivity {
    ListView listView;
    ArrayList<Resident> residentArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        Toolbar toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Resident list");

        // get the Class object from the other activity
        Intent intent = getIntent();
        residentArrayList = (ArrayList<Resident>) intent.getSerializableExtra("resident");
        ArrayList<String> nameList = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listView);

        for (int i=0; i < residentArrayList.size(); i++)
        {
            nameList.add(residentArrayList.get(i).getFirstName() + " " +residentArrayList.get(i).getLastName());
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,nameList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                accessActivity5(i);
            }

        });
    }
    public void accessActivity5(int i) {
        Intent intent = new Intent (this, Activity5.class);
        Resident resident = residentArrayList.get(i);
        intent.putExtra("resident", resident);
        startActivity(intent);
    }
}