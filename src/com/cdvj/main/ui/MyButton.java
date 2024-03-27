package com.cdvj.main.ui;

import com.cdvj.main.util.Units;

import java.awt.*;

public class MyButton implements Units {
    private String text;
    public int x, y, width, height;
    public int id;
    private Rectangle bounds;
    public Color body;
    public Color border;
    public Color textC;
    public Color shade;
    private boolean mouseOver;
    private boolean mousePressed;

    public MyButton(String text, int x, int y, int width, int height, Color body, Color border, Color textC, Color shade) {
    this.text = text;
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.body = body;
    this.border = border;
    this.textC = textC;
    this.shade = shade;
    this.id = -1;

    initBounds();
    }
    public MyButton(String text, int x, int y, int width, int height, Color body, Color border, Color textC, Color shade, int id) {
    this.text = text;
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.body = body;
    this.border = border;
    this.textC = textC;
    this.shade = shade;
    this.id = id;

    initBounds();
    }
    private void initBounds() {
        this.bounds = new Rectangle(x, y, width, height);
    }


    public void draw(Graphics g) {
        // body
        drawBody(g);
        //border
        drawBorder(g);
        //text
        drawText(g);
    }

    private void drawBorder(Graphics g) {
        g.setColor(border);
        g.drawRect(x, y, width, height);
        if (mousePressed) {
            g.drawRect(x + 1, y +1, width - 2, height - 2);
            g.drawRect(x + 2, y +2, width - 4, height - 4);
        }

    }

    private void drawBody(Graphics g) {
        if (mouseOver) {
            g.setColor(shade);
        }
        else {
            g.setColor(body);
        }
        g.fillRect(x, y, width, height);
    }
    public void resetBooleans() {
        this.setMouseOver(false);
        this.setMousePressed(false);
    }
    public void setMousePressed(boolean mousePressed) {
        this.mousePressed = mousePressed;
    }
    public void setMouseOver(boolean mouseOver) {
        this.mouseOver = mouseOver;

    }

    private void drawText(Graphics g) {
        g.setColor(textC);
        int w = g.getFontMetrics().stringWidth(text);
        int h = g.getFontMetrics().getHeight();

        g.drawString(text, x - w /2 + width / 2, y + h / 2 + height/2);

    }

    public Rectangle getBounds() {
        return bounds;
    }

    public int getId() {
        return id;
    }
    public boolean isMouseOver() {
        return mouseOver;
    }
    public boolean isMousePressed() {
        return mousePressed;
    }

}
