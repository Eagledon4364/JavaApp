package com.cdvj.main.window.scene;

import com.cdvj.main.tile.Player;
import com.cdvj.main.tile.TileManager;
import com.cdvj.main.ui.MyButton;
import com.cdvj.main.util.*;
import com.cdvj.main.window.*;

import javax.swing.*;
import java.awt.*;

import static com.cdvj.main.window.GameState.*;

public class Playing extends GameScene implements Units, SceneMethods {
    public MyButton menuButton;
    Image bgImg = new ImageIcon("res/screens/playing.png").getImage();
    TileManager tm;
    Player player;


    public Playing(GameFrame game) {
        super(game);
        initButtons();
//        game.gp.playMusic(1);
        tm = new TileManager(game.gp);
        player = new Player();


    }

    private void initButtons() {
        menuButton = new MyButton("Return", 24, SCREEN_HEIGHT - UNIT - 24, UNIT * 2, UNIT, Color.CYAN, Color.BLACK, Color.BLACK, Color.BLUE);
    }

    @Override
    public void render(Graphics g) {
        //TODO CREATE UPDATE METHOD SO MOVEMENT CODE CAN BE SET ASIDE FROM RENDERING CODE

        //MOVEMENT CODE
        if (player.startX < playStartX) {
            player.startX = playStartX;
            player.mapX = 0;
        } else if (player.startX > playWidth + playStartX - UNIT/2) {
            player.startX = playWidth + playStartX - UNIT/2;
            player.mapX = 31;
        } else if (player.startY < playStartY) {
            player.startY = playStartY;
            player.mapY = 0;
        } else if (player.startY > playHeight + playStartY - UNIT/2) {
            player.startY = playHeight + playStartY - UNIT / 2;
            player.mapY = 19;
        }
        //RENDERING CODE
        g.drawImage(bgImg, 0, 0, null);
        drawButtons(g);
        Graphics2D g2 = (Graphics2D) g;

        tm.draw(g2);
        drawGameBorder(g2);
        player.draw(g2);
    }

    private void drawGameBorder(Graphics2D g2) {
        //DRAWS GRID
        for (int x = 0; x < playWidth/UNIT*2; x++) {
            for (int y = 0; y < playHeight/UNIT*2; y++) {
                g2.setColor(Color.BLACK);
                g2.drawRect(playStartX + (x * UNIT/2), playStartY + (y * UNIT/2), UNIT/2, UNIT/2);
            }
        }
        //DRAWS BORDER
        g2.setColor(Color.DARK_GRAY);
        g2.drawRect(playStartX, playStartY, playWidth, playHeight);
        g2.drawRect(UNIT * 8 - 1, UNIT * 2 - 1, UNIT * 16 + 2, UNIT * 10 + 2);
        g2.drawRect(UNIT * 8 + 1, UNIT * 2 + 1, UNIT * 16 - 2, UNIT * 10 - 2);
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

    public Player getPlayer() {
        return player;
    }
}
