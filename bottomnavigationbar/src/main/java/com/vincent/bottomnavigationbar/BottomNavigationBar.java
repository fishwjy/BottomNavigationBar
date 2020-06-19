package com.vincent.bottomnavigationbar;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.vincent.bottomnavigationbar.badge.Badge;
import com.vincent.bottomnavigationbar.badge.QBadgeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vincent Woo
 * Date: 2016/12/23
 * Time: 14:29
 */

public class BottomNavigationBar extends RelativeLayout implements View.OnClickListener {
    private ArrayList<BottomItem> mBottomItems = new ArrayList<>();
    private int mSelectedPosition;
    private ArrayList<OnSelectedListener> mList;
    private List<Badge> mBadges = new ArrayList<>();

    private LinearLayout ll_container;

    private static final int DEFAULT_CONTAINER_HEIGHT = 50;
    private float containerHeight = DEFAULT_CONTAINER_HEIGHT;

    private static final int DEFAULT_BIG_HEIGHT = 80;
    private float bigHeight = DEFAULT_BIG_HEIGHT;

    private static final int DEFAULT_BIG_INDEX = -1;
    private int bigIndex = DEFAULT_BIG_INDEX;

    public BottomNavigationBar(Context context) {
        this(context, null);
    }

    public BottomNavigationBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BottomNavigationBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        parseAttrs(context, attrs);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public BottomNavigationBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        parseAttrs(context, attrs);
        init();
    }

    @SuppressLint("CustomViewStyleable")
    private void parseAttrs(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.vwBottomNavigationBar, 0, 0);
            containerHeight = typedArray.getDimension(R.styleable.vwBottomNavigationBar_vwContainerHeight, DEFAULT_CONTAINER_HEIGHT);
            bigHeight = typedArray.getDimension(R.styleable.vwBottomNavigationBar_vwBigHeight, DEFAULT_BIG_HEIGHT);
            bigIndex = typedArray.getInt(R.styleable.vwBottomNavigationBar_vwBigIndex, DEFAULT_BIG_INDEX);
            typedArray.recycle();
        }
    }

    private void init() {
        setClipChildren(false);
        ll_container = new LinearLayout(getContext());
        ll_container.setOrientation(LinearLayout.HORIZONTAL);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) containerHeight);
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        addView(ll_container, params);
        mList = new ArrayList<>();
    }

    public BottomNavigationBar addItem(BottomItem item) {
        mBottomItems.add(item);
        return this;
    }

    public BottomNavigationBar remove(int index) {
        this.removeViewAt(index);
        mBottomItems.remove(index);
        return this;
    }

    public void removeAllItems() {
        this.removeAllViews();
        mBottomItems.clear();
    }

    public void initialize() {
        if (mSelectedPosition > mBottomItems.size() - 1) {
            throw new IllegalArgumentException("Bottom Item Index overflow !!!");
        }

        LayoutInflater inflater = LayoutInflater.from(getContext());
        for (int i = 0; i < mBottomItems.size(); i++) {
            BottomItem item = mBottomItems.get(i);

            View btn = inflater.inflate(R.layout.vw_layout_bottom_item, null);
            btn.setClickable(true);
            btn.setTag(i);
            btn.setOnClickListener(this);

            decorateBackground(btn, item);

            ImageView ic_bottom = (ImageView) btn.findViewById(R.id.ic_bottom);
            decorateImageView(ic_bottom, item);

            TextView tv_bottom = (TextView) btn.findViewById(R.id.tv_bottom);
            if (!TextUtils.isEmpty(item.getText())) {
                decorateTextView(tv_bottom, item);
            } else {
                tv_bottom.setVisibility(GONE);
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) ic_bottom.getLayoutParams();
                params.gravity = Gravity.CENTER;
            }

            LinearLayout.LayoutParams params;
            if (i == bigIndex) {
                params = new LinearLayout.LayoutParams(0, (int) bigHeight, 1);
            } else {
                params = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1);
            }
            params.gravity = Gravity.BOTTOM;

            ll_container.addView(btn, params);

            mBadges.add(new QBadgeView(this.getContext()).bindTarget(btn).setShowShadow(false));
        }

        ll_container.getChildAt(mSelectedPosition).setSelected(true);
    }

    @Override
    public void onClick(View view) {
        int index = (int) view.getTag();
        if (mSelectedPosition != index) {
            selectItem(index);
        }
    }

    private void selectItem(int index) {
        ll_container.getChildAt(mSelectedPosition).setSelected(false);
        ll_container.getChildAt(index).setSelected(true);

        for (OnSelectedListener listener : mList) {
            listener.OnSelected(mSelectedPosition, index);
        }

        mSelectedPosition = index;
    }

    private void decorateBackground(View v, BottomItem item) {
        if (item.getActiveBgResID() == 0 || item.getInactiveBgResID() == 0) {
            return;
        }

        StateListDrawable stateListDrawable = new StateListDrawable();

        stateListDrawable.addState(new int[]{-android.R.attr.state_window_focused},
                ContextCompat.getDrawable(getContext(), item.getInactiveBgResID()));

        stateListDrawable.addState(new int[]{android.R.attr.state_selected},
                ContextCompat.getDrawable(getContext(), item.getActiveBgResID()));

        if (item.isPressEffect()) {
            stateListDrawable.addState(new int[]{android.R.attr.state_pressed},
                    ContextCompat.getDrawable(getContext(), item.getActiveBgResID()));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            v.setBackground(stateListDrawable);
        } else {
            v.setBackgroundDrawable(stateListDrawable);
        }
    }

    private void decorateTextView(TextView tv, BottomItem item) {
        tv.setText(item.getText());

        /**
         * Sample:
         * Normal(-state_pressed, -state_selected) ---> Color.GRAY
         * state_pressed   ---> Color.BLACK
         * state_selected  ---> Color.GREEN
         * */
//        int[][] states = new int[][]{
//                new int[]{-android.R.attr.state_pressed, -android.R.attr.state_selected},
//                new int[]{android.R.attr.state_pressed},
//                new int[]{android.R.attr.state_selected}
//        };
//        int[] colors = new int[]{ Color.GRAY, Color.BLACK, Color.GREEN };

        int[][] states = new int[][]{
                new int[]{-android.R.attr.state_selected},
                new int[]{android.R.attr.state_selected}
        };
        int[] colors = new int[]{
                (item.getInactiveTextColor() == 0) ? ContextCompat.getColor(getContext(), R.color.vw_dark_grey) : item.getInactiveTextColor(),
                (item.getActiveTextColor() == 0) ? BnbUtil.fetchContextColor(getContext(), R.attr.colorPrimary) : item.getActiveTextColor()};

        ColorStateList colorStateList = new ColorStateList(states, colors);
        tv.setTextColor(colorStateList);

        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, (item.getTextSize() == 0) ? 12 : item.getTextSize());
    }

    private void decorateImageView(ImageView iv, BottomItem item) {
        if (item.getMode() == 0) {// Tint Mode
            Drawable drawable;
            if (item.getIconDrawable() != null) {
                drawable = item.getIconDrawable();
            } else if (item.getIconResID() != 0) {
                drawable = ContextCompat.getDrawable(getContext(), item.getIconResID());
            } else {
                return;
            }

            int[][] states = new int[][]{
                    new int[]{-android.R.attr.state_selected},
                    new int[]{android.R.attr.state_selected}
            };
            int[] colors = new int[]{
                    (item.getInactiveIconColor() == 0) ? ContextCompat.getColor(getContext(), R.color.vw_dark_grey) : item.getInactiveIconColor(),
                    (item.getActiveIconColor() == 0) ? BnbUtil.fetchContextColor(getContext(), R.attr.colorPrimary) : item.getActiveIconColor()};
            StateListDrawable stateListDrawable = getStateListDrawable(drawable, states);
            Drawable drawable1 = getStateDrawable(stateListDrawable, colors, states);
            iv.setImageDrawable(drawable1);
        } else { // Drawable Mode
            Drawable activeDrawable, inactiveDrawable;
            if (item.getActiveIconDrawable() != null) {
                activeDrawable = item.getActiveIconDrawable();
            } else if (item.getActiveIconResID() != 0) {
                activeDrawable = ContextCompat.getDrawable(getContext(), item.getActiveIconResID());
            } else {
                return;
            }

            if (item.getInactiveIconDrawable() != null) {
                inactiveDrawable = item.getInactiveIconDrawable();
            } else if (item.getActiveIconResID() != 0) {
                inactiveDrawable = ContextCompat.getDrawable(getContext(), item.getInactiveIconResID());
            } else {
                return;
            }

            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{-android.R.attr.state_selected}, inactiveDrawable);
            stateListDrawable.addState(new int[]{android.R.attr.state_selected}, activeDrawable);
            iv.setImageDrawable(stateListDrawable);
        }
    }

    private StateListDrawable getStateListDrawable(Drawable drawable, int[][] states) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        for (int[] state : states) {
            stateListDrawable.addState(state, drawable);
        }
        return stateListDrawable;
    }

    private Drawable getStateDrawable(Drawable drawable, int[] colors, int[][] states) {
        ColorStateList colorList = new ColorStateList(states, colors);

        Drawable.ConstantState state = drawable.getConstantState();
        drawable = DrawableCompat.wrap(state == null ? drawable : state.newDrawable()).mutate();
        DrawableCompat.setTintList(drawable, colorList);
        return drawable;
    }

    public void setSelectedPosition(int selectedPosition) {
        this.mSelectedPosition = selectedPosition;
    }

    public int getSelectedPosition() {
        return mSelectedPosition;
    }

    public void addOnSelectedListener(OnSelectedListener listener) {
        mList.add(listener);
    }

    public interface OnSelectedListener {
        public void OnSelected(int oldPosition, int newPosition);
    }

    public void setBadgeNumber(int index, int number) {
        if (number < 0) {
            mBadges.get(index)
                    .setBadgeNumber(number)
                    .setGravityOffset(17, 5, true)
                    .setBadgePadding(5, true);
        } else {
            mBadges.get(index)
                    .setBadgeNumber(number)
                    .setGravityOffset(12, 2, true)
                    .setBadgePadding(3, true);
        }
    }

    public void setBadgeText(int index, String text) {
        if (text.length() == 0) {
            mBadges.get(index)
                    .setBadgeText(text)
                    .setGravityOffset(17, 5, true)
                    .setBadgePadding(5, true);
        } else {
            mBadges.get(index)
                    .setBadgeText(text)
                    .setGravityOffset(8, 2, true)
                    .setBadgePadding(3, true);
        }
    }

    public Badge getBadge(int index) {
        return mBadges.get(index);
    }

    public List<Badge> getBadges() {
        return mBadges;
    }
}
