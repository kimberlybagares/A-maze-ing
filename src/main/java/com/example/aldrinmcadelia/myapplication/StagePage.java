package com.example.aldrinmcadelia.myapplication;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class StagePage extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage_page);

        String fontPath = "black_jack.ttf";
        String fontPath2 = "GoodDog.otf";

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
        Typeface oneView = Typeface.createFromAsset(getAssets(), fontPath);
        Typeface twoView = Typeface.createFromAsset(getAssets(), fontPath);
        Typeface threeView = Typeface.createFromAsset(getAssets(), fontPath);
        Typeface fourView = Typeface.createFromAsset(getAssets(), fontPath);
        Typeface fiveView = Typeface.createFromAsset(getAssets(), fontPath);
        Typeface sixView = Typeface.createFromAsset(getAssets(), fontPath);
        Typeface sevenView = Typeface.createFromAsset(getAssets(), fontPath);
        Typeface eightView = Typeface.createFromAsset(getAssets(), fontPath);
        Typeface nineView = Typeface.createFromAsset(getAssets(), fontPath);
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


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void backPage(View view){
        Intent intent = new Intent(this, MainActivity.class);
        finish();
        startActivity(intent);

    }
    public void stageOne(View view){
        Intent intent = new Intent(this, Stageone.class);
        finish();
        startActivity(intent);
    }

    public void stageTwo(View view){
        Intent intent = new Intent(this, StageTwo.class);
        finish();
        startActivity(intent);
    }
}
