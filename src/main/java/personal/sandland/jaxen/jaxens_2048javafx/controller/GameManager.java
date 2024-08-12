/**
 * @author jsandland
 * @createdOn 5/24/2024 at 10:15 PM
 * @projectName JaxenS_2048
 * @packageName jaxensandland.controller;
 */
package personal.sandland.jaxen.jaxens_2048javafx.controller;

import personal.sandland.jaxen.jaxens_2048javafx.model.Grid;
//import personal.sandland.jaxen.jaxens_2048javafx.view.ConsoleTools;
//import personal.sandland.jaxen.jaxens_2048javafx.view.Displayer;
//import personal.sandland.jaxen.jaxens_2048javafx.view.Input;

public class GameManager {

    private Grid grid;

    public void run() {

        grid = new Grid(4);
/*
        while(true) {
            Displayer.displayGrid(grid.getGrid());
            String input = Input.getWASDInput();
            move(input);
            if(gridFilled()) {
                Displayer.displayMessage("Game over!", ConsoleTools.TextColor.RED);
                break;
            }
            grid.generateRandomTile();
        }

 */



    }

    private void move(String input) {
        int row = 0;
        int col = 0;
        switch (input) {
            case "w": //Up
                row = 1;
                break;
            case "s": //Down
                row = grid.getGrid().length - 2;
                break;
            case "a": //Left
                col = 1;
                break;
            case "d": //Right
                col = grid.getGrid().length - 2;
                break;
        }

        int[][] gridArray = grid.getGrid();
        while (row < gridArray.length && row >= 0) {
            while (col < gridArray.length && col >= 0) {
                if(gridArray[row][col] != 0) {
                    moveTile(input, row, col, gridArray);
                }
                switch (input) {
                    case "w": //Up
                        col++;
                        break;
                    case "s": //Down
                        col++;
                        break;
                    case "a": //Left
                        col++;
                        break;
                    case "d": //Right
                        col--;
                        break;
                }
            }
            col = input.equals("d") ? grid.getGrid().length - 2 : 0;
            switch (input) {
                case "w": //Up
                    row++;
                    break;
                case "s": //Down
                    row--;
                    break;
                case "a": //Left
                    row++;
                    break;
                case "d": //Right
                    row++;
                    break;
            }
        }
    }

    private void moveTile(String direction, int row, int col, int[][] gridArray) {
        int checkingRow = -1;
        int checkingCol = -1;

        int currentRow = row;
        int currentCol = col;

        switch (direction) {
            case "w": //Up
                checkingRow = row - 1;
                checkingCol = col;
                break;
            case "s": //Down
                checkingRow = row + 1;
                checkingCol = col;
                break;
            case "a": //Left
                checkingRow = row;
                checkingCol = col - 1;
                break;
            case "d": //Right
                checkingRow = row;
                checkingCol = col + 1;
                break;
        }

        while (checkingRow >= 0 && checkingCol >= 0 && checkingRow < gridArray.length && checkingCol < gridArray.length) {
            if (gridArray[checkingRow][checkingCol] == 0) {
                gridArray[checkingRow][checkingCol] = gridArray[currentRow][currentCol];
                gridArray[currentRow][currentCol] = 0;
            } else if (gridArray[checkingRow][checkingCol] == gridArray[currentRow][currentCol]) {
                gridArray[checkingRow][checkingCol] *= 2;
                gridArray[currentRow][currentCol] = 0;
            } else {
                break;
            }
            currentRow = checkingRow;
            currentCol = checkingCol;
            switch (direction) {
                case "w": //Up
                    checkingRow = currentRow - 1;
                    break;
                case "s": //Down
                    checkingRow = currentRow + 1;
                    break;
                case "a": //Left
                    checkingCol = currentCol - 1;
                    break;
                case "d": //Right
                    checkingCol = currentCol + 1;
                    break;
            }
        }
    }

    private boolean gridFilled() {
        for (int row = 0; row < grid.getGrid().length; row++) {
            for (int col = 0; col < grid.getGrid().length; col++) {
                if(grid.getGrid()[row][col] == 0) return false;
            }
        }
        return true;
    }
}
