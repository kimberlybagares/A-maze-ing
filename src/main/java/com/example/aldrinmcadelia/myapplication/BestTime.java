package com.example.aldrinmcadelia.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class BestTime extends Activity {

    private String fontpath = "Lobster_1.3.otf";
    MediaPlayer OurSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        OurSong = MediaPlayer.create(BestTime.this,R.raw.ants);
        OurSong.setLooping(true);


        Intent next = getIntent();

        int passing = next.getIntExtra("pass",0);
        int stage = next.getIntExtra("stage",0);
        int best = next.getIntExtra("best",0);

        int loadStage1 = loadSavedStage1();
        int loadStage2 = loadSavedStage2();
        int loadStage3 = loadSavedStage3();
        int loadStage4 = loadSavedStage4();
        int loadStage5 = loadSavedStage5();
        int loadStage6 = loadSavedStage6();
        int loadStage7 = loadSavedStage7();
        int loadStage8 = loadSavedStage8();
        int loadStage9 = loadSavedStage9();

        if(passing == 1){
            setContentView(R.layout.activity_best_time);
            OurSong.start();
            OurSong.release();
            if(stage == 1){
                savePreferencesStage1("bestStage1",best);
                Intent two = new Intent(com.example.aldrinmcadelia.myapplication.BestTime.this,LoadingScreen.class);
                two.putExtra("stage",2);
                startActivity(two);
                finish();
            }
            if(stage == 2){
                savePreferencesStage2("bestStage2", best);
                Intent three = new Intent(com.example.aldrinmcadelia.myapplication.BestTime.this,LoadingScreen.class);
                three.putExtra("stage",3);
                startActivity(three);
                finish();
            }
            if(stage == 3){
                savePreferencesStage3("bestStage3", best);
                Intent four = new Intent(com.example.aldrinmcadelia.myapplication.BestTime.this,LoadingScreen.class);
                four.putExtra("stage",4);
                startActivity(four);
                finish();
            }
            if(stage == 4){
                savePreferencesStage4("bestStage4", best);
                Intent five = new Intent(com.example.aldrinmcadelia.myapplication.BestTime.this,LoadingScreen.class);
                five.putExtra("stage",5);
                startActivity(five);
                finish();
            }
            if(stage == 5){
                savePreferencesStage5("bestStage5", best);
                Intent six = new Intent(com.example.aldrinmcadelia.myapplication.BestTime.this,LoadingScreen.class);
                six.putExtra("stage",6);
                startActivity(six);
                finish();
            }
            if(stage == 6){
                savePreferencesStage6("bestStage6", best);
                Intent seven = new Intent(com.example.aldrinmcadelia.myapplication.BestTime.this,LoadingScreen.class);
                seven.putExtra("stage",7);
                startActivity(seven);
                finish();
            }
            if(stage == 7){
                savePreferencesStage7("bestStage7", best);
                Intent eight = new Intent(com.example.aldrinmcadelia.myapplication.BestTime.this,LoadingScreen.class);
                eight.putExtra("stage",8);
                startActivity(eight);
                finish();
            }
            if(stage == 8){
                savePreferencesStage8("bestStage8", best);
                Intent nine = new Intent(com.example.aldrinmcadelia.myapplication.BestTime.this,LoadingScreen.class);
                nine.putExtra("stage",9);
                startActivity(nine);
                finish();
            }
            if(stage == 9){
                savePreferencesStage9("bestStage9",best);
                Intent back = new Intent(com.example.aldrinmcadelia.myapplication.BestTime.this,LoadingScreen.class);
                back.putExtra("stage",10);
                startActivity(back);
                finish();
            }

        }else{
            setContentView(R.layout.activity_best_time);
        }

        if(passing == 1){
            OurSong.release();
        }else {
            OurSong.start();
        }

        TextView best1 = (TextView) findViewById(R.id.stage1);
        TextView best2 = (TextView) findViewById(R.id.stage2);
        TextView best3 = (TextView) findViewById(R.id.stage3);
        TextView best4 = (TextView) findViewById(R.id.stage4);
        TextView best5 = (TextView) findViewById(R.id.stage5);
        TextView best6 = (TextView) findViewById(R.id.stage6);
        TextView best7 = (TextView) findViewById(R.id.stage7);
        TextView best8 = (TextView) findViewById(R.id.stage8);
        TextView best9 = (TextView) findViewById(R.id.stage9);
        TextView bestT = (TextView) findViewById(R.id.newText);
        Button back = (Button) findViewById(R.id.backToMAin);

        Typeface fontStyle = Typeface.createFromAsset(getAssets(),fontpath);

        bestT.setTypeface(fontStyle);
        back.setTypeface(fontStyle);

        if(loadStage1 > 20000){
            StringBuffer buffer = new StringBuffer();
            buffer.append("Stage 1 : ------");
            best1.setText(buffer);
            best1.setTypeface(fontStyle);
        }else {
            StringBuffer buffer = new StringBuffer();
            buffer.append("Stage 1 :  "+loadStage1/1000%60+"."+loadStage1/100%10+"  seconds");
            best1.setText(buffer);
            best1.setTypeface(fontStyle);
        }
        if(loadStage2 > 20000){
            StringBuffer buffer = new StringBuffer();
            buffer.append("Stage 2 : ------");
            best2.setText(buffer);
            best2.setTypeface(fontStyle);
        }else {
            StringBuffer buffer = new StringBuffer();
            buffer.append("Stage 2 :  "+loadStage2/1000%60+"."+loadStage2/100%10+"  seconds");
            best2.setText(buffer);
            best2.setTypeface(fontStyle);
        }
        if(loadStage3 > 25000){
            StringBuffer buffer = new StringBuffer();
            buffer.append("Stage 3 : ------");
            best3.setText(buffer);
            best3.setTypeface(fontStyle);
        }else {
            StringBuffer buffer = new StringBuffer();
            buffer.append("Stage 3 :  "+loadStage3/1000%60+"."+loadStage3/100%10+"  seconds");
            best3.setText(buffer);
            best3.setTypeface(fontStyle);
        }
        if(loadStage4 > 25000){
            StringBuffer buffer = new StringBuffer();
            buffer.append("Stage 4 : ------");
            best4.setText(buffer);
            best4.setTypeface(fontStyle);
        }else {
            StringBuffer buffer = new StringBuffer();
            buffer.append("Stage 4 :  "+loadStage4/1000%60+"."+loadStage4/100%10+"  seconds");
            best4.setText(buffer);
            best4.setTypeface(fontStyle);
        }
        if(loadStage5 > 30000){
            StringBuffer buffer = new StringBuffer();
            buffer.append("Stage 5 : ------");
            best5.setText(buffer);
            best5.setTypeface(fontStyle);
        }else {
            StringBuffer buffer = new StringBuffer();
            buffer.append("Stage 5 :  "+loadStage5/1000%60+"."+loadStage5/100%10+"  seconds");
            best5.setText(buffer);
            best5.setTypeface(fontStyle);
        }
        if(loadStage6 > 30000){
            StringBuffer buffer = new StringBuffer();
            buffer.append("Stage 6 : ------");
            best6.setText(buffer);
            best6.setTypeface(fontStyle);
        }else {
            StringBuffer buffer = new StringBuffer();
            buffer.append("Stage 6 :  "+loadStage6/1000%60+"."+loadStage6/100%10+"  seconds");
            best6.setText(buffer);
            best6.setTypeface(fontStyle);
        }
        if(loadStage7 > 35000){
            StringBuffer buffer = new StringBuffer();
            buffer.append("Stage 7 : ------");
            best7.setText(buffer);
            best7.setTypeface(fontStyle);
        }else {
            StringBuffer buffer = new StringBuffer();
            buffer.append("Stage 7 :  "+loadStage7/1000%60+"."+loadStage7/100%10+"  seconds");
            best7.setText(buffer);
            best7.setTypeface(fontStyle);
        }
        if(loadStage8 > 35000){
            StringBuffer buffer = new StringBuffer();
            buffer.append("Stage 8 : ------");
            best8.setText(buffer);
            best8.setTypeface(fontStyle);
        }else {
            StringBuffer buffer = new StringBuffer();
            buffer.append("Stage 8 :  "+loadStage8/1000%60+"."+loadStage8/100%10+"  seconds");
            best8.setText(buffer);
            best8.setTypeface(fontStyle);
        }
        if(loadStage9 > 40000){
            StringBuffer buffer = new StringBuffer();
            buffer.append("Stage 9 : ------");
            best9.setText(buffer);
            best9.setTypeface(fontStyle);
        }else {
            StringBuffer buffer = new StringBuffer();
            buffer.append("Stage 9 :  "+loadStage9/1000%60+"."+loadStage9/100%10+"  seconds");
            best9.setText(buffer);
            best9.setTypeface(fontStyle);
        }






    }

    private int loadSavedStage1() {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        return sharedPreferences.getInt("bestStage1", 30020);
    }
    private int loadSavedStage2() {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        return sharedPreferences.getInt("bestStage2", 30020);
    }
    private int loadSavedStage3() {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        return sharedPreferences.getInt("bestStage3", 35020);
    }
    private int loadSavedStage4() {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        return sharedPreferences.getInt("bestStage4", 35020);
    }
    private int loadSavedStage5() {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        return sharedPreferences.getInt("bestStage5", 40020);
    }
    private int loadSavedStage6() {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        return sharedPreferences.getInt("bestStage6", 40020);
    }
    private int loadSavedStage7() {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        return sharedPreferences.getInt("bestStage7", 45020);
    }
    private int loadSavedStage8() {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        return sharedPreferences.getInt("bestStage8", 45020);
    }
    private int loadSavedStage9() {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        return sharedPreferences.getInt("bestStage9", 50020);
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

    public void backtoMain(View view){
        Intent main = new Intent(com.example.aldrinmcadelia.myapplication.BestTime.this,MainActivity.class);
        startActivity(main);
        finish();
    }

    protected void onPause(){
        super.onPause();
        OurSong.release();
        finish();
    }


}
