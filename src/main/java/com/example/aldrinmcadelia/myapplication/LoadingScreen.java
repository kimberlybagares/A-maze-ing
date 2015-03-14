package com.example.aldrinmcadelia.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class LoadingScreen extends Activity {


    private final int SPLASH_DISPLAY_LENGTH = 1000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);
        final Intent stages = getIntent();
        final int stageNo = stages.getIntExtra("stage",0);


        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                if(stageNo == 1){
                    Intent mainIntent = new Intent(LoadingScreen.this,Stageone.class);
                    LoadingScreen.this.startActivity(mainIntent);
                    LoadingScreen.this.finish();
                }
                if(stageNo == 2){
                    Intent mainIntent = new Intent(LoadingScreen.this,StageTwo.class);
                    LoadingScreen.this.startActivity(mainIntent);
                    LoadingScreen.this.finish();
                }
                if(stageNo == 3){
                    Intent mainIntent = new Intent(LoadingScreen.this,StageThree.class);
                    LoadingScreen.this.startActivity(mainIntent);
                    LoadingScreen.this.finish();
                }
                if(stageNo == 4){
                    Intent mainIntent = new Intent(LoadingScreen.this,StageFour.class);
                    LoadingScreen.this.startActivity(mainIntent);
                    LoadingScreen.this.finish();
                }
                if(stageNo == 5){
                    Intent mainIntent = new Intent(LoadingScreen.this,StageFive.class);
                    LoadingScreen.this.startActivity(mainIntent);
                    LoadingScreen.this.finish();
                }
                if(stageNo == 6){
                    Intent mainIntent = new Intent(LoadingScreen.this,StageSix.class);
                    LoadingScreen.this.startActivity(mainIntent);
                    LoadingScreen.this.finish();
                }
                if(stageNo == 7){
                    Intent mainIntent = new Intent(LoadingScreen.this,StageSeven.class);
                    LoadingScreen.this.startActivity(mainIntent);
                    LoadingScreen.this.finish();
                }
                if(stageNo == 8){
                    Intent mainIntent = new Intent(LoadingScreen.this,StageEight.class);
                    LoadingScreen.this.startActivity(mainIntent);
                    LoadingScreen.this.finish();
                }
                if(stageNo == 9){
                    Intent mainIntent = new Intent(LoadingScreen.this,StageNine.class);
                    LoadingScreen.this.startActivity(mainIntent);
                    LoadingScreen.this.finish();
                }
                if(stageNo == 10){

                }


            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}