package com.generator.sudoku.s216673380;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);

        Grid grid = new Grid(9, numbers);
        //grid.solveRandomCells(9);
        while (true){
            //Thread.sleep(500);
            grid.solveSingleRandomCell();
            System.out.println(grid);

            System.in.read();
        }
    }
}
