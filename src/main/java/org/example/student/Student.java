package org.example.student;

import java.sql.Date;

public class Student {

    private int id;
    private String firstname;
    private String lastname;
    private int numberClass;
    private java.sql.Date diplomeDate ;
    private int compt = 0;
    public Student(String firstname, String lastname, int numberClass, java.sql.Date diplomeDate) {
        this.compt++;
        this.firstname = firstname;
        this.lastname = lastname;
        this.numberClass = numberClass;
        this.diplomeDate = diplomeDate;
        id = compt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getNumberClass() {
        return numberClass;
    }

    public void setNumberClass(int numberClass) {
        this.numberClass = numberClass;
    }

    public Date getDiplomeDate() {
        return diplomeDate;
    }

    public void setDiplomeDate(Date diplomeDate) {
        this.diplomeDate = diplomeDate;
    }

    @Override
    public String toString() {
        return "Nom de l'étudiant = " + lastname + ", prénom = " + firstname + ", numéro de classe = " + numberClass + ", date du diplôlme = " + diplomeDate;
    }
}
