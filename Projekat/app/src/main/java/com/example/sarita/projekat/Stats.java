package com.example.sarita.projekat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.TextView;


public class Stats extends AppCompatActivity {

    static TextView tw1;
    static TextView tw2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats);

        //sakrivanje notifikacionog bara
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //sakrivanje bara
        getSupportActionBar().hide();

        //lociranje textview
        tw1 = (TextView) findViewById(R.id.tx1);
        tw2 = (TextView) findViewById(R.id.tx2);

        //ispisivanje baze
        printDatabaseNum();
        printDatabaseRate();

    }

    //printanje iz baze
    public static void printDatabaseNum(){
        String dbString = Slike.db.dbToBroj();
        tw2.setText(dbString);
    }

    public static void printDatabaseRate(){
        String dbString = Slike.db.dbToRate();
        tw1.setText(dbString);
    }

}
