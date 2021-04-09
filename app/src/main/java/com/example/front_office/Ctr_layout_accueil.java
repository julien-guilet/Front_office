package com.example.front_office;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Ctr_layout_accueil extends AppCompatActivity {

    private Button monBouton ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_accueil);
        this.monBouton = (Button) findViewById(R.id.layout_accueil_addvisiteur);

    }
}
