package com.cdvj.main.inputs;

import com.cdvj.main.window.GameFrame;
import com.cdvj.main.window.GameState;

import java.awt.event.*;

import static com.cdvj.main.util.Units.UNIT;

public class KeyBoardListener implements KeyListener {
    private GameFrame game;
    public boolean upPressed, downPressed, leftPressed, rightPressed;

    public KeyBoardListener(GameFrame game) {
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch (GameState.gameStates) {
            case MENU -> {
                int code = e.getKeyCode();
            }
            case SETTINGS -> {

            }
            case PLAYING -> {
                int code = e.getKeyCode();

                if (code == KeyEvent.VK_W) {
                    upPressed = true;
                    game.getPlaying().getPlayer().startY -= UNIT/2;
                    game.gp.repaint();
                    System.out.println("W");
                    game.getPlaying().getPlayer().mapY--;

                }
                if (code == KeyEvent.VK_S) {
                    downPressed = true;
                    game.getPlaying().getPlayer().startY += UNIT/2;
                    game.getPlaying().getPlayer().mapY++;
                }
                if (code == KeyEvent.VK_A) {
                    leftPressed = true;
                    game.getPlaying().getPlayer().startX -= UNIT/2;
                    game.getPlaying().getPlayer().mapX--;
                }
                if (code == KeyEvent.VK_D) {
                    rightPressed = true;
                    game.getPlaying().getPlayer().startX += UNIT/2;
                    game.getPlaying().getPlayer().mapX++;
                }
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (GameState.gameStates) {
            case MENU -> {
//                int code = e.getKeyCode();
            }
            case SETTINGS -> {

            }
            case PLAYING -> {
                //CODE FOR MOVEMENT
                //TODO MOVE CODE INTO OTHER CLASSES
                int code = e.getKeyCode();

                if (code == KeyEvent.VK_W) {
                    upPressed = true;
                    game.getPlaying().getPlayer().startY -= UNIT/2;
                    game.gp.repaint();

                }
                if (code == KeyEvent.VK_S) {
                    downPressed = true;
                    game.getPlaying().getPlayer().startY += UNIT/2;
                }
                if (code == KeyEvent.VK_A) {
                    leftPressed = true;
                    game.getPlaying().getPlayer().startX -= UNIT/2;
                }
                if (code == KeyEvent.VK_D) {
                    rightPressed = true;
                    game.getPlaying().getPlayer().startX += UNIT/2;
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (GameState.gameStates) {
            case MENU -> {

            }
            case SETTINGS -> {

            }
            case PLAYING -> {
                int code = e.getKeyCode();
                if (code == KeyEvent.VK_W) {
                    upPressed = false;
                }
                if (code == KeyEvent.VK_S) {
                    downPressed = false;
                }
                if (code == KeyEvent.VK_A) {
                    leftPressed = false;
                }
                if (code == KeyEvent.VK_D) {
                    rightPressed = false;
                }
            }
        }

    }
}
