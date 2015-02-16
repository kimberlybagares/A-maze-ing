package com.example.aldrinmcadelia.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;


public class StageThree extends ActionBarActivity {

    AnimatedView animate = null;
    int [][] maze = {
            {0, 0, 0, 0, 0},
            {0, 1, 2, 1, 0},
            {0, 0, 0, 1, 0},
            {1, 1, 2, 1, 0},
            {0, 0, 0, 0, 0}
    };
    Bitmap[] bitmaps = {
            BitmapFactory.decodeResource(getResources(), R.drawable.path),
            BitmapFactory.decodeResource(getResources(), R.drawable.exit),
            BitmapFactory.decodeResource(getResources(), R.drawable.exit)
    };
    //MazeR mazer = new MazeR(bitmaps,maze, 5, 5, 480, 320);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_stage_three);
       animate = new AnimatedView(this);
        setContentView(animate);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_stage_three, menu);
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
    public class AnimatedView extends ImageView {

        static final int width = 30;
        static final int height = 30;

        public AnimatedView(Context context) {
            super(context);
            // TODO Auto-generated constructor stub

        }

    }

}
