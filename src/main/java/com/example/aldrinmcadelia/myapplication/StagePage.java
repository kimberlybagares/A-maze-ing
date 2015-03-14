package com.example.aldrinmcadelia.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;


public class StagePage extends Activity {

    private int pass = 1;
    MediaPlayer OurSong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent mIntent = getIntent();
        int passing = mIntent.getIntExtra("pass",0);
        int value = mIntent.getIntExtra("finish",0);
        final int value2 = mIntent.getIntExtra("stage",0);
        int value3 = mIntent.getIntExtra("bestTime", 0);


        int loadStage1 = loadSavedStage1();
        int loadStage2 = loadSavedStage2();
        int loadStage3 = loadSavedStage3();
        int loadStage4 = loadSavedStage4();
        int loadStage5 = loadSavedStage5();
        int loadStage6 = loadSavedStage6();
        int loadStage7 = loadSavedStage7();
        int loadStage8 = loadSavedStage8();
        int loadStage9 = loadSavedStage9();

        if (passing == 1){
            setContentView(R.layout.activity_stage_page);
            if(value2 == 1){
                savePreferencesStage1("Stage1",value3);
            }
            if(value2 == 2){
                savePreferencesStage2("Stage2",value3);
            }
            if(value2 == 3){
                savePreferencesStage3("Stage3",value3);
            }
            if(value2 == 4){
                savePreferencesStage4("Stage4",value3);
            }
            if(value2 == 5){
                savePreferencesStage5("Stage5",value3);
            }
            if(value2 == 6){
                savePreferencesStage6("Stage6",value3);
            }
            if(value2 == 7){
                savePreferencesStage7("Stage7",value3);
            }
            if(value2 == 8){
                savePreferencesStage8("Stage8",value3);
            }
            if(value2 == 9){
                savePreferencesStage9("Stage9",value3);
            }
            Intent finish = new Intent(this,FinishActivity.class);
            finish.putExtra("finish",value);
            finish.putExtra("stage",value2);
            finish.putExtra("bestTime",value3);
            startActivity(finish);
            finish();

        }else {
            setContentView(R.layout.activity_stage_page);
        }







        String fontPath = "black_jack.ttf";
        String fontPath2 = "Lobster_1.3.otf";

        TextView tittle = (TextView) findViewById(R.id.select_stage);
        TextView one = (TextView) findViewById(R.id.one);
        TextView two = (TextView) findViewById(R.id.two);
        TextView three = (TextView) findViewById(R.id.three);
        TextView four = (TextView) findViewById(R.id.four);
        TextView five = (TextView) findViewById(R.id.five);
        TextView six = (TextView) findViewById(R.id.six);
        TextView seven = (TextView) findViewById(R.id.seven);
        TextView eight = (TextView) findViewById(R.id.eight);
        TextView nine = (TextView) findViewById(R.id.nine);
        TextView back_main = (TextView) findViewById(R.id.back_main);


        Typeface tittleView = Typeface.createFromAsset(getAssets(), fontPath2);
        Typeface oneView = Typeface.createFromAsset(getAssets(), fontPath2);
        Typeface twoView = Typeface.createFromAsset(getAssets(), fontPath2);
        Typeface threeView = Typeface.createFromAsset(getAssets(), fontPath2);
        Typeface fourView = Typeface.createFromAsset(getAssets(), fontPath2);
        Typeface fiveView = Typeface.createFromAsset(getAssets(), fontPath2);
        Typeface sixView = Typeface.createFromAsset(getAssets(), fontPath2);
        Typeface sevenView = Typeface.createFromAsset(getAssets(), fontPath2);
        Typeface eightView = Typeface.createFromAsset(getAssets(), fontPath2);
        Typeface nineView = Typeface.createFromAsset(getAssets(), fontPath2);
        Typeface backView = Typeface.createFromAsset(getAssets(), fontPath2);

