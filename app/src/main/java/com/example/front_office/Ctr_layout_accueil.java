package com.example.front_office;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Ctr_layout_accueil extends AppCompatActivity {

    private ImageView addvisiteur ;
    private ImageView visiteur ;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_accueil);
        this.addvisiteur = (ImageView) findViewById(R.id.layout_accueil_addvisiteur);
        this.visiteur = (ImageView) findViewById(R.id.layout_accueil_getvisiteurs);
        addvisiteur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Ctr_layout_ajout_visiteur.class);
                startActivity(intent);
                finish();
            }
        });
        visiteur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Ctr_layout_visiteurs.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
