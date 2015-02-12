
package com.example.aldrinmcadelia.myapplication;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.example.aldrinmcadelia.myapplication.AmazedView;


/**
 * Activity responsible for controlling the application.
 */
public class StageTwo extends Activity {

    // custom view
    private AmazedView mView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // remove title bar.
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // setup our view, give it focus and display.
        mView = new AmazedView(getApplicationContext(), this);
        mView.setFocusable(true);
        setContentView(mView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mView.registerListener();
    }

    @Override
    public void onSaveInstanceState(Bundle icicle) {
        super.onSaveInstanceState(icicle);
        mView.unregisterListener();
    }
}