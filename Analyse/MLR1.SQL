DROP DATABASE IF EXISTS MLR1;

CREATE DATABASE IF NOT EXISTS MLR1;
USE MLR1;
# -----------------------------------------------------------------------------
#       TABLE : EVENEMENT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS EVENEMENT
 (
   NOM CHAR(32) NOT NULL  ,
   LIEU VARCHAR(128) NULL  ,
   DATEDEBUT DATETIME NULL  ,
   DATEFIN DATETIME NULL  
   , PRIMARY KEY (NOM) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : COMMERCIAL
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS COMMERCIAL
 (
   LOGIN CHAR(32) NOT NULL  ,
   PASSWORD CHAR(32) NULL  ,
   NOM CHAR(32) NULL  ,
   PRENOM CHAR(32) NULL  ,
   TEL CHAR(10) NULL  ,
   EMAIL CHAR(32) NULL  
   , PRIMARY KEY (LOGIN) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : PROJET
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS PROJET
 (
   LIBELLE CHAR(32) NOT NULL  ,
   DESCRIPTION VARCHAR(255) NULL  
   , PRIMARY KEY (LIBELLE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : ENTREPRISE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS ENTREPRISE
 (
   RAISON_SOCIALE CHAR(32) NOT NULL  ,
   SIRET CHAR(32) NULL  
   , PRIMARY KEY (RAISON_SOCIALE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : PROSPECT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS PROSPECT
 (
   RAISON_SOCIALE CHAR(32) NOT NULL  ,
   NOM CHAR(32) NULL  ,
   PRENOM CHAR(32) NULL  ,
   TEL CHAR(10) NULL  ,
   MAIL CHAR(32) NULL  ,
   NOTES CHAR(32) NULL  ,
   ID_PROSPECT INTEGER NOT NULL  
   , PRIMARY KEY (ID_PROSPECT) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE PROSPECT
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_PROSPECT_ENTREPRISE
     ON PROSPECT (RAISON_SOCIALE ASC);

# -----------------------------------------------------------------------------
#       TABLE : PARTICIPE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS PARTICIPE
 (
   NOM CHAR(32) NOT NULL  ,
   ID_PROSPECT INTEGER NOT NULL  
   , PRIMARY KEY (NOM,ID_PROSPECT) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE PARTICIPE
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_PARTICIPE_EVENEMENT
     ON PARTICIPE (NOM ASC);

CREATE  INDEX I_FK_PARTICIPE_PROSPECT
     ON PARTICIPE (ID_PROSPECT ASC);

# -----------------------------------------------------------------------------
#       TABLE : RENCONTRE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS RENCONTRE
 (
   LOGIN CHAR(32) NOT NULL  ,
   NOM CHAR(32) NOT NULL  ,
   ID_PROSPECT INTEGER NOT NULL  
   , PRIMARY KEY (LOGIN,NOM,ID_PROSPECT) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE RENCONTRE
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_RENCONTRE_COMMERCIAL
     ON RENCONTRE (LOGIN ASC);

CREATE  INDEX I_FK_RENCONTRE_EVENEMENT
     ON RENCONTRE (NOM ASC);

CREATE  INDEX I_FK_RENCONTRE_PROSPECT
     ON RENCONTRE (ID_PROSPECT ASC);

# -----------------------------------------------------------------------------
#       TABLE : PROPOSE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS PROPOSE
 (
   LIBELLE CHAR(32) NOT NULL  ,
   ID_PROSPECT INTEGER NOT NULL  ,
   PROPOSITION VARCHAR(255) NULL  
   , PRIMARY KEY (LIBELLE,ID_PROSPECT) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE PROPOSE
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_PROPOSE_PROJET
     ON PROPOSE (LIBELLE ASC);

CREATE  INDEX I_FK_PROPOSE_PROSPECT
     ON PROPOSE (ID_PROSPECT ASC);


# -----------------------------------------------------------------------------
#       CREATION DES REFERENCES DE TABLE
# -----------------------------------------------------------------------------


ALTER TABLE PROSPECT 
  ADD FOREIGN KEY FK_PROSPECT_ENTREPRISE (RAISON_SOCIALE)
      REFERENCES ENTREPRISE (RAISON_SOCIALE) ;


ALTER TABLE PARTICIPE 
  ADD FOREIGN KEY FK_PARTICIPE_EVENEMENT (NOM)
      REFERENCES EVENEMENT (NOM) ;


ALTER TABLE PARTICIPE 
  ADD FOREIGN KEY FK_PARTICIPE_PROSPECT (ID_PROSPECT)
      REFERENCES PROSPECT (ID_PROSPECT) ;


ALTER TABLE RENCONTRE 
  ADD FOREIGN KEY FK_RENCONTRE_COMMERCIAL (LOGIN)
      REFERENCES COMMERCIAL (LOGIN) ;


ALTER TABLE RENCONTRE 
  ADD FOREIGN KEY FK_RENCONTRE_EVENEMENT (NOM)
      REFERENCES EVENEMENT (NOM) ;


ALTER TABLE RENCONTRE 
  ADD FOREIGN KEY FK_RENCONTRE_PROSPECT (ID_PROSPECT)
      REFERENCES PROSPECT (ID_PROSPECT) ;


ALTER TABLE PROPOSE 
  ADD FOREIGN KEY FK_PROPOSE_PROJET (LIBELLE)
      REFERENCES PROJET (LIBELLE) ;


ALTER TABLE PROPOSE 
  ADD FOREIGN KEY FK_PROPOSE_PROSPECT (ID_PROSPECT)
      REFERENCES PROSPECT (ID_PROSPECT) ;

