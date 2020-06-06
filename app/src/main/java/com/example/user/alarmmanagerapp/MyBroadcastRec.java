package com.example.user.alarmmanagerapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by user on 06-01-2018.
 */

public class MyBroadcastRec extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        intent=new Intent(context,Main2Activity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}