        tittle.setTypeface(tittleView);
        one.setTypeface(oneView);
        two.setTypeface(twoView);
        three.setTypeface(threeView);
        four.setTypeface(fourView);
        five.setTypeface(fiveView);
        six.setTypeface(sixView);
        seven.setTypeface(sevenView);
        eight.setTypeface(eightView);
        nine.setTypeface(nineView);
        back_main.setTypeface(backView);

        Drawable myIcon = this.getResources().getDrawable(R.drawable.selectcolor);
        Drawable colorGray = this.getResources().getDrawable(R.drawable.gray);
        Drawable colorBlue = this.getResources().getDrawable(R.drawable.selectcolor);
        Drawable colorBlue2 = this.getResources().getDrawable(R.drawable.selectcolor);
        Drawable colorBlue3 = this.getResources().getDrawable(R.drawable.selectcolor);
        Drawable colorBlue4 = this.getResources().getDrawable(R.drawable.selectcolor);
        Drawable colorBlue5 = this.getResources().getDrawable(R.drawable.selectcolor);
        Drawable colorBlue6 = this.getResources().getDrawable(R.drawable.selectcolor);
        Drawable colorBlue7 = this.getResources().getDrawable(R.drawable.selectcolor);
        Drawable colorBlue8 = this.getResources().getDrawable(R.drawable.selectcolor);


        Button stage1 = (Button) findViewById(R.id.one);
        Button stage2 = (Button) findViewById(R.id.two);
        Button stage3 = (Button) findViewById(R.id.three);
        Button stage4 = (Button) findViewById(R.id.four);
        Button stage5 = (Button) findViewById(R.id.five);
        Button stage6 = (Button) findViewById(R.id.six);
        Button stage7 = (Button) findViewById(R.id.seven);
        Button stage8 = (Button) findViewById(R.id.eight);
        Button stage9 = (Button) findViewById(R.id.nine);

        stage1.setBackground(myIcon);

