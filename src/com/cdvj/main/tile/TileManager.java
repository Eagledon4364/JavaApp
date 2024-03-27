package com.cdvj.main.tile;

import com.cdvj.main.util.Units;
import com.cdvj.main.window.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager implements Units {
    GamePanel gp;
    public Tile[] tile;
    public int[][] mapTileNum;
    String path = "/level/lvl.txt";
    int mapCol = 32;
    int mapRow = 20;


    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];
        mapTileNum = new int[mapCol][mapRow];


        getTileImage();
        loadMap(path);
    }
    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/level/road.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/level/wall.png"));
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/level/point.png"));

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String path) {
        try {
            InputStream is = getClass().getResourceAsStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col = 0;
            int row = 0;
            while (col < mapCol && row < mapRow) {
                String line = br.readLine();
                while (col < mapCol) {
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == mapCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2) {
        for (int x = 0; x < mapTileNum.length; x++) {
            for (int y = 0; y < mapTileNum[x].length; y++) {
                int id = mapTileNum[x][y];
                g2.drawImage(tile[id].image,  playStartX + x * (UNIT/2), playStartY + y * (UNIT/2), UNIT/2, UNIT/2, null);
            }
        }
    }
    public Tile getsolidTile() {
        return tile[1];
    }
}
