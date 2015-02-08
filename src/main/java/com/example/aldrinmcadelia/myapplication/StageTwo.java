package com.example.aldrinmcadelia.myapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StageTwo extends Activity implements SensorEventListener
{
    /** Called when the activity is first created. */
    CustomDrawableView mCustomDrawableView = null;
    ShapeDrawable mDrawable = new ShapeDrawable();
    public static int x;
    public static int y;
    public static int z;
    private SensorManager sensorManager = null;
    TextView x1, y1, z1;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        // Get a reference to a SensorManager
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mCustomDrawableView = new CustomDrawableView(this);
        setContentView(mCustomDrawableView);
        //setContentView(R.layout.main);

    }

    // This method will update the UI on new sensor events
    public void onSensorChanged(SensorEvent sensorEvent)
    {
        {
            if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {

                //TextView tvX= (TextView)findViewById(R.id.x_axis);
                //TextView tvY= (TextView)findViewById(R.id.y_axis);
                //TextView tvZ= (TextView)findViewById(R.id.z_axis);

                x -= (int) sensorEvent.values[0];
                y += (int) sensorEvent.values[1];
                z += (int) sensorEvent.values[2];

            }

            //   if (sensorEvent.sensor.getType() == Sensor.TYPE_ORIENTATION) {

            //  }
        }
    }

    // I've chosen to not implement this method
    public void onAccuracyChanged(Sensor arg0, int arg1)
    {
        // TODO Auto-generated method stub

    }

    @Override
    protected void onResume()
    {
        super.onResume();
        // Register this class as a listener for the accelerometer sensor
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_FASTEST);
        // ...and the orientation sensor

    }

    @Override
    protected void onStop()
    {
        // Unregister the listener
        sensorManager.unregisterListener(this);
        super.onStop();
    }

    public class CustomDrawableView extends View
    {
        static final int width = 150;
        static final int height = 250;

        public CustomDrawableView(Context context)
        {
            super(context);

            mDrawable = new ShapeDrawable(new RectShape());
            mDrawable.getPaint().setColor(0xff74AC23);
            mDrawable.setBounds(x, y, x + width, y + height);

        }

        protected void onDraw(Canvas canvas)
        {

            RectF rect = new RectF(StageTwo.x, StageTwo.y, StageTwo.x + width, StageTwo.y
                    + height); // set bounds of rectangle
            Paint p = new Paint(); // set some paint options
            p.setColor(Color.BLUE);
            canvas.drawRect(rect, p);
            invalidate();
        }
    }
}
