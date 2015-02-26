package com.example.aldrinmcadelia.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;


public class Stageone extends Activity implements SensorEventListener
{

    private SensorManager mSensorManager;
    private SurfaceHolder mHolder;
    private float xSensor=0;
    private float ySensor=0;
    private Maze numMaze;
    private BallClass ball;
    private int height=0,width=0;
    private StringBuffer str1,str2;
    private int timer;
    private boolean interrupt = false;
    private boolean touch=false;
    private boolean finish=false;
    private boolean best=false;
    MyView newView;
    FrameLayout game;
    RelativeLayout GameButtons;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        newView = new MyView(this);
        game = new FrameLayout(this);
        GameButtons = new RelativeLayout(this);
        Button button1 = new Button(this);
        button1.setText("Pause");
        button1.setId(1234567);
        RelativeLayout.LayoutParams b1 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.FILL_PARENT
        );
        GameButtons.setLayoutParams(params);
        GameButtons.addView(button1);
        b1.addRule(RelativeLayout.ALIGN_PARENT_LEFT,RelativeLayout.TRUE);
        b1.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,RelativeLayout.TRUE);
        button1.setLayoutParams(b1);
        game.addView(newView);
        game.addView(GameButtons);
        setContentView(game);

        //Keep screen on
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        mSensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        // add listener.
        mSensorManager.registerListener(this,
                mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    private int loadSavedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        return sharedPreferences.getInt("Btime", 86400000);
    }

    private void savePreferences(String key, int value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    class MyView extends SurfaceView implements SurfaceHolder.Callback
    {
        public MyView(Context context)
        {
            super(context);
            mHolder = getHolder();
            mHolder.addCallback(this);

        }
        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width,
                                   int height) {
        }
        @Override
        public void surfaceCreated(SurfaceHolder holder)
        {
            height=getHeight();
            width=getWidth();
            numMaze=new Maze();
            numMaze.setSize(10, 10);
            numMaze.setWindow(height, width);
            numMaze.createMaze(height,width);
            ball = new BallClass();
            ball.setRadius(numMaze.getSize()/3);
            ball.setCorner(numMaze.getTop(), numMaze.getBottom(), numMaze.getLeft(), numMaze.getRight());
            ball.initialize();
            timer= 0;
            new Thread(new MyThread()).start();
        }
        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {

        }
    }

    @Override
    protected void onDestroy() {
        interrupt = true;
        mSensorManager.unregisterListener(this);
        super.onDestroy();
//        Thread.currentThread().interrupt();
    }




    class MyThread implements Runnable{
        @Override
        public void run() {
            Canvas canvas = null;

            int Btime=loadSavedPreferences();
            while (ball.getI()!=numMaze.getRow()-1 || ball.getJ()!=numMaze.getColumn()-1){
                try {
                    canvas = mHolder.lockCanvas();//get Canvas
                    canvas.drawColor(Color.WHITE);//Set background color
                    Paint mPaint = new Paint();

                    mPaint.setColor(Color.BLACK);//set pen color
                    //mPaint.setStyle(Paint.Style.STROKE);//framed instead of filled.

                    str1=new StringBuffer();
                    str2=new StringBuffer();

                    //str1.append("Best Time= "+Btime/1000%(60*60*60)/(60*60)+":"+Btime/1000%(60*60)/60+":"+Btime/1000%60+"."+Btime/100%10);
                    str2.append("Time = "+timer/1000%(60*60*60)/(60*60)+":"+timer/1000%(60*60)/60+":"+timer/1000%60+"."+timer/100%10);
                    mPaint.setTextSize(24);
                    canvas.drawText("Beat the maze", (width-1*str1.toString().length())/(float)4, (height-numMaze.getRight()+numMaze.getOffset())/(float)2, mPaint);
                    canvas.drawText("within 30 seconds", (width-1*str1.toString().length())/3, (height-numMaze.getRight()+numMaze.getOffset())/(float)1.5, mPaint);
                    canvas.drawText(str2.toString(), (width-12*str2.toString().length())/2, (height+numMaze.getRight()+numMaze.getOffset())/2, mPaint);
                    numMaze.drawMaze(canvas, mPaint);
                    ball.setxAcc(xSensor);
                    ball.setyAcc(ySensor);
                    ball.updatePosition(numMaze);
                    mPaint.setColor(Color.CYAN);//set pen color
                    ball.drawBall(canvas, mPaint);
                    Thread.sleep(33);
                    if (timer<30000)//86400000 is the limit of timer, which is a day.
                        timer+=33;
                    //                  Log.d("MainActivity", "runinng");
                } catch (Exception e) {
                } finally {
                    if (canvas!=null)
                        mHolder.unlockCanvasAndPost(canvas);//unlock the Canvas and post.
                }
            }
            canvas = mHolder.lockCanvas();//get Canvas
            if (canvas!=null){
                canvas.drawColor(Color.WHITE);//Set background color
                Paint mPaint = new Paint();
                mPaint.setColor(Color.BLACK);//set pen color
                str1=new StringBuffer();
                str2=new StringBuffer();
                if (best==false && timer<Btime){//it's in while loop, so the comparison will be on-going, so add a flag.
                    best=true;
                    savePreferences("Btime",timer);
                }
                if (best==true)
                    str1.append("New best score!!");
                str2.append("Your Time = "+timer/1000%(60*60*60)/(60*60)+":"+timer/1000%(60*60)/60+":"+timer/1000%60+"."+timer/100%10);
                mPaint.setTextSize(24);
                //canvas.drawText(str1.toString(), (width-12*str1.toString().length())/2, (height-numMaze.getRight()+numMaze.getOffset())/2, mPaint);
                canvas.drawText(str2.toString(), (width-12*str2.toString().length())/2, (height+numMaze.getRight()+numMaze.getOffset())/2, mPaint);
                numMaze.drawMaze(canvas, mPaint);
                mPaint.setColor(Color.CYAN);//set pen color
                ball.drawBall(canvas, mPaint);
                mHolder.unlockCanvasAndPost(canvas);//unlock the Canvas and post.
            }
            finish=true;
            if(finish==true){
                startActivity(new Intent(com.example.aldrinmcadelia.myapplication.Stageone.this,Pop_upActivity.class));
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent evt)
    {
        if(evt.getAction() == MotionEvent.ACTION_DOWN)
        {
            if (finish==true)
                touch=true;
        }
        return true;
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void onSensorChanged(SensorEvent event){

        if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){

            xSensor=-event.values[0];
            ySensor=event.values[1];
        }
    }

}


