package com.example.aldrinmcadelia.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class GameOver extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        Button Restart = (Button) findViewById(R.id.Restart);
        Button Quit = (Button) findViewById(R.id.Quit);

        Restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent RestartGame = new Intent(com.example.aldrinmcadelia.myapplication.GameOver.this,Stageone.class);
                startActivity(RestartGame);
                finish();
            }
        });
        Quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent QuitGame = new Intent(com.example.aldrinmcadelia.myapplication.GameOver.this,MainActivity.class);
                startActivity(QuitGame);
                finish();
            }
        });
    }




}
