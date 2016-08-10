package com.dos.gasa_helper;

import android.app.Activity;
import android.os.Bundle;

/**
 * 로그인 화면
 * Created by Hago on 2016-08-10.
 */
public class SignInActivity extends Activity {
    private static final String TAG = SignInActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
    }
}
