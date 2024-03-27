package com.cdvj.main.window;

import com.cdvj.main.audio.SoundLoader;
import com.cdvj.main.inputs.MyMouseListener;
import com.cdvj.main.util.Units;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable, Units {
    private GameFrame frame;
    Thread gameThread;
//    Cursor myCursor = Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("res/cursor/cursor.png").getImage(),new Point(0, 0) , "myCursor");


    MyMouseListener myMouseListener;
    SoundLoader soundLoader = new SoundLoader();


    public GamePanel(GameFrame frame) {
        this.frame = frame;
//        setCursor(myCursor);
        requestFocus();
        setPreferredSize(SCREEN_DIM);
        gameThread = new Thread(this);
        gameThread.start();

        setVisible(true);
    }

    public void initInputs() {
        myMouseListener = new MyMouseListener(frame);
        addMouseListener(myMouseListener);
        addMouseMotionListener(myMouseListener);
        addMouseWheelListener(myMouseListener);
        this.requestFocus();
    }

    @Override
    public void run() {
        // game loop
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while (true) {
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;
            if (delta >= 1) {
                updateGame();
                repaint();
                delta--;
            }
        }

    }
    public void playMusic(int i) {
        soundLoader.setFile(i);
        soundLoader.play();
        soundLoader.loop();

    }
    public void stopMusic() {
        soundLoader.stop();
    }
    public void playSE(int i) {
        soundLoader.setFile(i);
        soundLoader.play();
    }

    private void updateGame() {
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        frame.getRender().render(g);

    }
}
