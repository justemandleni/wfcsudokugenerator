package com.generator.sudoku.s216673380;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class SudokuGenerator {
    public boolean isFact;
    public int state;
    public int[] possibleStates;

    public final int cellX;
    public final int cellY;
    public final SudokuGrid mSudokuGrid;
    public final int[] states;

    public SudokuGenerator(int mCellX, int mCellY, SudokuGrid mSudokuGrid, int[] mStates){
        cellX = mCellX;
        cellY = mCellY;
        this.mSudokuGrid = mSudokuGrid;
        states = mStates;
    }

    private List<Integer> cPutAll(int[] input) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            ret.add(i);
        }
        return ret;
    }

    private int[] bPutAll(List<Integer> input) {
        int[] ret = new int[input.size()];
        for (int i = 0; i < input.size(); i++) {
            ret[i] = input.get(i);
        }
        return ret;
    }

    public void populate() {
        //List<Integer> currentStates = cPutAll(states);
        List<Integer> currentStates = new ArrayList<>();
        currentStates = cPutAll(states);

        for (int x = 0; x < mSudokuGrid.size; x++) {

            for (int y = 0; y < mSudokuGrid.size; y++) {

                if (cellX == x || cellY == y || (Math.floor(x / 3f) == Math.floor(cellX / 3f) && Math.floor(y / 3f) == Math.floor(cellY / 3f))) {
                    if (mSudokuGrid.getBox(x, y).isFact) {
                        SudokuGenerator sudokuGenerator = mSudokuGrid.getBox(x,y);
                        currentStates.remove(sudokuGenerator);
                        //currentStates.remove(mSudokuGrid.getCell(x, y).state);
                        break;
                        //currentStates.remove(mSudokuGrid.getCell(x,y).state);
                    }
                }
            }
        }

        possibleStates = bPutAll(currentStates);
    }

    public void setRandomPossibleState() {

        if (!isFact && possibleStates.length > 0) {
            //state = possibleStates[ThreadLocalRandom.current().nextInt(0, possibleStates.length)];
            //int rand = (int)(10.0 * Math.random());
            //inclusive ? exclusive
            state = possibleStates[ThreadLocalRandom.current().nextInt(1, possibleStates.length)];
            isFact = true;
        }
    }

    public String toString(){
        if (isFact) {
            return state + " ";
        }
        return "# ";
    }
}
