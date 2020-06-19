package com.vincent.bnb;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.vincent.bottomnavigationbar.BottomItem;
import com.vincent.bottomnavigationbar.BottomNavigationBar;

import java.util.ArrayList;
import java.util.List;

public class MixActivity extends AppCompatActivity {
    private String mPackageName;

    private TextView mTvBnbMixMode;
    private List<BottomItem> mBnbMixModeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mix);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mPackageName = getApplicationInfo().packageName;

        initBnbMixMode();
    }

    private void initBnbMixMode() {
        mBnbMixModeList = new ArrayList<>();
        mTvBnbMixMode = (TextView) findViewById(R.id.tv_bnb_mix);
        BottomNavigationBar mBnbMix = (BottomNavigationBar) findViewById(R.id.bnb_mix);
        mBnbMix.setOnSelectedListener(new BottomNavigationBar.OnSelectedListener() {
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
