package com.example.log_in;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NewFragment extends Fragment {
    Button newResidentButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new, container,false);
        newResidentButton = view.findViewById(R.id.fg_newResidentButtton);

        newResidentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accessActivity3();
            }
        });
        return view;
    }

    private void accessActivity3() {
        Intent intent = new Intent( getActivity(),Activity3.class);
        startActivity(intent);
    }
}
