package com.generator.sudoku.s216673380;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {

        int[] number2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        SudokuGrid sudokuGrid = new SudokuGrid(9, number2);
        int counter = 0;

        while (counter < 81){
            Thread.sleep(500);
            sudokuGrid.solveSingleRandomCell();
            System.out.println(sudokuGrid);

            System.in.read();
            counter++;

        }
    }
}
