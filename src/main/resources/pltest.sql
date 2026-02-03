CREATE DATABASE PLTEST;

        create table UTILISATEUR(
            ID INTEGER primary key not null AUTO_INCREMENT,
            EMAIL varchar(50)
        );

        create table AVIS (
            ID INTEGER primary key not null AUTO_INCREMENT,
            DESCRIPTION varchar(50),
            TYPE varchar(10),
            UTILISATEUR_ID integer,
            CONSTRAINT UTILISATEUR_FK FOREIGN KEY (UTILISATEUR_ID) REFERENCES UTILISATEUR(ID)
        );
