package com.example.front_office;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ctr_layout_connection extends AppCompatActivity {

    private Button monBouton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        this.monBouton = (Button) findViewById(R.id.layout_connection_valider);
        monBouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Le bouton est enclanché");

            }
        });
    }
}