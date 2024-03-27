package com.cdvj.main.window.scene;

import com.cdvj.main.ui.*;
import com.cdvj.main.util.Units;
import com.cdvj.main.window.*;

import javax.swing.*;
import java.awt.*;

import static com.cdvj.main.window.GameState.*;

public class Menu extends GameScene implements Units, SceneMethods {
    public MyButton playButton, settingsButton, exitButton;

    Image bgImg = new ImageIcon("res/screens/background.png").getImage();
    
    
    public Menu(GameFrame game) {
        super(game);
        initButtons();
    }

    private void initButtons() {
        playButton = new MyButton("Play", UNIT, SCREEN_HEIGHT - UNIT * 5, UNIT * 2, UNIT, Color.CYAN, Color.BLACK, Color.BLACK, Color.BLUE);
        settingsButton = new MyButton("Settings", UNIT, (int) (SCREEN_HEIGHT - UNIT * 3.5f), UNIT * 2, UNIT, Color.CYAN, Color.BLACK, Color.BLACK, Color.BLUE);
        exitButton = new MyButton("Exit", UNIT, SCREEN_HEIGHT - UNIT*2, UNIT * 2, UNIT, Color.CYAN, Color.BLACK, Color.BLACK, Color.BLUE);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(bgImg, 0, 0, null);
        drawButtons(g);

    }

    private void drawButtons(Graphics g) {
        playButton.draw(g);
        settingsButton.draw(g);
        exitButton.draw(g);

    }

    @Override
    public void mouseClicked(int x, int y) {
        if (playButton.getBounds().contains(x, y)) {
            setGameStates(PLAYING);
            game.gp.playSE(0);
        } else if (settingsButton.getBounds().contains(x, y)) {
            setGameStates(SETTINGS);
            game.gp.playSE(0);
        } else if (exitButton.getBounds().contains(x, y)) {
            System.exit(0);
        }

    }

    @Override
    public void mouseMoved(int x, int y) {
        playButton.setMouseOver(false);
        settingsButton.setMouseOver(false);
        exitButton.setMouseOver(false);
        if (playButton.getBounds().contains(x, y)) {
            playButton.setMouseOver(true);

        } else if (settingsButton.getBounds().contains(x, y)) {
            settingsButton.setMouseOver(true);
        } else if (exitButton.getBounds().contains(x, y)) {
            exitButton.setMouseOver(true);
        }

    }

    @Override
    public void mousePressed(int x, int y) {
        if (playButton.getBounds().contains(x, y)) {
            playButton.setMousePressed(true);

        } else if (settingsButton.getBounds().contains(x, y)) {
            settingsButton.setMousePressed(true);
        } else if (exitButton.getBounds().contains(x, y)) {
            exitButton.setMousePressed(true);
        }

    }

    @Override
    public void mouseReleased(int x, int y) {
        resetButtons();

    }

    private void resetButtons() {
        playButton.resetBooleans();
        settingsButton.resetBooleans();
        exitButton.resetBooleans();
    }
    @Override
    public void mouseDragged(int x, int y) {

    }
}
