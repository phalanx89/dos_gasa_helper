package com.dos.gasa_helper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * 카테고리 화면 액티비티
 * Created by Hago on 2016-08-04.
 */
public class CategoryActivity extends Activity {
    private static final String TAG = CategoryActivity.class.getSimpleName();

    private TextView mTvCategory;
    private ListView mListView;
    private CategoryListViewAdapter mListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        //Category setting
        Intent intent = getIntent();
        String strCategory = "";
        if (intent != null) {
            strCategory = intent.getExtras().getString("category");
        }

        mTvCategory = (TextView) findViewById(R.id.tvCategory);
        mListView = (ListView) findViewById(R.id.lvUser);
        mListViewAdapter = new CategoryListViewAdapter();
        mListView.setAdapter(mListViewAdapter);

        //test data
        FakeUserData.setListItem(mListViewAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e(TAG, ((CategoryListViewItem)mListViewAdapter.getItem(position)).userName);
            }
        });

        mTvCategory.setText(strCategory);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
    }
}
