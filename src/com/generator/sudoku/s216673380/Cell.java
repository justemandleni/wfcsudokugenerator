package com.generator.sudoku.s216673380;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

public class Cell {
    public boolean isFinal;
    public int state;
    public int[] possibleStates;

    public final int cellX;
    public final int cellY;
    public final Grid grid;
    public final ArrayList<Integer> states;

    public Cell(int mCellX, int mCellY, Grid mGrid, ArrayList<Integer> mStates){
        cellX = mCellX;
        cellY = mCellY;
        grid = mGrid;
        states = mStates;
    }

    public void populate(){
        List<Integer> currentStates = new Vector<>();
        currentStates.addAll(states);
        for (int x = 0; x < grid.size; x++) {
            for (int y = 0; y < grid.size; y++) {
                if (cellX == x ||
                        cellY == y ||
                        Math.floor(x / 3f) == Math.floor(cellX / 3f) && Math.floor(y / 3f) == Math.floor(cellY / 3f)) {
                    if (grid.getCell(x, y).isFinal) {
                        Cell cell = grid.getCell(x,y);
                        currentStates.remove(cell);
                        //currentStates.remove(grid.getCell(x, y).state);
                        break;
                    }
                }
            }
        }
        possibleStates = currentStates.stream().distinct().mapToInt(i->i).toArray();
    }

    public void setRandomPossibleState() {
        if (!isFinal && possibleStates.length > 0)
        {
            //Random random = new Random();
            //state = possibleStates[random.Next(0, possibleStates.Length)];
            //state = possibleStates[ThreadLocalRandom.current().nextInt(0, possibleStates.length)];
            state = possibleStates[ThreadLocalRandom.current().nextInt(0, 9)];
            isFinal = true;
        }
    }

    public String toString(){
        return isFinal ? Integer.toString(state)+" " : "# ";
    }
}
