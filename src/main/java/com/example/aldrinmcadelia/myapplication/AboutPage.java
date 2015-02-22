package com.example.aldrinmcadelia.myapplication;


import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Type;

public class AboutPage extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_page);

        String fontPath = "black_jack.ttf";
        String fontPath2 = "GoodDog.otf";

        TextView about = (TextView) findViewById(R.id.aboutText);
        TextView about2 = (TextView) findViewById(R.id.aboutText2);
        TextView back = (TextView) findViewById(R.id.back_main);

        Typeface aboutView = Typeface.createFromAsset(getAssets(), fontPath);
        Typeface aboutView2 = Typeface.createFromAsset(getAssets(),fontPath2);
        Typeface back_main = Typeface.createFromAsset(getAssets(), fontPath2);

        about.setTypeface(aboutView);
        about2.setTypeface(aboutView2);
        back.setTypeface(back_main);
    }

 /*  @Override
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
    }*/

    public void backPage(View view){
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
        finish();

    }

}
