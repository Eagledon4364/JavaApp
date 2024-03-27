package com.cdvj.main.tile;

import com.cdvj.main.util.Units;
import com.cdvj.main.window.GamePanel;

import java.awt.*;

public class Player implements Units {
    int width = UNIT/2, height = UNIT/2;
    public int startX = GamePanel.playStartX, startY = GamePanel.playStartY;
    public int mapX = 0, mapY = 0;
    Color playerC = Color.RED;


    public Player() {

    }
    public void draw(Graphics2D g2) {
        g2.setColor(playerC);
        g2.fillRect(startX, startY, width, height);
    }

}
