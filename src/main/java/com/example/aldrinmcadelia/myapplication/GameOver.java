package com.example.aldrinmcadelia.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class GameOver extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        String fontPath = "Lobster_1.3.otf";

        Typeface fontStyle = Typeface.createFromAsset(getAssets(),fontPath);

        final Button Restart = (Button) findViewById(R.id.Restart);
        Button Quit = (Button) findViewById(R.id.Quit);

        TextView gameOverText = (TextView) findViewById(R.id.GameOverText);

        gameOverText.setTypeface(fontStyle);

        Intent intent = getIntent();
        final int stageNumber = intent.getIntExtra("stageNo",0);

        Restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(stageNumber == 1){
                    Intent Restart1 = new Intent(com.example.aldrinmcadelia.myapplication.GameOver.this,Stageone.class);
                    startActivity(Restart1);
                    finish();
                }
                if(stageNumber == 2){
                    Intent Restart2 = new Intent(com.example.aldrinmcadelia.myapplication.GameOver.this,StageTwo.class);
                    startActivity(Restart2);
                    finish();
                }
                if(stageNumber == 3){
                    Intent Restart3 = new Intent(com.example.aldrinmcadelia.myapplication.GameOver.this,StageThree.class);
                    startActivity(Restart3);
                    finish();
                }
                if(stageNumber == 4){
                    Intent Restart4 = new Intent(com.example.aldrinmcadelia.myapplication.GameOver.this,StageFour.class);
                    startActivity(Restart4);
                    finish();
                }
                if(stageNumber == 5){
                    Intent Restart5 = new Intent(com.example.aldrinmcadelia.myapplication.GameOver.this,StageFive.class);
                    startActivity(Restart5);
                    finish();
                }
                if(stageNumber == 6){
                    Intent Restart6 = new Intent(com.example.aldrinmcadelia.myapplication.GameOver.this,StageSix.class);
                    startActivity(Restart6);
                    finish();
                }
                if(stageNumber == 7){
                    Intent Restart7 = new Intent(com.example.aldrinmcadelia.myapplication.GameOver.this,StageSeven.class);
                    startActivity(Restart7);
                    finish();
                }
                if(stageNumber == 8){
                    Intent Restart8 = new Intent(com.example.aldrinmcadelia.myapplication.GameOver.this,StageEight.class);
                    startActivity(Restart8);
                    finish();
                }
                if(stageNumber == 9){
                    Intent Restart9 = new Intent(com.example.aldrinmcadelia.myapplication.GameOver.this,StageNine.class);
                    startActivity(Restart9);
                    finish();
                }

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
