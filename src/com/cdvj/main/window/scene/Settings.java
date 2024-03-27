package com.cdvj.main.window.scene;

import com.cdvj.main.ui.MyButton;
import com.cdvj.main.util.Units;
import com.cdvj.main.window.GameFrame;
import com.cdvj.main.window.GameScene;
import com.cdvj.main.window.SceneMethods;

import java.awt.*;

import static com.cdvj.main.window.GameState.MENU;
import static com.cdvj.main.window.GameState.setGameStates;

public class Settings extends GameScene implements Units, SceneMethods {
    public MyButton menuButton;
    public Settings(GameFrame game) {
        super(game);
        initButtons();
    }

    private void initButtons() {
        menuButton = new MyButton("Return", 24, SCREEN_HEIGHT - UNIT - 24, UNIT * 2, UNIT, Color.CYAN, Color.BLACK, Color.BLACK, Color.BLUE);
    }

    @Override
    public void render(Graphics g) {
        drawButtons(g);

    }
    private void drawButtons(Graphics g) {
        menuButton.draw(g);
    }

    @Override
    public void mouseClicked(int x, int y) {
        if (menuButton.getBounds().contains(x, y)) {
            setGameStates(MENU);
            game.gp.playSE(0);
        }
    }

    @Override
    public void mouseMoved(int x, int y) {
        menuButton.setMouseOver(false);
        if (menuButton.getBounds().contains(x, y)) {
            menuButton.setMouseOver(true);

        }
    }

    @Override
    public void mousePressed(int x, int y) {
        if (menuButton.getBounds().contains(x, y)) {
            menuButton.setMousePressed(true);

        }
    }

    @Override
    public void mouseReleased(int x, int y) {
        menuButton.resetBooleans();
    }

    @Override
    public void mouseDragged(int x, int y) {

    }
}
