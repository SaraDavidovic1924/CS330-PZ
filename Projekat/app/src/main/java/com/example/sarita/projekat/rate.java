package com.example.sarita.projekat;


public class rate {

    //varijable
    int _id;
    String _number;

    //prazan konstruktor
    public rate(){}

    //konstruktor
    public rate(int id, String number){
        this._id = id;
        this._number = number;
    }

    //geteri i seteri
    public rate(String number){
        this._number = number;
    }

    public int getID(){
        return this._id;
    }

    public String getNumber(){
        return this._number;
    }

    public void setID(int id){
        this._id = id;
    }

    public void setNumber(String number){
        this._number = number;
    }


}
