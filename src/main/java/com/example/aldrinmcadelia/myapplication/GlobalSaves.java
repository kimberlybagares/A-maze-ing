package com.example.aldrinmcadelia.myapplication;

/**
 * Created by Aldrin M Cadeliña on 3/6/2015.
 */

import java.util.ArrayList;
import java.util.List;
import android.app.Application;
import android.content.Context;

public class GlobalSaves extends Application {
    Context context;
    public GlobalSaves(Context mxt) {

        context = mxt;

    }

    public static String filepath = null;
}
