package com.vincent.bnb;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.vincent.bottomnavigationbar.BottomItem;
import com.vincent.bottomnavigationbar.BottomNavigationBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String mPackageName;

    private TextView mTvBnbDefault;
    private List<BottomItem> mBnbDefaultList;

    private TextView mTvBnbDrawableMode;
    private List<BottomItem> mBnbDrawableModeList;

    private TextView mTvBnbMixMode;
    private List<BottomItem> mBnbMixModeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mPackageName = getApplicationInfo().packageName;

        initBnbDefault();
        initBnbDrawableMode();
        initBnbMixMode();
    }

    private void initBnbDefault() {
        mBnbDefaultList = new ArrayList<>();
        mTvBnbDefault = (TextView) findViewById(R.id.tv_bnb_default);
        BottomNavigationBar mBnbDefault = (BottomNavigationBar) findViewById(R.id.bnb_default);
        mBnbDefault.addOnSelectedListener(new BottomNavigationBar.OnSelectedListener() {
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

    private void initBnbDrawableMode() {
        mBnbDrawableModeList = new ArrayList<>();
        mTvBnbDrawableMode = (TextView) findViewById(R.id.tv_bnb_drawable);
        BottomNavigationBar mBnbDrawable = (BottomNavigationBar) findViewById(R.id.bnb_drawable);
        mBnbDrawable.addOnSelectedListener(new BottomNavigationBar.OnSelectedListener() {
            @Override
            public void OnSelected(int oldPosition, int newPosition) {
                mTvBnbDrawableMode.setText("Drawable Mode : " + mBnbDrawableModeList.get(newPosition).getText());
            }
        });

        BottomItem item1 = new BottomItem();
        item1.setMode(BottomItem.DRAWABLE_MODE);
        item1.setText("Camera");
        item1.setActiveIconResID(getResources().getIdentifier("ic_drawable_camera_fill", "drawable",
                getApplicationInfo().packageName));
        item1.setInactiveIconResID(getResources().getIdentifier("ic_drawable_camera", "drawable",
                getApplicationInfo().packageName));
        item1.setActiveTextColor(Color.parseColor("#E64B4E"));
        mBnbDrawable.addItem(item1);
        mBnbDrawableModeList.add(item1);

        BottomItem item2 = new BottomItem();
        item2.setMode(BottomItem.DRAWABLE_MODE);
        item2.setText("Friend");
        item2.setActiveIconResID(getResources().getIdentifier("ic_drawable_friend_add_fill", "drawable",
                getApplicationInfo().packageName));
        item2.setInactiveIconResID(getResources().getIdentifier("ic_drawable_friend_add", "drawable",
                getApplicationInfo().packageName));
        item2.setActiveTextColor(Color.parseColor("#E64B4E"));
        mBnbDrawable.addItem(item2);
        mBnbDrawableModeList.add(item2);

        BottomItem item3 = new BottomItem();
        item3.setMode(BottomItem.DRAWABLE_MODE);
        item3.setText("Like");
        item3.setActiveIconResID(getResources().getIdentifier("ic_drawable_like_fill", "drawable",
                getApplicationInfo().packageName));
        item3.setInactiveIconResID(getResources().getIdentifier("ic_drawable_like", "drawable",
                getApplicationInfo().packageName));
        item3.setActiveTextColor(Color.parseColor("#E64B4E"));
        mBnbDrawable.addItem(item3);
        mBnbDrawableModeList.add(item3);

        BottomItem item4 = new BottomItem();
        item4.setMode(BottomItem.DRAWABLE_MODE);
        item4.setText("Recharge");
        item4.setActiveIconResID(getResources().getIdentifier("ic_drawable_recharge_fill", "drawable",
                getApplicationInfo().packageName));
        item4.setInactiveIconResID(getResources().getIdentifier("ic_drawable_recharge", "drawable",
                getApplicationInfo().packageName));
        item4.setActiveTextColor(Color.parseColor("#E64B4E"));
        mBnbDrawable.addItem(item4);
        mBnbDrawableModeList.add(item4);

        BottomItem item5 = new BottomItem();
        item5.setMode(BottomItem.DRAWABLE_MODE);
        item5.setText("Time");
        item5.setActiveIconResID(getResources().getIdentifier("ic_drawable_time_fill", "drawable",
                getApplicationInfo().packageName));
        item5.setInactiveIconResID(getResources().getIdentifier("ic_drawable_time", "drawable",
                getApplicationInfo().packageName));
        item5.setActiveTextColor(Color.parseColor("#E64B4E"));
        mBnbDrawable.addItem(item5);
        mBnbDrawableModeList.add(item5);

        mBnbDrawable.setSelectedPosition(2); //Set default selected item
        mTvBnbDrawableMode.setText("Drawable Mode : " + mBnbDefaultList.get(2).getText());
        mBnbDrawable.initialize();

        mBnbDrawable.setBadgeText(0, "WOW");
        mBnbDrawable.setBadgeText(1, "");
        mBnbDrawable.setBadgeText(2, "赞");
        mBnbDrawable.setBadgeText(3, "");
        mBnbDrawable.setBadgeText(4, "紧急");
    }

    private void initBnbMixMode() {
        mBnbMixModeList = new ArrayList<>();
        mTvBnbMixMode = (TextView) findViewById(R.id.tv_bnb_mix);
        BottomNavigationBar mBnbMix = (BottomNavigationBar) findViewById(R.id.bnb_mix);
        mBnbMix.addOnSelectedListener(new BottomNavigationBar.OnSelectedListener() {
            @Override
            public void OnSelected(int oldPosition, int newPosition) {
                mTvBnbMixMode.setText("Mix : " + mBnbMixModeList.get(newPosition).getText());
            }
        });

        BottomItem item1 = new BottomItem();
        item1.setText("Bag");
        item1.setIconResID(getResources().getIdentifier("ic_tint_bag", "drawable", mPackageName));
        item1.setActiveIconColor(Color.parseColor("#E55D87"));
        item1.setInactiveIconColor(Color.parseColor("#5FC3E4"));
        item1.setActiveTextColor(Color.parseColor("#43CEA2"));
        item1.setInactiveTextColor(Color.parseColor("#D38312"));
        mBnbMix.addItem(item1);
        mBnbMixModeList.add(item1);

        BottomItem item2 = new BottomItem();
        item2.setMode(BottomItem.DRAWABLE_MODE);
        item2.setText("Friend");
        item2.setActiveIconResID(getResources().getIdentifier("ic_drawable_friend_add_fill", "drawable",
                getApplicationInfo().packageName));
        item2.setInactiveIconResID(getResources().getIdentifier("ic_drawable_friend_add", "drawable",
                getApplicationInfo().packageName));
        item2.setActiveTextColor(Color.parseColor("#E64B4E"));
        mBnbMix.addItem(item2);
        mBnbMixModeList.add(item2);

        BottomItem item3 = new BottomItem();
        item3.setText("Cart");
        item3.setIconResID(getResources().getIdentifier("ic_tint_cart", "drawable", mPackageName));
        item3.setActiveIconColor(Color.parseColor("#E55D87"));
        item3.setInactiveIconColor(Color.parseColor("#5FC3E4"));
        item3.setActiveTextColor(Color.parseColor("#43CEA2"));
        item3.setInactiveTextColor(Color.parseColor("#D38312"));
        mBnbMix.addItem(item3);
        mBnbMixModeList.add(item3);

        BottomItem item4 = new BottomItem();
        item4.setMode(BottomItem.DRAWABLE_MODE);
        item4.setText("Recharge");
        item4.setActiveIconResID(getResources().getIdentifier("ic_drawable_recharge_fill", "drawable",
                getApplicationInfo().packageName));
        item4.setInactiveIconResID(getResources().getIdentifier("ic_drawable_recharge", "drawable",
                getApplicationInfo().packageName));
        item4.setActiveTextColor(Color.parseColor("#E64B4E"));
        mBnbMix.addItem(item4);
        mBnbMixModeList.add(item4);

        BottomItem item5 = new BottomItem();
        item5.setText("Rocket");
        item5.setIconResID(getResources().getIdentifier("ic_tint_rocket", "drawable", mPackageName));
        item5.setActiveIconColor(Color.parseColor("#E55D87"));
        item5.setInactiveIconColor(Color.parseColor("#5FC3E4"));
        item5.setActiveTextColor(Color.parseColor("#43CEA2"));
        item5.setInactiveTextColor(Color.parseColor("#D38312"));
        mBnbMix.addItem(item5);
        mBnbMixModeList.add(item5);

        mBnbMix.setSelectedPosition(2); //Set default selected item
        mTvBnbMixMode.setText("Mix : " + mBnbMixModeList.get(2).getText());
        mBnbMix.initialize();
    }
}
