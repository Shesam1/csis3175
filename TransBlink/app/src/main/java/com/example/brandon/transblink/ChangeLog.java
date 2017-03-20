package com.example.brandon.transblink;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ChangeLog extends AppCompatActivity {

    private int themeSel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ThemeChange themeChg = new ThemeChange();
        themeSel = themeChg.findTheme(this);
        setTheme(themeSel);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_log);
    }
}
