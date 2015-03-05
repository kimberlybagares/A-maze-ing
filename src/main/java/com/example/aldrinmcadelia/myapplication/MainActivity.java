package com.example.aldrinmcadelia.myapplication;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.view.Window;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);

        String fontPath = "GoodDog.otf";

        TextView tittle = (TextView) findViewById(R.id.Title_view);
        TextView play = (TextView) findViewById(R.id.buttonPlay);
        TextView about = (TextView) findViewById(R.id.buttonAbout);
        TextView exit = (TextView) findViewById(R.id.buttonExit);

        Typeface tittleView =  Typeface.createFromAsset(getAssets(), fontPath);
        Typeface playView = Typeface.createFromAsset(getAssets(), fontPath);
        Typeface aboutView = Typeface.createFromAsset(getAssets(), fontPath);
        Typeface exitView = Typeface.createFromAsset(getAssets(), fontPath);

        tittle.setTypeface(tittleView);
        play.setTypeface(playView);
        about.setTypeface(aboutView);
        exit.setTypeface(exitView);

        String filename = "SaveFile";
        String content = "Score";
        File file = null;

        FileOutputStream outputStream;
        try {
            assert file != null;
            file = new File(String.valueOf(file));

            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(content.getBytes());
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
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

    public void ExitApp(View view){
        finish();
        System.exit(0);
    }

    /**
     * Created by Aldrin M Cadeliña on 2/8/2015.
     */
    public static class MazeView {
    }
}
