package com.cdvj.main.util;

import java.awt.*;

public interface Units {
    int UNIT = 48;
    int SCREEN_WIDTH = UNIT * 26;
    int SCREEN_HEIGHT = UNIT * 14;
    Dimension SCREEN_DIM = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
    Dimension FULL_SCREEN_DIM = Toolkit.getDefaultToolkit().getScreenSize();
    int playStartX = UNIT * 8;
    int playStartY = UNIT * 2;
    int playWidth = UNIT * 16;
    int playHeight = UNIT * 10;
}
