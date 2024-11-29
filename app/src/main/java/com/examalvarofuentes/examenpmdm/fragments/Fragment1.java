package com.examalvarofuentes.examenpmdm.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.examalvarofuentes.examenpmdm.R;

public class Fragment1 extends Fragment {

    String[] arrarNombres = {"Juan","Pedro","Jaime","Paula","Lucía","Alberto","Ramiro"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        TextView texto = view.findViewById(R.id.textRandom);
        Button button = view.findViewById(R.id.buttonRandom);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                texto.setText(arrarNombres[(int) Math.floor(Math.random() * 7)]);
            }
        });

        return view;
    }
}



