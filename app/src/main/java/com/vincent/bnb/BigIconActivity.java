package com.vincent.bnb;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.vincent.bottomnavigationbar.BottomItem;
import com.vincent.bottomnavigationbar.BottomNavigationBar;

import java.util.ArrayList;
import java.util.List;

public class BigIconActivity extends AppCompatActivity {
    private String mPackageName;

    private TextView mTvBnbBigMode;
    private List<BottomItem> mBnbBigModeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mPackageName = getApplicationInfo().packageName;

        initBnbBigMode();
    }

    private void initBnbBigMode() {
        mBnbBigModeList = new ArrayList<>();
        mTvBnbBigMode = (TextView) findViewById(R.id.tv_bnb_big);
        BottomNavigationBar mBnbBig = (BottomNavigationBar) findViewById(R.id.bnb_big);
        mBnbBig.setOnSelectedListener(new BottomNavigationBar.OnSelectedListener() {
            @Override
            public void OnSelected(int oldPosition, int newPosition) {
                mTvBnbBigMode.setText("Big Tint Mode : " + mBnbBigModeList.get(newPosition).getText());
            }
        });

        BottomItem item1 = new BottomItem();
        item1.setText("Bag");
        item1.setIconResID(getResources().getIdentifier("ic_tint_bag", "drawable", mPackageName));
//        item1.setActiveBgResID(R.drawable.bg_bottom_navi_selected);
//        item1.setInactiveBgResID(R.drawable.bg_bottom_navi_normal);
        mBnbBig.addItem(item1);
        mBnbBigModeList.add(item1);

        BottomItem item2 = new BottomItem();
        item2.setText("Book");
        item2.setIconResID(getResources().getIdentifier("ic_tint_book", "drawable", mPackageName));
//        item2.setActiveBgResID(R.drawable.bg_bottom_navi_selected);
//        item2.setInactiveBgResID(R.drawable.bg_bottom_navi_normal);
        mBnbBig.addItem(item2);
        mBnbBigModeList.add(item2);

        BottomItem item3 = new BottomItem();
        item3.setText("Home");
        item3.setIconResID(getResources().getIdentifier("ic_big_home", "drawable", mPackageName));
//        item3.setActiveBgResID(R.drawable.bg_bottom_navi_selected);
//        item3.setInactiveBgResID(R.drawable.bg_bottom_navi_normal);
        mBnbBig.addItem(item3);
        mBnbBigModeList.add(item3);

        BottomItem item4 = new BottomItem();
        item4.setText("List");
        item4.setIconResID(getResources().getIdentifier("ic_tint_list", "drawable", mPackageName));
//        item4.setActiveBgResID(R.drawable.bg_bottom_navi_selected);
//        item4.setInactiveBgResID(R.drawable.bg_bottom_navi_normal);
        mBnbBig.addItem(item4);
        mBnbBigModeList.add(item4);

        BottomItem item5 = new BottomItem();
        item5.setText("Rocket");
        item5.setIconResID(getResources().getIdentifier("ic_tint_rocket", "drawable", mPackageName));
//        item5.setActiveBgResID(R.drawable.bg_bottom_navi_selected);
//        item5.setInactiveBgResID(R.drawable.bg_bottom_navi_normal);
        mBnbBig.addItem(item5);
        mBnbBigModeList.add(item5);

        mBnbBig.setSelectedPosition(2); //Set default selected item
        mTvBnbBigMode.setText("Big Tint Mode : " + mBnbBigModeList.get(2).getText());
        mBnbBig.initialize();

        mBnbBig.setBadgeNumber(0, 68);
        mBnbBig.setBadgeNumber(1, -1);
        mBnbBig.setBadgeNumber(2, 6);
        mBnbBig.setBadgeNumber(3, 0);
        mBnbBig.setBadgeNumber(4, 10);
    }
}
