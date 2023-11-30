package com.mey.se420.se420_2023;

public class Room {
    private char label;
    private int row;
    private int column;

    public Room(char label, int row, int column) {
        this.label = label;
        this.row = row;
        this.column = column;
    }

    public char getLabel() {
        return label;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
