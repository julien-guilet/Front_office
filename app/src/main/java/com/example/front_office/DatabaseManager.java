package com.example.front_office;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


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
                "   , PRIMARY KEY (ID_PROSPECT) " +
                ");";

        String creationTableParticipe = "CREATE TABLE participe ("
                +"RAISON_SOCIALE  varchar(32) ," +
                "   NOM  varchar(32)," +
                "   PRENOM varchar(32)," +
                "   TEL  varchar(10)   ," +
                "   MAIL  varchar(32)   ," +
                "   NOTES  varchar(255)  ," +
                "   ID_PROSPECT integer" +
                "   , PRIMARY KEY (ID_PROSPECT) " +
                ");";

        String creationTableRencontre = "CREATE TABLE rencontre ("
                +"LOGIN  varchar(32)   ," +
                "NOM varchar(32)  ," +
                "ID_PROSPECT integer" +
                "   , PRIMARY KEY (LOGIN,NOM,ID_PROSPECT) " +
                ");";

        String creationTablePropose = "CREATE TABLE rencontre ("
                +"LIBELLE varchar(32)   ," +
                "   ID_PROSPECT integer ," +
                "   PROPOSITION varchar(255) " +
                "   , PRIMARY KEY (LIBELLE,ID_PROSPECT)  " +
                ");";

        String ajoutReferences = "ALTER TABLE PROSPECT \n" +
                "  ADD FOREIGN KEY FK_PROSPECT_ENTREPRISE (RAISON_SOCIALE)\n" +
                "      REFERENCES ENTREPRISE (RAISON_SOCIALE) ;\n" +
                "\n" +
                "\n" +
                "ALTER TABLE PARTICIPE \n" +
                "  ADD FOREIGN KEY FK_PARTICIPE_EVENEMENT (NOM)\n" +
                "      REFERENCES EVENEMENT (NOM) ;\n" +
                "\n" +
                "\n" +
                "ALTER TABLE PARTICIPE \n" +
                "  ADD FOREIGN KEY FK_PARTICIPE_PROSPECT (ID_PROSPECT)\n" +
                "      REFERENCES PROSPECT (ID_PROSPECT) ;\n" +
                "\n" +
                "\n" +
                "ALTER TABLE RENCONTRE \n" +
                "  ADD FOREIGN KEY FK_RENCONTRE_COMMERCIAL (LOGIN)\n" +
                "      REFERENCES COMMERCIAL (LOGIN) ;\n" +
                "\n" +
                "\n" +
                "ALTER TABLE RENCONTRE \n" +
                "  ADD FOREIGN KEY FK_RENCONTRE_EVENEMENT (NOM)\n" +
                "      REFERENCES EVENEMENT (NOM) ;\n" +
                "\n" +
                "\n" +
                "ALTER TABLE RENCONTRE \n" +
                "  ADD FOREIGN KEY FK_RENCONTRE_PROSPECT (ID_PROSPECT)\n" +
                "      REFERENCES PROSPECT (ID_PROSPECT) ;\n" +
                "\n" +
                "\n" +
                "ALTER TABLE PROPOSE \n" +
                "  ADD FOREIGN KEY FK_PROPOSE_PROJET (LIBELLE)\n" +
                "      REFERENCES PROJET (LIBELLE) ;\n" +
                "\n" +
                "\n" +
                "ALTER TABLE PROPOSE \n" +
                "  ADD FOREIGN KEY FK_PROPOSE_PROSPECT (ID_PROSPECT)\n" +
                "      REFERENCES PROSPECT (ID_PROSPECT) ;";

        db.execSQL(creationTableEvenement);
        db.execSQL(creationTableCommercial);
        db.execSQL(creationTableProjet);
        db.execSQL(creationTableEntreprise);
        db.execSQL(creationTableProspect);
        db.execSQL(creationTableParticipe);
        db.execSQL(creationTableRencontre);
        db.execSQL(creationTablePropose);
        db.execSQL(ajoutReferences);


        System.out.println("CREATION REUSSI !");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        System.out.println("UPDATE !");

    }

    public void testInsertion(SQLiteDatabase db){
        db.execSQL("INSERT INTO user VALUES ('michel','jacque');");

    }
}
