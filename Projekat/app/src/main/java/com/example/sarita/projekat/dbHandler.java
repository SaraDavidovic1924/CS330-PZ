package com.example.sarita.projekat;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class dbHandler extends SQLiteOpenHelper {

    //varijable za kreiranje baze podataka
    private static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "ratingManager";

    private static final String TABLE_RATING = "rating";

    private static final String KEY_ID = "id";
    private static final String KEY_NUM = "rate";


    public dbHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //kreiranje tabela
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_RATING_TABLE = "CREATE TABLE " + TABLE_RATING + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NUM + " TEXT" + ")";
        db.execSQL(CREATE_RATING_TABLE);
    }

    //update za bazu
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //ako postoji tabela onda dropuje novu
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RATING);

        onCreate(db);
    }

    //dodavanje kontakta
    void addRate(rate r) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NUM, r.getNumber());

        db.insert(TABLE_RATING, null, values);
        db.close();
    }

    //brisanje tabela
    void deleteRate() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("delete from "+ TABLE_RATING);
    }

    //ispisuje broj
    public String dbToBroj(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_RATING + " WHERE 1";

        //kursor za lokaciju
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        while(!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("id"))!= null){
                dbString += c.getString(c.getColumnIndex("id"));
                dbString += "\n";
                c.moveToNext();
            }
        }
        db.close();
        return dbString;
    }

    //ispisuje rate
    public String dbToRate(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_RATING + " WHERE 1";

        //kursor za lokaciju
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        while(!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("rate"))!= null){
                dbString += c.getString(c.getColumnIndex("rate"));
                dbString += "\n";
                c.moveToNext();
            }
        }
        db.close();
        return dbString;
    }

}