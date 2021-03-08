package com.example.front_office;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton logoaccueil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.logoaccueil = (ImageButton) findViewById(R.id.logoaccueil);
        logoaccueil.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent chargementConnection = new Intent(getApplicationContext(), Connection.class);
                   startActivity(chargementConnection);
                   finish();

               }
           }

        );


    }
}
