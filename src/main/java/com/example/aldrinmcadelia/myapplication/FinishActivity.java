package com.example.aldrinmcadelia.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class FinishActivity extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        Intent mIntent = getIntent();
        String passed = getIntent().getExtras().getString("finish");

        int value = mIntent.getIntExtra("finish",0);
        int value2 = mIntent.getIntExtra("stage",0);
        int value3 = mIntent.getIntExtra("bestTime", 0);

        StringBuffer str = new StringBuffer();
        StringBuffer str2 = new StringBuffer();
        StringBuffer str3 = new StringBuffer();

        str.append(""+value/1000%60+":"+value/100%10+"s");
        str2.append("Stage "+value2);
        str3.append("bestTime:"+value3/1000%60+":"+value3/100%10);

        TextView text = (TextView) findViewById(R.id.newText);
        //text.setText(str3);
        //text.setText("Congrats! you finish the Fist Stage");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_finish, menu);
        return true;
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
}