        if(loadStage1 > 20000){
            stage2.setBackground(colorGray);
            stage2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
        else{
            stage2.setBackground(colorBlue);
            stage2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(com.example.aldrinmcadelia.myapplication.StagePage.this, LoadingScreen.class);
                    intent.putExtra("stage",2);
                    startActivity(intent);
                    finish();
                }
            });
        }
        if(loadStage2 > 20000){
            stage3.setBackground(colorGray);
            stage3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
        else{
            stage3.setBackground(colorBlue2);
            stage3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(com.example.aldrinmcadelia.myapplication.StagePage.this, LoadingScreen.class);
                    intent.putExtra("stage",3);
                    startActivity(intent);
                    finish();
                }
            });
        }
        if(loadStage3 > 25000){
            stage4.setBackground(colorGray);
            stage4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
        else{
            stage4.setBackground(colorBlue3);
            stage4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(com.example.aldrinmcadelia.myapplication.StagePage.this, LoadingScreen.class);
                    intent.putExtra("stage",4);
                    startActivity(intent);
                    finish();
                }
            });
        }
        if(loadStage4 > 25000){
            stage5.setBackground(colorGray);
            stage5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
        else{
            stage5.setBackground(colorBlue4);
            stage5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(com.example.aldrinmcadelia.myapplication.StagePage.this, LoadingScreen.class);
                    intent.putExtra("stage",5);
                    startActivity(intent);
                    finish();
                }
            });
        }
        if(loadStage5 > 30000){
            stage6.setBackground(colorGray);
            stage6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
        else{
            stage6.setBackground(colorBlue5);
            stage6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(com.example.aldrinmcadelia.myapplication.StagePage.this, LoadingScreen.class);
                    intent.putExtra("stage",6);
                    startActivity(intent);
                    finish();
                }
            });
        }
        if(loadStage6 > 30000){
            stage7.setBackground(colorGray);
            stage7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
        else{
            stage7.setBackground(colorBlue6);
            stage7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(com.example.aldrinmcadelia.myapplication.StagePage.this, LoadingScreen.class);
                    intent.putExtra("stage",7);
                    startActivity(intent);
                    finish();
                }
            });
        }
        if(loadStage7 > 35000){
            stage8.setBackground(colorGray);
            stage8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
        else{
            stage8.setBackground(colorBlue7);
            stage8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(com.example.aldrinmcadelia.myapplication.StagePage.this, LoadingScreen.class);
                    intent.putExtra("stage",8);
                    startActivity(intent);
                    finish();
                }
            });
        }
        if(loadStage8 > 35000){
            stage9.setBackground(colorGray);
            stage9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
        else{
            stage9.setBackground(colorBlue8);
            stage9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(com.example.aldrinmcadelia.myapplication.StagePage.this, LoadingScreen.class);
                    intent.putExtra("stage",9);
                    startActivity(intent);
                    finish();
                }
            });
        }

    }

    private int loadSavedStage1() {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        return sharedPreferences.getInt("Stage1", 30020);
    }
    private int loadSavedStage2() {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        return sharedPreferences.getInt("Stage2", 30020);
    }
    private int loadSavedStage3() {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        return sharedPreferences.getInt("Stage3", 35020);
    }
    private int loadSavedStage4() {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        return sharedPreferences.getInt("Stage4", 35020);
    }
    private int loadSavedStage5() {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        return sharedPreferences.getInt("Stage5", 40020);
    }
    private int loadSavedStage6() {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        return sharedPreferences.getInt("Stage6", 40020);
    }
    private int loadSavedStage7() {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        return sharedPreferences.getInt("Stage7", 45020);
    }
    private int loadSavedStage8() {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        return sharedPreferences.getInt("Stage8", 45020);
    }
    private int loadSavedStage9() {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        return sharedPreferences.getInt("Stage9", 50020);
    }


    private void savePreferencesStage1(String key, int value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }
    private void savePreferencesStage2(String key, int value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }
    private void savePreferencesStage3(String key, int value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }
    private void savePreferencesStage4(String key, int value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }
    private void savePreferencesStage5(String key, int value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }
    private void savePreferencesStage6(String key, int value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }
    private void savePreferencesStage7(String key, int value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }
    private void savePreferencesStage8(String key, int value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }
    private void savePreferencesStage9(String key, int value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }



    public void backPage(View view){
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
        finish();

    }
    public void stageOne(View view){
        Intent intent = new Intent(this, LoadingScreen.class);
        intent.putExtra("stage",1);
        startActivity(intent);
        finish();
    }

    public void stageTwo(View view){
        int stage2 = loadSavedStage2();
        if(stage2 == 20000){
            Intent intent = new Intent(this, StageTwo.class);
            startActivity(intent);
            finish();
        }
        if(stage2 < 20000){
            Intent intent = new Intent(this, StageTwo.class);
            startActivity(intent);
            finish();
        }
        else{

        }

    }
    public void stageThree(View view){
        Intent intent = new Intent(this, StageThree.class);

        startActivity(intent);
        finish();
    }
    public void stageFour(View view){

    }
    public void stageFive(View view){
        Intent intent = new Intent(this, StageFive.class);

        startActivity(intent);
        finish();
    }
    public void stageSix(View view){
        Intent intent = new Intent(this, StageSix.class);

        startActivity(intent);
        finish();
    }
    public void stageSeven(View view){
        Intent intent = new Intent(this, StageSeven.class);

        startActivity(intent);
        finish();
    }
    public void stageEight(View view){
        Intent intent = new Intent(this, StageEight.class);

        startActivity(intent);
        finish();
    }
    public void stageNine(View view){
        Intent intent = new Intent(this, StageNine.class);

        startActivity(intent);
        finish();
    }

    protected void onPause(){
        super.onPause();
        finish();
    }
}
