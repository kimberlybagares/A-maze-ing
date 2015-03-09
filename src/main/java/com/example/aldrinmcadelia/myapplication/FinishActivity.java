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


public class FinishActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        String fontPath = "Lobster_1.3.otf";

        Typeface fontStyle = Typeface.createFromAsset(getAssets(),fontPath);

        Intent mIntent = getIntent();

        final int value = mIntent.getIntExtra("finish",0);
        final int value2 = mIntent.getIntExtra("stage",0);
        final int value3 = mIntent.getIntExtra("bestTime", 0);

        StringBuffer str = new StringBuffer();
        StringBuffer str2 = new StringBuffer();
        StringBuffer str3 = new StringBuffer();

        str.append("Time "+value/1000%60+"."+value/100%10+" seconds");
        str2.append("Stage "+value2+" Complete!");
        str3.append("Best Time "+value3/1000%60+"."+value3/100%10+" seconds");

        TextView text = (TextView) findViewById(R.id.newText);
        TextView text2 = (TextView) findViewById(R.id.newText2);
        TextView text3 = (TextView) findViewById(R.id.newText3);

        text.setText(str2);
        text2.setText(str);
        text3.setText(str3);

        text.setTypeface(fontStyle);
        text2.setTypeface(fontStyle);
        text3.setTypeface(fontStyle);

        Button next = (Button) findViewById(R.id.next);

        next.setTypeface(fontStyle);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value2 == 1){
                    Intent stage2 = new Intent(com.example.aldrinmcadelia.myapplication.FinishActivity.this,BestTime.class);
                    stage2.putExtra("best",value3);
                    stage2.putExtra("stage",value2);
                    stage2.putExtra("pass",1);
                    startActivity(stage2);
                    finish();
                }
                if(value2 == 2){
                    Intent stage3 = new Intent(com.example.aldrinmcadelia.myapplication.FinishActivity.this,BestTime.class);
                    stage3.putExtra("best",value3);
                    stage3.putExtra("stage",value2);
                    stage3.putExtra("pass",1);
                    startActivity(stage3);
                    finish();
                }
                if(value2 == 3){
                    Intent stage4 = new Intent(com.example.aldrinmcadelia.myapplication.FinishActivity.this,BestTime.class);
                    stage4.putExtra("best",value3);
                    stage4.putExtra("stage",value2);
                    stage4.putExtra("pass",1);
                    startActivity(stage4);
                    finish();
                }
                if (value2 == 4){
                    Intent stage5 = new Intent(com.example.aldrinmcadelia.myapplication.FinishActivity.this,BestTime.class);
                    stage5.putExtra("best",value3);
                    stage5.putExtra("stage",value2);
                    stage5.putExtra("pass",1);
                    startActivity(stage5);
                    finish();
                }
                if (value2 == 5){
                    Intent stage6 = new Intent(com.example.aldrinmcadelia.myapplication.FinishActivity.this,BestTime.class);
                    stage6.putExtra("best",value3);
                    stage6.putExtra("stage",value2);
                    stage6.putExtra("pass",1);
                    startActivity(stage6);
                    finish();
                }
                if (value2 == 6){
                    Intent stage7 = new Intent(com.example.aldrinmcadelia.myapplication.FinishActivity.this,BestTime.class);
                    stage7.putExtra("best",value3);
                    stage7.putExtra("stage",value2);
                    stage7.putExtra("pass",1);
                    startActivity(stage7);
                    finish();
                }
                if (value2 == 7){
                    Intent stage8 = new Intent(com.example.aldrinmcadelia.myapplication.FinishActivity.this,BestTime.class);
                    stage8.putExtra("best",value3);
                    stage8.putExtra("stage",value2);
                    stage8.putExtra("pass",1);
                    startActivity(stage8);
                    finish();
                }
                if (value2 == 8){
                    Intent stage9 = new Intent(com.example.aldrinmcadelia.myapplication.FinishActivity.this,BestTime.class);
                    stage9.putExtra("best",value3);
                    stage9.putExtra("stage",value2);
                    stage9.putExtra("pass",1);
                    startActivity(stage9);
                    finish();
                }
                if (value2 == 9){
                    Intent BackStage = new Intent(com.example.aldrinmcadelia.myapplication.FinishActivity.this,BestTime.class);
                    BackStage.putExtra("best",value3);
                    BackStage.putExtra("stage",value2);
                    BackStage.putExtra("pass",1);
                    startActivity(BackStage);
                    finish();
                }

            }
        });
    }




}
