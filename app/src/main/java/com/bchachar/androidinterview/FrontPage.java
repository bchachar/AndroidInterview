package com.bchachar.androidinterview;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FrontPage extends AppCompatActivity implements OnClickListener {

    Button bsimple, btough, bseeother, brateapp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.front_page);

        //action bar
        //LinearLayout linearLayout = (LinearLayout) findViewById(R.id.frontpage_titlebar);

//		Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
//		setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.frontpage_titlebar);


        bsimple = (Button) findViewById(R.id.bsq);
        btough = (Button) findViewById(R.id.btq);
        bseeother = (Button) findViewById(R.id.bseeotherapp);
        brateapp = (Button) findViewById(R.id.brateapp);

        bsimple.setOnClickListener(this);
        btough.setOnClickListener(this);
        bseeother.setOnClickListener(this);
        brateapp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.brateapp:

                try {
                    //search query + name of the developer
                    Uri uri = Uri.parse("market://search?q=" + "bdr");
                    Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName());
                    Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(goToMarket);
                }
                break;

            case R.id.bseeotherapp:
                try {
                    Uri uri = Uri.parse("market://details?id=" + getPackageName());
                    Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    Uri uri = Uri.parse("https://play.google.com/store/search?q=" + "bdr");
                    Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(goToMarket);
                }
                break;

            case R.id.bsq:
                Intent i = new Intent(this, SimpleQuestions.class);
                startActivity(i);
                break;

            case R.id.btq:
                Intent j = new Intent(this, ToughQuestions.class);
                startActivity(j);
                break;
        }
    }
}
