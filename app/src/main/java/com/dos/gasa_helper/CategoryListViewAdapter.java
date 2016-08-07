package com.dos.gasa_helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * CategoryActivity 의 ListView 에 적용하는 Adapter
 * Created by Hago on 2016-08-07.
 */
public class CategoryListViewAdapter extends BaseAdapter {
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<CategoryListViewItem> mList = new ArrayList<CategoryListViewItem>();

    public CategoryListViewAdapter() {

    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row_category_item, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        ImageView ivUserImage = (ImageView) convertView.findViewById(R.id.ivUserImage);
        TextView tvUserName = (TextView) convertView.findViewById(R.id.tvUserName);
        TextView tvSummary = (TextView) convertView.findViewById(R.id.tvSummary);
        TextView tvLocation = (TextView) convertView.findViewById(R.id.tvLocation);
        TextView tvPay = (TextView) convertView.findViewById(R.id.tvPay);

        // Data Set(mList)에서 position에 위치한 데이터 참조 획득
        CategoryListViewItem item = mList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        ivUserImage.setImageResource(item.userImageId);
        tvUserName.setText(item.userName);
        tvSummary.setText(item.summary);
        tvLocation.setText(item.location);
        tvPay.setText(item.pay);

        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    // 아이템 데이터 추가를 위한 함수
    public void addItem(int userImageId, String userName, String summary, String location, String pay) {
        CategoryListViewItem item = new CategoryListViewItem();

        item.userImageId = userImageId;
        item.userName = userName;
        item.summary = summary;
        item.location = location;
        item.pay = pay;

        mList.add(item);
    }
}
