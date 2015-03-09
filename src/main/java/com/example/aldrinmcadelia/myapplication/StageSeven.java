package com.example.aldrinmcadelia.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;


public class StageSeven extends Activity implements SensorEventListener
{

    private SensorManager mSensorManager;
    private SurfaceHolder mHolder;
    private float xSensor=0;

    private float ySensor=0;
    private Maze numMaze;
    private BallClass ball;
    private int height=0,width=0;
    private StringBuffer str1,str2,timeStr;
    private int timer;

    private boolean interrupt = false;
    private boolean touch=false;
    private boolean finish=false;
    private boolean best=false;
    private boolean gameOver = false;
    private boolean pause = false;

    String FontPath = "Lobster_1.3.otf";

    MyView newView;
    FrameLayout game;
    RelativeLayout GameButtons;
    RelativeLayout PauseLayout;
    RelativeLayout BackToStagePage;
    RelativeLayout gameIsFinish;

    PopupWindow NextStage;
    PopupWindow PauseWindow;
    PopupWindow ToStagePage;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        newView = new MyView(this);

        game = new FrameLayout(this);
        GameButtons = new RelativeLayout(this);
        PauseLayout = new RelativeLayout(this);
        BackToStagePage = new RelativeLayout(this);

        Drawable colorBlue = this.getResources().getDrawable(R.drawable.selectcolor);
        Drawable colorBlue2 = this.getResources().getDrawable(R.drawable.selectcolor);
        Drawable colorBlue3 = this.getResources().getDrawable(R.drawable.selectcolor);
        Drawable colorBlue4 = this.getResources().getDrawable(R.drawable.selectcolor);
        Drawable colorBlue5 = this.getResources().getDrawable(R.drawable.selectcolor);
        Drawable colorBlack = this.getResources().getDrawable(R.drawable.blueborder);
        Typeface fontStyle = Typeface.createFromAsset(getAssets(),FontPath);

        TextView StageName = new TextView(this);
        TextView Text = new TextView(this);
        TextView Question = new TextView(this);

        Button Pause = new Button(this);
        Button MainBack = new Button(this);
        Button Resume = new Button(this);
        Button Yes = new Button(this);
        Button No = new Button(this);

        Pause.setBackground(colorBlue2);
        MainBack.setBackground(colorBlue3);
        Resume.setBackground(colorBlue4);
        Yes.setBackground(colorBlue5);
        No.setBackground(colorBlue);


        StageName.setTextColor(Color.WHITE);
        Text.setTextColor(Color.WHITE);
        Pause.setTextColor(Color.WHITE);
        Resume.setTextColor(Color.WHITE);
        MainBack.setTextColor(Color.WHITE);
        Question.setTextColor(Color.WHITE);
        Yes.setTextColor(Color.WHITE);
        No.setTextColor(Color.WHITE);

        StageName.setText("Stage 7");
        Pause.setText("Pause");
        MainBack.setText("Stages");
        Yes.setText("Yes!");
        No.setText("No!");
        Text.setText(" Game Pause");
        Resume.setText("Resume");
        Question.setText("Are you sure you want to leave this stage?");

        StageName.setTypeface(fontStyle);
        Pause.setTypeface(fontStyle);
        MainBack.setTypeface(fontStyle);
        Yes.setTypeface(fontStyle);
        No.setTypeface(fontStyle);
        Text.setTypeface(fontStyle);
        Resume.setTypeface(fontStyle);
        Question.setTypeface(fontStyle);

