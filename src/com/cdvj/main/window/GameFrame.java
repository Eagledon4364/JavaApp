package com.cdvj.main.window;

import com.cdvj.main.inputs.KeyBoardListener;
import com.cdvj.main.tile.MazeGenerator;
import com.cdvj.main.util.Units;
import com.cdvj.main.window.scene.Menu;
import com.cdvj.main.window.scene.Playing;
import com.cdvj.main.window.scene.Settings;

import javax.swing.*;

import static com.cdvj.main.tile.MazeGenerator.generateMaze;

public class GameFrame extends JFrame implements Units {
    private Render render;
    private Menu menu;
    private Playing playing;
    private Settings settings;
    public KeyBoardListener kl;

    public GamePanel gp = new GamePanel(this);

    public GameFrame() {
        gp.initInputs();
        render = new Render(this);
        menu = new Menu(this);
        playing = new Playing(this);
        settings = new Settings(this);
        kl = new KeyBoardListener(this);
        addKeyListener(kl);



        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("App");
        add(gp);
        requestFocus();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public Render getRender() {
        return render;
    }
    public Menu getMenu() {
        return menu;
    }
    public Playing getPlaying() {
        return playing;
    }
    public Settings getSettings() {
        return settings;
    }

    public static void main(String[] args) {
        new GameFrame();
        int rows = 20;
        int cols = 32;
        int[][] maze = generateMaze(rows, cols);

        MazeGenerator.writeMazeToFile(maze, "maze.txt");

    }

}
