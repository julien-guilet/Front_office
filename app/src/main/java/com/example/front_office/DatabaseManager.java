package com.example.front_office;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.front_office.model.Commercial;


public class DatabaseManager extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "HEVENT_BDD.db";
    private static final int DATABASE_VERSION = 1;


    public DatabaseManager(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        System.out.println("CREATION de lobjet !");


    }



    @Override
    public void onCreate(SQLiteDatabase db){

        System.out.println("TENTATION DE CREATION");
        String creationTableEvenement = "CREATE TABLE EVENEMENT" +
                " (" +
                "NOM  Varchar," +
                "LIEU  Varchar(255)   ," +
                "DATEDEBUT Date(12)   ," +
                "DATEFIN Date(12)   " +
                ", PRIMARY KEY (NOM) " +
                " ) ;";

        String creationTableCommercial = "create table commercial ("
                +"LOGIN varchar(32)  ," +
                "   PASSWORD varchar(32) ," +
                "   NOM varchar(32)  ," +
                "   PRENOM varchar(32)," +
                "   TEL varchar(10) ," +
                "   EMAIL varchar(32) " +
                "   , PRIMARY KEY (LOGIN)" +
                ");";

        String creationTableProjet = "create table projet ("
                +"LIBELLE varchar(32)," +
                "   DESCRIPTION varchar(255)" +
                "   , PRIMARY KEY (LIBELLE) " +
                ");";

        String creationTableEntreprise = "create table entreprise ("+
                " RAISON_SOCIALE varchar(32)," +
                "   SIRET  varchar(32)" +
                "   , PRIMARY KEY (RAISON_SOCIALE) " +
                ");";

        String creationTableProspect = "create table prospect ("
                +"RAISON_SOCIALE  varchar(32) ," +
                "   NOM  varchar(32)," +
                "   PRENOM varchar(32)," +
                "   TEL  varchar(10)   ," +
                "   MAIL  varchar(32)   ," +
                "   NOTES  varchar(255)  ," +
                "   ID_PROSPECT integer" +
                "   , PRIMARY KEY (ID_PROSPECT), " +
                "FOREIGN KEY(RAISON_SOCIALE) REFERENCES ENTREPRISE (RAISON_SOCIALE)"+
                ");";

        String creationTableParticipe = "CREATE TABLE participe ("
                +"RAISON_SOCIALE  varchar(32) ," +
                "   NOM  varchar(32)," +
                "   PRENOM varchar(32)," +
                "   TEL  varchar(10)   ," +
                "   MAIL  varchar(32)   ," +
                "   NOTES  varchar(255)  ," +
                "   ID_PROSPECT integer" +
                "   , PRIMARY KEY (ID_PROSPECT), " +
                "FOREIGN KEY(NOM) REFERENCES EVENEMENT (NOM),"+
                "FOREIGN KEY(ID_PROSPECT) REFERENCES PROSPECT (ID_PROSPECT)"+
                ");";

        String creationTableRencontre = "CREATE TABLE rencontre ("
                +"LOGIN  varchar(32)   ," +
                "NOM varchar(32)  ," +
                "ID_PROSPECT integer" +
                "   , PRIMARY KEY (LOGIN,NOM,ID_PROSPECT), " +
                "FOREIGN KEY(LOGIN) REFERENCES COMMERCIAL (LOGIN),"+
                "FOREIGN KEY(NOM) REFERENCES EVENEMENT (NOM),"+
                "FOREIGN KEY(ID_PROSPECT) REFERENCES PROSPECT (ID_PROSPECT)"+
                ");";

        String creationTablePropose = "CREATE TABLE PROPOSE ("
                +"LIBELLE varchar(32)   ," +
                "   ID_PROSPECT integer ," +
                "   PROPOSITION varchar(255) " +
                "   , PRIMARY KEY (LIBELLE,ID_PROSPECT),  " +
                "FOREIGN KEY(LIBELLE) REFERENCES PROJET (LIBELLE),"+
                "FOREIGN KEY(ID_PROSPECT) REFERENCES PROSPECT (ID_PROSPECT)"+

                ");";



        db.execSQL(creationTableEvenement);
        db.execSQL(creationTableCommercial);
        db.execSQL(creationTableProjet);
        db.execSQL(creationTableEntreprise);
        db.execSQL(creationTableProspect);
        db.execSQL(creationTableParticipe);
        db.execSQL(creationTableRencontre);
        db.execSQL(creationTablePropose);




        System.out.println("CREATION REUSSI !");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        System.out.println("UPDATE !");

    }


    public static Commercial selectCommercial(String login, String mdp, SQLiteDatabase db) {
        System.out.println("TIEPGS");
        System.out.println(login.trim());
        System.out.println(mdp.trim());
        Cursor c = db.rawQuery("SELECT * FROM commercial WHERE login = '"+login+"' AND password = '"+mdp+"'", null);
        c.moveToFirst();
        try {
            Commercial monCommercial = new Commercial(login, mdp, c.getString(2), c.getString(3),c.getString(4),c.getString(5));
            return monCommercial;
        } catch (IndexOutOfBoundsException e){
            System.out.println("Connexion ");
            Commercial monCommercial = new Commercial("FALSE");
            return monCommercial;


        }


    }

    public void InsertionUser(SQLiteDatabase db, String login, String pass, String nom, String prenom, String tel, String email){
        ContentValues values = new ContentValues();
        values.put("LOGIN", login);
        values.put("PASSWORD", pass);
        values.put("NOM", nom);
        values.put("PRENOM", prenom);
        values.put("TEL", tel);
        values.put("EMAIL", email);
        db.insert("Commercial",null,values);
        System.out.println("INSERTION");

    }
}
