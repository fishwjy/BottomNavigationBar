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

public class DrawableActivity extends AppCompatActivity {
    private String mPackageName;

    private TextView mTvBnbDrawableMode;
    private List<BottomItem> mBnbDrawableModeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mPackageName = getApplicationInfo().packageName;

        initBnbDrawableMode();
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
        mTvBnbDrawableMode.setText("Drawable Mode : " + mBnbDrawableModeList.get(2).getText());
        mBnbDrawable.initialize();

        mBnbDrawable.setBadgeText(0, "WOW");
        mBnbDrawable.setBadgeText(1, "");
        mBnbDrawable.setBadgeText(2, "赞");
        mBnbDrawable.setBadgeText(3, "");
        mBnbDrawable.setBadgeText(4, "紧急");
    }
}
