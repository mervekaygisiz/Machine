package com.merve.machine.model;

public enum Direction {
    RIGHT, DOWN, LEFT, UP;

    public Direction clockwise90() {
        return Direction.values()[(this.ordinal() + 1) % 4];
    }

    public Direction counterClockwise90() {
        return Direction.values()[(this.ordinal() + 3) % 4];
    }

}
