package com.cdvj.main.window;

public enum GameState {
    MENU, PLAYING, SETTINGS;

    public static GameState gameStates = MENU;
    public static void setGameStates(GameState states) {
        gameStates = states;
    }

}
