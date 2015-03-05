package com.example.aldrinmcadelia.myapplication;

import android.app.Activity;
import android.content.Intent;
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

        Intent mIntent = getIntent();

        int value = mIntent.getIntExtra("finish",0);
        final int value2 = mIntent.getIntExtra("stage",0);
        int value3 = mIntent.getIntExtra("bestTime", 0);

        StringBuffer str = new StringBuffer();
        StringBuffer str2 = new StringBuffer();
        StringBuffer str3 = new StringBuffer();

        str.append("Time "+value/1000%60+"."+value/100%10+"s");
        str2.append("Stage "+value2+" Complete!");
        str3.append("Best Time "+value3/1000%60+"."+value3/100%10+"s");

        TextView text = (TextView) findViewById(R.id.newText);
        TextView text2 = (TextView) findViewById(R.id.newText2);
        TextView text3 = (TextView) findViewById(R.id.newText3);

        text.setText(str2);
        text2.setText(str);
        text3.setText(str3);

        Button next = (Button) findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value2 == 1){
                    Intent stage2 = new Intent(com.example.aldrinmcadelia.myapplication.FinishActivity.this,StageTwo.class);
                    startActivity(stage2);
                    finish();
                }
                if(value2 == 2){
                    Intent stage3 = new Intent(com.example.aldrinmcadelia.myapplication.FinishActivity.this,StageThree.class);
                    startActivity(stage3);
                    finish();
                }
                if(value2 == 3){

                }

            }
        });
    }




}
