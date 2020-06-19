package com.vincent.bnb;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.vincent.bottomnavigationbar.BottomItem;
import com.vincent.bottomnavigationbar.BottomNavigationBar;

import java.util.ArrayList;
import java.util.List;

public class TintActivity extends AppCompatActivity {
    private String mPackageName;

    private TextView mTvBnbDefault;
    private List<BottomItem> mBnbDefaultList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tint);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mPackageName = getApplicationInfo().packageName;

        initBnbDefault();
    }

    private void initBnbDefault() {
        mBnbDefaultList = new ArrayList<>();
        mTvBnbDefault = (TextView) findViewById(R.id.tv_bnb_default);
        final BottomNavigationBar mBnbDefault = (BottomNavigationBar) findViewById(R.id.bnb_default);
        mBnbDefault.setOnSelectedListener(new BottomNavigationBar.OnSelectedListener() {
            @Override
            public void OnSelected(int oldPosition, int newPosition) {
                mTvBnbDefault.setText("Default Tint Mode : " + mBnbDefaultList.get(newPosition).getText());
            }
        });

        BottomItem item1 = new BottomItem();
        item1.setText("Bag");
        item1.setIconResID(getResources().getIdentifier("ic_tint_bag", "drawable", mPackageName));
        item1.setActiveBgResID(R.drawable.bg_bottom_navi_selected);
        item1.setInactiveBgResID(R.drawable.bg_bottom_navi_normal);
        mBnbDefault.addItem(item1);
        mBnbDefaultList.add(item1);

        BottomItem item2 = new BottomItem();
        item2.setText("Book");
        item2.setIconResID(getResources().getIdentifier("ic_tint_book", "drawable", mPackageName));
        item2.setActiveBgResID(R.drawable.bg_bottom_navi_selected);
        item2.setInactiveBgResID(R.drawable.bg_bottom_navi_normal);
        mBnbDefault.addItem(item2);
        mBnbDefaultList.add(item2);

        BottomItem item3 = new BottomItem();
        item3.setText("Cart");
        item3.setIconResID(getResources().getIdentifier("ic_tint_cart", "drawable", mPackageName));
        item3.setActiveBgResID(R.drawable.bg_bottom_navi_selected);
        item3.setInactiveBgResID(R.drawable.bg_bottom_navi_normal);
        mBnbDefault.addItem(item3);
        mBnbDefaultList.add(item3);

        BottomItem item4 = new BottomItem();
        item4.setText("List");
        item4.setIconResID(getResources().getIdentifier("ic_tint_list", "drawable", mPackageName));
        item4.setActiveBgResID(R.drawable.bg_bottom_navi_selected);
        item4.setInactiveBgResID(R.drawable.bg_bottom_navi_normal);
        mBnbDefault.addItem(item4);
        mBnbDefaultList.add(item4);

        BottomItem item5 = new BottomItem();
        item5.setText("Rocket");
        item5.setIconResID(getResources().getIdentifier("ic_tint_rocket", "drawable", mPackageName));
        item5.setActiveBgResID(R.drawable.bg_bottom_navi_selected);
        item5.setInactiveBgResID(R.drawable.bg_bottom_navi_normal);
        mBnbDefault.addItem(item5);
        mBnbDefaultList.add(item5);

        mBnbDefault.setSelectedPosition(2); //Set default selected item
        mTvBnbDefault.setText("Default Tint Mode : " + mBnbDefaultList.get(2).getText());
        mBnbDefault.initialize();

        mBnbDefault.setBadgeNumber(0, 68);
        mBnbDefault.setBadgeNumber(1, -1);
        mBnbDefault.setBadgeNumber(2, 6);
        mBnbDefault.setBadgeNumber(3, 0);
        mBnbDefault.setBadgeNumber(4, 10);
    }
}
