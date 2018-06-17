package com.example.sarita.projekat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;


public class Slike extends AppCompatActivity {

    //varijable
    ViewPager myPager;
    String position;
    public static dbHandler db;

    int clCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slike);

        //sakrivanje notifikacionog bara
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //sakrivanje bara
        getSupportActionBar().show();

        //pozivanje pagera
        MyPagerAdapter adapter = new MyPagerAdapter();
        myPager = (ViewPager) findViewById(R.id.viewPage);
        myPager.setAdapter(adapter);
        myPager.setCurrentItem(0);

        //baza lociranje
        db = new dbHandler(this);

        //lociranje ratingbar-a, dugmeta i prikaz
        final RatingBar rb1 = (RatingBar) findViewById(R.id.ratingBar1);;

        final ImageButton ib1 = (ImageButton) findViewById(R.id.imageButton1);
        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = String.valueOf(rb1.getRating());
                Toast.makeText(getApplicationContext(), position, Toast.LENGTH_SHORT).show();

                //dodavanje tabele i gasenje dugmeta
                db.addRate(new rate(position));

                clCount += 1;
                if(clCount > 9){
                    ib1.setEnabled(false);
                }

            }
        });


    }

    //kreiranje menija
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bar, menu);
        return true;
    }

    //funkcija za odabranu stavku menija
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.stavka1:
                //pozivanje klase stats
                Intent intent = new Intent(Slike.this, Stats.class);
                startActivity(intent);
                Toast.makeText(getBaseContext(), "Statistics", Toast.LENGTH_SHORT).show();
                break;
            case R.id.stavka2:
                Intent intent1 = new Intent(Slike.this, Kontakt.class);
                startActivity(intent1);
                Toast.makeText(getBaseContext(), "Contacts", Toast.LENGTH_SHORT).show();
                break;
            case R.id.stavka3:
                Intent intent2 = new Intent(Slike.this, About.class);
                startActivity(intent2);
                Toast.makeText(getBaseContext(), "Develpoer", Toast.LENGTH_SHORT).show();
                break;

        }
        return Boolean.parseBoolean(null);
    }

    //deklarisanje klase pager
    private class MyPagerAdapter extends PagerAdapter {


        //vracanje broja stranica
        public int getCount() {
            return 10;
        }

        //lociranje laylout-a
        public Object instantiateItem(View collection, int position) {

            LayoutInflater inflater = (LayoutInflater) collection.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);


            int resId = 0;
            switch (position) {
                case 0:
                    resId = R.layout.bloody_bulldog;
                    break;
                case 1:
                    resId = R.layout.blue_frog;
                    break;
                case 2:
                    resId = R.layout.blue_lagune;
                    break;
                case 3:
                    resId = R.layout.brazilian_cocktail;
                    break;
                case 4:
                    resId = R.layout.carborita;
                    break;
                case 5:
                    resId = R.layout.dry_martini;
                    break;
                case 6:
                    resId = R.layout.jin_tonic;
                    break;
                case 7:
                    resId = R.layout.mojito;
                    break;
                case 8:
                    resId = R.layout.partida_margarita;
                    break;
                case 9:
                    resId = R.layout.strawberry_daiquiri;
                    break;
            }



            View view = inflater.inflate(resId, null);

            ((ViewPager) collection).addView(view, 0);

            return view;
        }

        //brisanje nakon promene pogleda
        @Override
        public void destroyItem(View arg0, int arg1, Object arg2) {
            ((ViewPager) arg0).removeView((View) arg2);

        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == ((View) arg1);

        }

        @Override
        public Parcelable saveState() {
            return null;
        }

    }

    //brisanje tabela
    public void onDestroy(){
        super.onDestroy();
        db.deleteRate();
    }


}

