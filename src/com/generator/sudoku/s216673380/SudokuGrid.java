package com.generator.sudoku.s216673380;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

class SudokuGrid {
    public final int size;
    public final SudokuGenerator[][] box;
    public final List<SudokuGenerator> mSudokuGeneratorList;

    public SudokuGrid(int mSize, int[] mStates){
        size = mSize;
        box = new SudokuGenerator[size][size];
        mSudokuGeneratorList = new ArrayList<>();
        for(int i = 0; i < size; i++){

            for(int k = 0; k < size; k++){
                box[i][k] = new SudokuGenerator(i,k,this, mStates);
                mSudokuGeneratorList.add(box[i][k]);
            }

        }
    }

    public void setBoxValue(){
        for (int x = 0; x < size; x++)
        {
            for (int y = 0; y < size; y++)
            {
                box[x][y].populate();
            }
        }
    }

    public void clearAllBoxes(){
        for (int y = 0; y < size; y++)
        {
            for (int x = 0; x < size; x++)
            {
                box[x][y].state = -1;
            }
        }
    }

    public void solveSingleRandomCell(){
        setBoxValue();
        Random random = new Random();
        SudokuGenerator randomSudokuGenerator = mSudokuGeneratorList.stream()
                .filter(sudokuGenerator -> !sudokuGenerator.isFact)
                .sorted(Comparator.comparing(s -> random.nextInt()))
                .findAny()
                .orElse(null);

        if(randomSudokuGenerator != null) {
            randomSudokuGenerator.setRandomPossibleState();
        }
    }

    public SudokuGenerator getBox(int x, int y){
        if(isWithinGrid(x,y)){
            return box[x][y];
        }
        return null;
    }

    private boolean isWithinGrid(int x, int y) {
        if (x >= 0)
            if (y >= 0 & x < size)
                if (y < size)
                    return true;
        return false;
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int y = 0; y < size; y++)
        {
            for (int x = 0; x < size; x++)
            {
                stringBuilder.append(box[x][y]);
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
