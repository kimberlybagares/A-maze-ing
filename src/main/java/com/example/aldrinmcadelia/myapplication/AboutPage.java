package com.example.aldrinmcadelia.myapplication;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Type;

public class AboutPage extends Activity {

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


    public void backPage(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }

    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (Integer.parseInt(android.os.Build.VERSION.SDK) < 5
                && keyCode == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0) {
            Log.d("CDA", "onKeyDown Called");
            onBackPressed();
        }

        return super.onKeyDown(keyCode, event);
    }
    @Override
    public void onBackPressed() {
        Log.d("CDA", "onBackPressed Called");
        Intent setIntent = new Intent(Intent.ACTION_MAIN);
        setIntent.addCategory(Intent.CATEGORY_HOME);
        setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(setIntent);
    }

}
