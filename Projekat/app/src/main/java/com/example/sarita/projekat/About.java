package com.example.sarita.projekat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;


public class About extends AppCompatActivity {
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
                Intent intent = new Intent(About.this, Stats.class);
                startActivity(intent);
                Toast.makeText(getBaseContext(), "Statistics", Toast.LENGTH_SHORT).show();
                break;
            case R.id.stavka2:
                Intent intent1 = new Intent(About.this, Kontakt.class);
                startActivity(intent1);
                Toast.makeText(getBaseContext(), "Contact", Toast.LENGTH_SHORT).show();
                break;
            case R.id.stavka3:
                Intent intent2 = new Intent(About.this, About.class);
                startActivity(intent2);
                Toast.makeText(getBaseContext(), "Developer", Toast.LENGTH_SHORT).show();
                break;

        }
        return Boolean.parseBoolean(null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        //sakrivanje notifikacionog bara
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);



    }


}