        StageName.setTextSize(20);
        Text.setTextSize(25);
        Question.setTextSize(20);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.FILL_PARENT
        );
        RelativeLayout.LayoutParams b1 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams b2 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        RelativeLayout.LayoutParams b3 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        RelativeLayout.LayoutParams b4 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        RelativeLayout.LayoutParams b5 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        RelativeLayout.LayoutParams b6 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        b1.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        b1.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        b2.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
        b2.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,RelativeLayout.TRUE);
        b3.addRule(RelativeLayout.CENTER_IN_PARENT,RelativeLayout.TRUE);
        b4.addRule(RelativeLayout.CENTER_HORIZONTAL,RelativeLayout.TRUE);
        b5.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,RelativeLayout.TRUE);
        b5.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,RelativeLayout.TRUE);
        b5.addRule(RelativeLayout.CENTER_IN_PARENT,RelativeLayout.TRUE);
        b6.addRule(RelativeLayout.ALIGN_PARENT_LEFT,RelativeLayout.TRUE);
        b6.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,RelativeLayout.TRUE);
        b6.addRule(RelativeLayout.CENTER_IN_PARENT,RelativeLayout.TRUE);




        GameButtons.setLayoutParams(params);
        GameButtons.addView(Pause);
        GameButtons.addView(MainBack);
        PauseLayout.setLayoutParams(params);
        PauseLayout.setBackground(colorBlack);
        BackToStagePage.setLayoutParams(params);
        BackToStagePage.setBackground(colorBlack);
        BackToStagePage.setPadding(20,20,20,20);

        Pause.setLayoutParams(b1);
        MainBack.setLayoutParams(b2);
        Resume.setLayoutParams(b3);
        Yes.setLayoutParams(b6);
        No.setLayoutParams(b5);
        Text.setLayoutParams(b4);
        Question.setLayoutParams(b4);


        game.addView(newView);
        game.addView(GameButtons);
        setContentView(game);
        PauseLayout.addView(Text);
        PauseLayout.addView(Resume);
        BackToStagePage.addView(Question);
        BackToStagePage.addView(Yes);
        BackToStagePage.addView(No);

        PauseWindow = new PopupWindow(PauseLayout,400,200,true);
        ToStagePage = new PopupWindow(BackToStagePage,400,200,true);


        Pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPauseButton();
                PauseWindow.showAtLocation(PauseLayout,Gravity.CENTER,0,0);
            }
        });
        Resume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onResumeButton();
                PauseWindow.dismiss();
            }
        });
        MainBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPauseButton();
                ToStagePage.showAtLocation(BackToStagePage,Gravity.CENTER,0,0);
            }
        });
        No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onResumeButton();
                ToStagePage.dismiss();
            }
        });
        Yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent stage = new Intent(com.example.aldrinmcadelia.myapplication.StageSeven.this,StagePage.class);
                startActivity(stage);
                finish();
            }
        });


        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        mSensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);

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
            numMaze.setSize(19, 19);
            numMaze.setWindow(height, width);
            numMaze.createMaze(height,width);
            ball = new BallClass();
            ball.setRadius(numMaze.getSize()/3);
            ball.setCorner(numMaze.getTop(), numMaze.getBottom(), numMaze.getLeft(), numMaze.getRight());
            ball.initialize();
            timer= 0;
            if(gameOver != true){
                new Thread(new MyThread()).start();
            }

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
            Typeface fontStyle = Typeface.createFromAsset(getAssets(),FontPath);
            while (ball.getI()!=numMaze.getRow()-1 || ball.getJ()!=numMaze.getColumn()-1){
                try {
                    canvas = mHolder.lockCanvas();//get Canvas
                    canvas.drawColor(Color.BLACK);//Set background color
                    Paint mPaint = new Paint();
                    Paint nPaint = new Paint();

                    mPaint.setColor(Color.BLUE);//set pen color
                    mPaint.setStrokeJoin(Paint.Join.MITER);
                    mPaint.setStrokeWidth(3f);

                    nPaint.setColor(Color.BLUE);

                    //mPaint.setStyle(Paint.Style.STROKE);//framed instead of filled.
                    str1=new StringBuffer();
                    str2=new StringBuffer();

                    //str1.append("Best Time= "+Btime/1000%(60*60*60)/(60*60)+":"+Btime/1000%(60*60)/60+":"+Btime/1000%60+"."+Btime/100%10);
                    str2.append(""+timer/1000%60+"."+timer/100%10+"s");

                    mPaint.setTextSize(40);
                    nPaint.setTextSize(80);

                    mPaint.setTypeface(fontStyle);
                    nPaint.setTypeface(fontStyle);

                    canvas.drawText("Stage 7", (width-1*str1.toString().length())/(float)20, (height-numMaze.getRight()+numMaze.getOffset())/(float)2, nPaint);
                    canvas.drawText("Limit: 35s", (width-1*str1.toString().length())/(float)1.5, (height-numMaze.getRight()+numMaze.getOffset())/(float)1.5, mPaint);
                    canvas.drawText(str2.toString(), (width-12*str2.toString().length())/2, (height+numMaze.getRight()+numMaze.getOffset())/(float)2.1, mPaint);
                    numMaze.drawMaze(canvas, mPaint);
                    mPaint.setColor(Color.CYAN);//set pen color
                    ball.drawBall(canvas, mPaint);
                    if(pause!=true){
                        Thread.sleep(33);
                        if(timer < 35000){
                            ball.setxAcc(xSensor);
                            ball.setyAcc(ySensor);
                            ball.updatePosition(numMaze);
                            timer+=33;
                        }

                    }
                    if(timer>35000){
                        ball.setI(numMaze.getRow()-1);
                        ball.setJ(numMaze.getColumn()-1);
                        gameOver = true;
                    }
                } catch (Exception e) {
                } finally {
                    if (canvas!=null)
                        mHolder.unlockCanvasAndPost(canvas);
                }
            }
            canvas = mHolder.lockCanvas();//get Canvas
            if (canvas!=null){
                canvas.drawColor(Color.BLACK);//Set background color
                Paint mPaint = new Paint();
                mPaint.setColor(Color.BLACK);//set pen color
                if (best==false && timer<Btime){//it's in while loop, so the comparison will be on-going, so add a flag.
                    best=true;
                    savePreferences("Btime",timer);
                }
                numMaze.drawMaze(canvas, mPaint);
                mPaint.setColor(Color.CYAN);//set pen color
                ball.drawBall(canvas, mPaint);
                mHolder.unlockCanvasAndPost(canvas);
            }
            if(gameOver!=true){
                if(timer<Btime){
                    Intent finish = new Intent(com.example.aldrinmcadelia.myapplication.StageSeven.this,StagePage.class);
                    finish.putExtra("finish",timer);
                    finish.putExtra("stage", 7);
                    finish.putExtra("bestTime", timer);
                    finish.putExtra("pass",1);
                    startActivity(finish);
                    finish();
                }
                if(timer>Btime){
                    Intent finish = new Intent(com.example.aldrinmcadelia.myapplication.StageSeven.this,StagePage.class);
                    finish.putExtra("finish",timer);
                    finish.putExtra("stage", 7);
                    finish.putExtra("bestTime", Btime);
                    finish.putExtra("pass",1);
                    startActivity(finish);
                    finish();
                }
            }
            if(gameOver==true){
                finish();
                Intent gameOver = new Intent(com.example.aldrinmcadelia.myapplication.StageSeven.this,GameOver.class);
                gameOver.putExtra("stageNo",7);
                startActivity(gameOver);
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
    public void onPauseButton(){
        pause = true;
    }
    public void onResumeButton(){
        pause = false;
    }

}


