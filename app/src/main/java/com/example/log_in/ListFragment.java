package com.example.log_in;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment implements SearchView.OnQueryTextListener {

    ListView listView;
    ArrayList<String> nameList = new ArrayList<>();
    List<Resident> residentArrayList;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        DbHandler dbHandler = new DbHandler(getActivity());
        residentArrayList = dbHandler.getAllResidents();

        for (int i=0; i < residentArrayList.size(); i++)
        {
            nameList.add(residentArrayList.get(i).getFirstName() + " " +residentArrayList.get(i).getLastName());
        }


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list,container,false);

        Toolbar toolbar = (Toolbar)view.findViewById(R.id.fg_app_bar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Resident list");

        listView = (ListView) view.findViewById(R.id.fg_listview);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1,nameList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                accessActivity5(residentArrayList,i);
            }

        });

        return view;
    }

    public void accessActivity5(List<Resident> residentArrayList,int i) {
        Intent intent = new Intent (getActivity(), Activity5.class);
        Resident resident = residentArrayList.get(i);
        intent.putExtra("resident", resident);
        startActivity(intent);

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
