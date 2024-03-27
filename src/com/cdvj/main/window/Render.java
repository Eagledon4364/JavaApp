package com.cdvj.main.window;


import com.cdvj.main.util.Units;

import java.awt.*;

public class Render implements Units {
    private GameFrame game;

    public Render(GameFrame game) {
        this.game = game;

    }

    public void render(Graphics g) {
        switch (GameState.gameStates) {
            case MENU -> {
                game.getMenu().render(g);
            }
            case PLAYING -> {
                game.getPlaying().render(g);
            }
            case SETTINGS -> {
                game.getSettings().render(g);
            }

        }
    }
}
