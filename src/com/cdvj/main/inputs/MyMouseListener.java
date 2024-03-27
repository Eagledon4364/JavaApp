package com.cdvj.main.inputs;

import com.cdvj.main.window.GameFrame;
import com.cdvj.main.window.GameState;

import java.awt.event.*;

public class MyMouseListener implements MouseListener, MouseMotionListener, MouseWheelListener {

    private GameFrame game;

    public MyMouseListener(GameFrame game) {
        this.game = game;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (GameState.gameStates) {
            case MENU -> {
                game.getMenu().mouseClicked(e.getX(), e.getY());
            }
            case PLAYING -> {
                game.getPlaying().mouseClicked(e.getX(), e.getY());
            }
            case SETTINGS -> {
                game.getSettings().mouseClicked(e.getX(), e.getY());
            }
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        switch (GameState.gameStates) {
            case MENU -> {
            game.getMenu().mousePressed(e.getX(), e.getY());
            }
            case PLAYING -> {
                game.getPlaying().mousePressed(e.getX(), e.getY());
            }
            case SETTINGS -> {
                game.getSettings().mousePressed(e.getX(), e.getY());
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch (GameState.gameStates) {
            case MENU -> {
                game.getMenu().mouseReleased(e.getX(), e.getY());
            }
            case PLAYING -> {
                game.getPlaying().mouseReleased(e.getX(), e.getY());
            }
            case SETTINGS -> {
                game.getSettings().mouseReleased(e.getX(), e.getY());
            }
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        switch (GameState.gameStates) {
            case MENU -> {
                game.getMenu().mouseDragged(e.getX(), e.getY());
            }
            case PLAYING -> {
                game.getPlaying().mouseDragged(e.getX(), e.getY());
            }
            case SETTINGS -> {
                game.getSettings().mouseDragged(e.getX(), e.getY());
            }
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        switch (GameState.gameStates) {
            case MENU -> {
                game.getMenu().mouseMoved(e.getX(), e.getY());
            }
            case PLAYING -> {
                game.getPlaying().mouseMoved(e.getX(), e.getY());
            }
            case SETTINGS -> {
                game.getSettings().mouseMoved(e.getX(), e.getY());
            }
        }

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

    }
}
