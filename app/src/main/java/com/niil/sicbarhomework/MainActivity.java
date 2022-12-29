package com.niil.sicbarhomework;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    SeekBar red_bar, green_bar, blue_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        red_bar = findViewById(R.id.red_bar);
        green_bar = findViewById(R.id.green_bar);
        blue_bar = findViewById(R.id.blue_bar);

        SeekBar.OnSeekBarChangeListener barListener = new MyRGBBarListener(red_bar, green_bar, blue_bar,
                findViewById(R.id.main));

        red_bar.setOnSeekBarChangeListener(barListener);
        green_bar.setOnSeekBarChangeListener(barListener);
        blue_bar.setOnSeekBarChangeListener(barListener);
    }
}

class MyRGBBarListener implements SeekBar.OnSeekBarChangeListener{
    SeekBar red_bar, green_bar, blue_bar;
    View view;

    public MyRGBBarListener(SeekBar red_bar, SeekBar green_bar, SeekBar blue_bar, View view) {
        this.red_bar = red_bar;
        this.green_bar = green_bar;
        this.blue_bar = blue_bar;
        this.view = view;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        int red_progress = red_bar.getProgress();
        int green_progress = green_bar.getProgress();
        int blue_progress = blue_bar.getProgress();
        view.setBackgroundColor(Color.rgb(red_progress, green_progress, blue_progress));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) { }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) { }
}