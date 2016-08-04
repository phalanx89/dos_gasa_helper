package com.dos.gasa_helper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * 로딩화면 액티비티
 * Created by Hago on 2016-07-12.
 */
public class LoadingActivity extends Activity{
    private static final String TAG = LoadingActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        //connect server

        //get user information

        Intent intentSubActivity =  new Intent(LoadingActivity.this, MainActivity.class);
        startActivity(intentSubActivity);
        overridePendingTransition(0, 0);

        finish();
    }
}
