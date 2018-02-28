package com.example.john.viewpagerproject;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 2017/3/13.
 */

public class ActivityCollectior {
    public static List<Activity> activites = new ArrayList<>();
    public static void addActivity(Activity activity){
        activites.add(activity);
    }

    public static void removeActivity(Activity activity){
        activites.remove(activity);
    }

    private static void finishAll(){
        for(Activity activity : activites){
            if (activity != null){
                activity.finish();
            }
        }
    }
}
