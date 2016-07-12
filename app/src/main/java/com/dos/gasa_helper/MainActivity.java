package com.dos.gasa_helper;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private ImageView mBtnMenu;
    private ImageView mBtnLocation;
    private TextView mTvLocation;
    private LinearLayout mLlyMenu;
    private ImageView mImgUser;
    private TextView mTvUserName;
    private ImageView mBtnSignUp;
    private ImageView mBtnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnMenu = (ImageView) findViewById(R.id.btnMenu);
        mBtnLocation = (ImageView) findViewById(R.id.btnLocation);
        mTvLocation = (TextView) findViewById(R.id.tvLocation);
        mLlyMenu = (LinearLayout) findViewById(R.id.llyMenu);
        mImgUser = (ImageView) findViewById(R.id.imgUserImage);
        mTvUserName = (TextView) findViewById(R.id.tvUserName);
        mBtnSignUp = (ImageView) findViewById(R.id.btnSignUp);
        mBtnSignIn = (ImageView) findViewById(R.id.btnSignIn);

        mLlyMenu.setTag(false);
        mBtnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMenuOpened(true);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if ((boolean)mLlyMenu.getTag()) {
            setMenuOpened(false);
        } else {
            super.onBackPressed();
        }
    }

    private void setMenuOpened(boolean param) {
        float fromX = mLlyMenu.getX();
        float toX;
        if (param) {
            toX = fromX + mLlyMenu.getMeasuredWidth();
        } else {
            toX = fromX - mLlyMenu.getMeasuredWidth();
        }

        PropertyValuesHolder pvhSX = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, fromX, toX);
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(mLlyMenu, pvhSX);
        objectAnimator.setDuration(500);
        objectAnimator.setInterpolator(new AccelerateInterpolator());
        objectAnimator.start();

        mLlyMenu.setTag(param);
    }
}
