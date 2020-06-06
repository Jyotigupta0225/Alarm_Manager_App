package com.example.user.alarmmanagerapp;

import android.media.AudioManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
      Button button2;
    Ringtone ringtone;
    AudioManager audioManager;
    int a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN|WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED|WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON|WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        setContentView(R.layout.activity_main2);
       audioManager=(AudioManager) this.getSystemService(AUDIO_SERVICE);
        a=audioManager.getRingerMode();
        audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
        button2=(Button) this.findViewById(R.id.button2);
        button2.setOnClickListener(this);
        Uri uri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        ringtone=RingtoneManager.getRingtone(this,uri);
        ringtone.play();

    }

    @Override
    public void onClick(View v) {
        ringtone.stop();
        audioManager.setRingerMode(a);
        finish();
    }
}
