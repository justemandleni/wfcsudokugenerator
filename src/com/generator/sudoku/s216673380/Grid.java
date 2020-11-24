package com.generator.sudoku.s216673380;

import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

class Grid {
    public int size;
    public Cell[][] cells;
    public List<Cell> cellList;

    public Grid(int mSize, ArrayList<Integer> mStates){
        size = mSize;
        cells = new Cell[size][size];
        cellList = new ArrayList<>();
        for(int i = 0; i < size; i++){
            for(int k = 0; k < size; k++){
                cells[i][k] = new Cell(i,k,this, mStates);
                cellList.add(cells[i][k]);
            }
        }
    }

    public void populateCells(){
        for (int x = 0; x < size; x++)
        {
            for (int y = 0; y < size; y++)
            {
                cells[x][y].populate(); //
            }
        }
    }

    public void solveRandomCells(int amount){
        for(int i = 0; i < amount; i++){
            populateCells();
            Random random = new Random();
            Cell randomCell = cellList.stream()
                    .filter(cell -> !cell.isFinal)
                    .sorted(Comparator.comparing(s -> random.nextInt()))
                    .findFirst()
                    .orElse(null);

            if(randomCell != null) {
                randomCell.setRandomPossibleState();
            }
        }
    }

    public void solveSingleRandomCell(){
        populateCells();
        Random random = new Random();
        Cell randomCell = cellList.stream()
                .filter(cell -> !cell.isFinal)
                .sorted(Comparator.comparing(s -> random.nextInt()))
                .findFirst()
                .orElse(null);

        if(randomCell != null) {
            randomCell.setRandomPossibleState();
        }
    }

    public Cell getCell(int x, int y){
        if(isWithinGrid(x,y)){
            return cells[x][y];
        }
        return null;
    }

    private boolean isWithinGrid(int x, int y) {
        return x >= 0 && y >= 0 & x < size && y < size;
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int y = 0; y < size; y++)
        {
            for (int x = 0; x < size; x++)
            {
                stringBuilder.append(cells[x][y]);
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
