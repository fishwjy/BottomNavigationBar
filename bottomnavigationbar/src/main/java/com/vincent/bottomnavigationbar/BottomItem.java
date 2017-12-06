package com.vincent.bottomnavigationbar;

import android.graphics.drawable.Drawable;

/**
 * Created by Vincent Woo
 * Date: 2016/12/23
 * Time: 14:37
 */

public class BottomItem {
    private String text;
    private int activeTextColor;
    private int inactiveTextColor;
    private int textSize; //SP Unit

    public static int TINT_MODE = 0;
    public static int DRAWABLE_MODE = 1;
    private int mode = TINT_MODE; // 0: Tint Mode ; 1: Drawable Mode
    // Tint Mode
    private Drawable iconDrawable;
    private int iconResID;
    private int activeIconColor;
    private int inactiveIconColor;
    // Drawable Mode
    private Drawable activeIconDrawable;
    private int activeIconResID;
    private Drawable inactiveIconDrawable;
    private int inactiveIconResID;
    // Background
    private boolean pressEffect = true;
    private int activeBgResID = 0;
    private int inactiveBgResID = 0;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getActiveTextColor() {
        return activeTextColor;
    }

    public void setActiveTextColor(int activeTextColor) {
        this.activeTextColor = activeTextColor;
    }

    public int getInactiveTextColor() {
        return inactiveTextColor;
    }

    public void setInactiveTextColor(int inactiveTextColor) {
        this.inactiveTextColor = inactiveTextColor;
    }

    public int getTextSize() {
        return textSize;
    }

    public void setTextSize(int sp) {
        this.textSize = sp;
    }

    public int getActiveIconColor() {
        return activeIconColor;
    }

    public void setActiveIconColor(int activeIconColor) {
        this.activeIconColor = activeIconColor;
    }

    public int getInactiveIconColor() {
        return inactiveIconColor;
    }

    public void setInactiveIconColor(int inactiveIconColor) {
        this.inactiveIconColor = inactiveIconColor;
    }

    public Drawable getInactiveIconDrawable() {
        return inactiveIconDrawable;
    }

    public void setInactiveIconDrawable(Drawable inactiveIconDrawable) {
        this.inactiveIconDrawable = inactiveIconDrawable;
    }

    public int getInactiveIconResID() {
        return inactiveIconResID;
    }

    public void setInactiveIconResID(int inactiveIconResID) {
        this.inactiveIconResID = inactiveIconResID;
    }

    public Drawable getActiveIconDrawable() {
        return activeIconDrawable;
    }

    public void setActiveIconDrawable(Drawable activeIconDrawable) {
        this.activeIconDrawable = activeIconDrawable;
    }

    public int getActiveIconResID() {
        return activeIconResID;
    }

    public void setActiveIconResID(int activeIconResID) {
        this.activeIconResID = activeIconResID;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public Drawable getIconDrawable() {
        return iconDrawable;
    }

    public void setIconDrawable(Drawable iconDrawable) {
        this.iconDrawable = iconDrawable;
    }

    public int getIconResID() {
        return iconResID;
    }

    public void setIconResID(int iconResID) {
        this.iconResID = iconResID;
    }

    public int getActiveBgResID() {
        return activeBgResID;
    }

    public void setActiveBgResID(int activeBgResID) {
        this.activeBgResID = activeBgResID;
    }

    public int getInactiveBgResID() {
        return inactiveBgResID;
    }

    public void setInactiveBgResID(int inactiveBgResID) {
        this.inactiveBgResID = inactiveBgResID;
    }

    public boolean isPressEffect() {
        return pressEffect;
    }

    public void setPressEffect(boolean pressEffect) {
        this.pressEffect = pressEffect;
    }
}
