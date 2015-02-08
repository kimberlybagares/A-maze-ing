package com.example.aldrinmcadelia.myapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class Stageone extends Activity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor accelerometer;
    private long lastUpdate;

    AnimatedView animatedView = null;
    ShapeDrawable mDrawable = new ShapeDrawable();
    public int x;
    public int y;
    public float xmax;
    public float ymax;
    public float frametime = 0.666f;
    public float xAcceleration,xVelocity = 0.0f;
    public float yAcceleration,yVelocity = 0.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer = sensorManager
                .getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        lastUpdate = System.currentTimeMillis();

        animatedView = new AnimatedView(this);
        setContentView(animatedView);
        //setContentView(R.layout.activity_stageone);
        //RelativeLayout.LayoutParams Lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //addContentView(animatedView, Lp);

        Display display = getWindowManager().getDefaultDisplay();
        xmax = (float)display.getWidth() - 50;
        ymax = (float)display.getHeight() - 50;
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, accelerometer,
                SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_stageone, menu);
        return true;
    }

    @Override
    public void onAccuracyChanged(Sensor arg0, int arg1) {
        // TODO Auto-generated method stub

    }

    public void updateBall(){
        xVelocity += (xAcceleration*frametime);
        yVelocity += (yAcceleration*frametime);

        float xS = (xVelocity/2)* frametime;
        float yS = (yVelocity/2)* frametime;

        x -= xS;
        y -= yS;

        if (x > xmax) {
            x = (int) xmax;
        } else if (x < 0) {
            x = 0;
        }
        if (y > ymax) {
            y = (int) ymax;
        } else if (y < 0) {
            y = 0;
        }

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        // TODO Auto-generated method stub
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {

            //x -= (int) Math.pow(event.values[0],3);
            //y += (int) Math.pow(event.values[1],3);
            x -= (int) event.values[0];
            y += (int) event.values[1];
            updateBall();

        }
    }

    public class AnimatedView extends ImageView {

        static final int width = 30;
        static final int height = 30;

        public AnimatedView(Context context) {
            super(context);
            // TODO Auto-generated constructor stub

            mDrawable = new ShapeDrawable(new OvalShape());
            mDrawable.getPaint().setColor(0xffffAC23);
            mDrawable.setBounds(x, y, x + width, y + height);


        }

        @Override
        protected void onDraw(Canvas canvas) {

            mDrawable.setBounds(x, y, x + width, y + height);
            mDrawable.draw(canvas);
            Display display = getWindowManager().getDefaultDisplay();
            invalidate();
        }
    }
}