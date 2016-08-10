package com.dos.gasa_helper;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * 메인 화면 액티비티
 * Created by Hago on 2016-07-12.
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private ImageView mBtnMenu;
    private ImageView mBtnLocation;
    private TextView mTvLocation;
    private LinearLayout mLlyMenu;
    private RelativeLayout mRlyTitle;
    private RelativeLayout mRlyContent;
    private ImageView mImgUser;
    private TextView mTvUserName;
    private ImageView mBtnSignUp;
    private ImageView mBtnSignIn;
    private ImageView mBtnCleaning;
    private ImageView mBtnLaundry;
    private ImageView mBtnCarWashing;
    private ImageView mBtnDishWashing;
    private ImageView mBtnPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnMenu = (ImageView) findViewById(R.id.btnMenu);
        mBtnLocation = (ImageView) findViewById(R.id.btnLocation);
        mTvLocation = (TextView) findViewById(R.id.tvLocation);
        mLlyMenu = (LinearLayout) findViewById(R.id.llyMenu);
        mRlyTitle = (RelativeLayout) findViewById(R.id.rlyTitle);
        mRlyContent = (RelativeLayout) findViewById(R.id.rlyContent);
        mImgUser = (ImageView) findViewById(R.id.imgUserImage);
        mTvUserName = (TextView) findViewById(R.id.tvUserName);
        mBtnSignUp = (ImageView) findViewById(R.id.btnSignUp);
        mBtnSignIn = (ImageView) findViewById(R.id.btnSignin);
        mBtnCleaning = (ImageView) findViewById(R.id.btnCleaning);
        mBtnLaundry = (ImageView) findViewById(R.id.btnLaundry);
        mBtnCarWashing = (ImageView) findViewById(R.id.btnCarWashing);
        mBtnDishWashing = (ImageView) findViewById(R.id.btnDishWashing);
        mBtnPet = (ImageView) findViewById(R.id.btnPet);

        //set view's initial state
        mLlyMenu.setTag(false);

        //set button listener
        mBtnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMenuOpened(!(boolean) mLlyMenu.getTag());
            }
        });
        mBtnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mBtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
        mBtnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });
        mBtnCleaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
                intent.putExtra("category", getString(R.string.category_cleaning));
                startActivity(intent);
            }
        });
        mBtnLaundry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
                intent.putExtra("category", getString(R.string.category_laundry));
                startActivity(intent);
            }
        });
        mBtnCarWashing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
                intent.putExtra("category", getString(R.string.category_car_washing));
                startActivity(intent);
            }
        });
        mBtnDishWashing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
                intent.putExtra("category", getString(R.string.category_dish_washing));
                startActivity(intent);
            }
        });
        mBtnPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
                intent.putExtra("category", getString(R.string.category_pet));
                startActivity(intent);
            }
        });

        //set user information
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        if ((boolean) mLlyMenu.getTag()) {
            setMenuOpened(false);
        } else {
            super.onBackPressed();
        }
    }

    /**
     * 사이드 메뉴 열고 닫기
     *
     * @param param true : 열림, false : 닫힘
     */
    private void setMenuOpened(boolean param) {
        float fromX = mLlyMenu.getX();
        float fromX2 = mRlyTitle.getX();
        float toX;
        float toX2;
        if (param) {
            toX = fromX + mLlyMenu.getMeasuredWidth();
            toX2 = fromX2 + mLlyMenu.getMeasuredWidth();
        } else {
            toX = fromX - mLlyMenu.getMeasuredWidth();
            toX2 = fromX2 - mLlyMenu.getMeasuredWidth();
        }

        mLlyMenu.setTag(param);

        PropertyValuesHolder pvhSX = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, fromX, toX);
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(mLlyMenu, pvhSX);
        objectAnimator.setDuration(300);
        objectAnimator.setInterpolator(new AccelerateInterpolator());
        objectAnimator.start();

        PropertyValuesHolder pvhSX2 = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, fromX2, toX2);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofPropertyValuesHolder(mRlyTitle, pvhSX2);
        objectAnimator2.setDuration(300);
        objectAnimator2.setInterpolator(new AccelerateInterpolator());
        objectAnimator2.start();

        PropertyValuesHolder pvhSX3 = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, fromX2, toX2);
        ObjectAnimator objectAnimator3 = ObjectAnimator.ofPropertyValuesHolder(mRlyContent, pvhSX3);
        objectAnimator3.setDuration(300);
        objectAnimator3.setInterpolator(new AccelerateInterpolator());
        objectAnimator3.start();
    }
}
