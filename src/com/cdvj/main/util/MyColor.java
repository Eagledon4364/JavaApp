package com.cdvj.main.util;

import java.awt.*;

public class MyColor {
    int r, g, b;
    float alpha;
    public Color newColor(int r, int g, int b, float alpha) {
        return new Color(r, g, b, alpha);
    }

    public static final Color Tred = new Color(1, 0, 0, 0.5f);
    public static final Color Tgreen = new Color(0, 1, 0, 0.5f);
    public static final Color Tblue = new Color(0, 0, 1, 0.5f);
}
