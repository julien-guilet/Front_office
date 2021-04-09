package com.example.front_office;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.front_office.model.Commercial;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private MainActivity main;
    private DatabaseManager bdd;
    private Button monBouton;
    private EditText ediTextuser;
    private EditText ediTextpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bdd = new DatabaseManager(this);
        bdd.InsertionUser(bdd.getWritableDatabase(),"JGUILET","12345","GUILET","Julien","0673313263","guiletjulien@gmail.com");
        setContentView(R.layout.layout_connection);
        this.main = this;
        this.monBouton = (Button) findViewById(R.id.layout_connection_valider);
        monBouton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("Le bouton est enclanché");

                ediTextuser = (EditText) findViewById(R.id.layout_connection_user);
                ediTextpass = (EditText) findViewById(R.id.layout_connection_password);

                Commercial monCommercial  =bdd.selectCommercial(ediTextuser.getText().toString(),ediTextpass.getText().toString(), bdd.getReadableDatabase());
                if (monCommercial.getLogin() == "FALSE"){
                    connectionEchoue(false);
                }else {
                    Intent intent = new Intent(getApplicationContext(), Ctr_layout_accueil.class);
                    startActivity(intent);
                    finish();


                }
            }
        });

         //bdd.onCreate(bdd.getWritableDatabase());
         //bdd.testInsertion(bdd.getWritableDatabase());

         bdd.close();

    }

    public void connectionEchoue(Boolean conn){


        AlertDialog.Builder a = new AlertDialog.Builder(this);a.show();
        a.setMessage("Connection echoué !");
        a.show();


    }

    public DatabaseManager getBdd() {
        return bdd;
    }

    public void setBdd(DatabaseManager bdd) {
        this.bdd = bdd;
    }
}
