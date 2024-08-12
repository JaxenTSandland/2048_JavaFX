/**
 * @author jsandland
 * @createdOn 5/24/2024 at 8:50 PM
 * @projectName JaxenS_2048
 * @packageName jaxensandland.model;
 */
package personal.sandland.jaxen.jaxens_2048javafx.model;

import java.util.Random;

public class Grid {
    private int[][] grid;

    public Grid(int size) {
        grid = new int[size][size];
        generateRandomTile(2);
    }

    public void generateRandomTile() {
        generateRandomTile(1);
    }

    public void generateRandomTile(int amount) {
        Random rand = new Random();
        for (int i = 0; i < amount; i++) {
            int xTile = -1;
            int yTile = -1;

            do {
                xTile = rand.nextInt(grid.length);
                yTile = rand.nextInt(grid.length);
            } while (grid[xTile][yTile] != 0); //Keep looking for a tile until an empty one is found

            boolean twoOrFour = rand.nextBoolean();
            grid[xTile][yTile] = twoOrFour ? 2 : 4;
        }
    }

    public int[][] getGrid() {
        return grid;
    }
}
