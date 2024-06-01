package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import com.example.tcg.R;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    TextView clock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.health_tracker);

        clock = findViewById(R.id.textClock);

        long duration = TimeUnit.MINUTES.toMillis(30);

        new CountDownTimer(duration, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished);
                long seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(minutes);

                String sDuration = String.format(Locale.ENGLISH, "%02d : %02d", minutes, seconds);

                clock.setText(sDuration);
            }

            @Override
            public void onFinish() {
                clock.setText("game over");
            }
        }.start();
    }
}