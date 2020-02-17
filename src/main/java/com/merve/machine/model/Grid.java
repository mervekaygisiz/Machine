package com.merve.machine.model;

import java.util.HashSet;
import java.util.Set;

public class Grid {

    private Set<Square> squares;

    private int maxX;
    private int maxY;

    public Grid() {
        squares = new HashSet<>();
    }

    public void addSquare(Square square) {
        squares.add(square);
    }

    public void removeSquare(Square square) {
        squares.remove(square);
    }

    public boolean findSquare(Square square) {
        return squares.contains(square);
    }

    public Set<Square> getSquares() {
        return squares;
    }

    public int getMaxX() {
        return maxX;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }


}
