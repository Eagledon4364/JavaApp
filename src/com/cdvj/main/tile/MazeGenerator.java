package com.cdvj.main.tile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MazeGenerator {
    int rows = 10;
    int cols = 16;
    int[][] maze = generateMaze(rows, cols);

//    writeMazeToFile(maze, "maze.txt");

    // Function to generate maze using depth-first search
    public static int[][] generateMaze(int rows, int cols) {
        int[][] maze = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(maze[i], 1); // Fill maze with walls (1s)
        }

        // Starting DFS from a random cell
        Random random = new Random();
        dfs(maze, random.nextInt(rows), random.nextInt(cols));

        // Opening entrance and exit
        maze[0][0] = 0; // Entrance
        maze[rows - 1][cols - 1] = 0; // Exit

        return maze;
    }

    // Helper function to perform depth-first search
    private static void dfs(int[][] maze, int row, int col) {
        maze[row][col] = 0; // Mark current cell as visited

        // Define the neighbors (up, down, left, right) in random order
        int[][] neighbors = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Collections.shuffle(Arrays.asList(neighbors));

        for (int[] neighbor : neighbors) {
            int newRow = row + neighbor[0] * 2; // Move two steps at a time
            int newCol = col + neighbor[1] * 2;

            // Check if the neighbor is within the maze bounds and not visited
            if (newRow >= 0 && newRow < maze.length && newCol >= 0 && newCol < maze[0].length && maze[newRow][newCol] == 1) {
                int wallRow = row + neighbor[0];
                int wallCol = col + neighbor[1];
                maze[wallRow][wallCol] = 0; // Remove wall between current cell and neighbor
                dfs(maze, newRow, newCol); // Recursive call for the neighbor cell
            }
        }
    }

    // Function to write the maze to a file
    public static void writeMazeToFile(int[][] maze, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (int[] row : maze) {
                for (int cell : row) {
                    writer.write(cell == 1 ? "1 " : "0 "); // Wall or empty space
                }
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
