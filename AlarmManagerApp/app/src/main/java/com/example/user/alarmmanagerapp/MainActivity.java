package com.example.user.alarmmanagerapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText;
    Button button;
      AlarmManager alarmManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alarmManager=(AlarmManager) this.getSystemService(ALARM_SERVICE);
        editText=(EditText)this.findViewById(R.id.editText);
        button=(Button) this.findViewById(R.id.button);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String data=editText.getText().toString();
        int sec=Integer.parseInt(data);
        Intent intent=new Intent(this, MyBroadcastRec.class);
        PendingIntent pi=PendingIntent.getBroadcast(this,123,intent,0);
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+(1000*sec),pi);
        Toast.makeText(this, "Alarm plays after"+sec+"seconds", Toast.LENGTH_SHORT).show();
    }
}
