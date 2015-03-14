package com.example.aldrinmcadelia.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.File;


public class Intro extends Activity {

    MediaPlayer OurSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        OurSong = MediaPlayer.create(Intro.this,R.raw.ants);
        OurSong.setLooping(true);
        OurSong.start();

        String fontPath = "Lobster_1.3.otf";

        TextView tittle = (TextView) findViewById(R.id.Title_view);
        TextView play = (TextView) findViewById(R.id.buttonPlay);
        TextView about = (TextView) findViewById(R.id.buttonAbout);
        TextView BestTime = (TextView) findViewById(R.id.BestTime);
        TextView exit = (TextView) findViewById(R.id.buttonExit);

        Typeface tittleView =  Typeface.createFromAsset(getAssets(), fontPath);
        Typeface playView = Typeface.createFromAsset(getAssets(), fontPath);
        Typeface aboutView = Typeface.createFromAsset(getAssets(), fontPath);
        Typeface exitView = Typeface.createFromAsset(getAssets(), fontPath);
        Typeface Best = Typeface.createFromAsset(getAssets(), fontPath);

        tittle.setTypeface(tittleView);
        play.setTypeface(playView);
        about.setTypeface(aboutView);
        exit.setTypeface(exitView);
        BestTime.setTypeface(Best);

        String filename = "SaveFile";
        String content = "Score";
        File file = null;

    }




    public void StageMenu(View view) {

        Intent intent = new Intent(this, StagePage.class);
        startActivity(intent);
        finish();

    }

    public void About(View view) {

        Intent intent = new Intent (this, AboutPage.class);
        startActivity(intent);
        finish();

    }

    public void TheBestTime(View view){
        Intent intent = new Intent(this,BestTime.class);
        startActivity(intent);
        finish();
    }

    public void ExitApp(View view){
        finish();
        System.exit(0);
    }

    protected void onPause(){
        super.onPause();
        OurSong.release();
        finish();
    }

}
