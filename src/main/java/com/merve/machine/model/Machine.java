package com.merve.machine.model;

public class Machine {

    private Square currentSquare;
    private Direction direction;
    private Grid grid;
    private int maxX;
    private int maxY;

    public Machine(Grid grid) {
        currentSquare = new Square(0, 0);
        direction = Direction.RIGHT;
        this.grid = grid;
        grid.addSquare(currentSquare);
        maxX = 0;
        maxY = 0;
    }

    public void turnDirection() {
        if (grid.findSquare(currentSquare)) {
            direction = direction.clockwise90();
        } else {
            direction = direction.counterClockwise90();
        }
    }

    public void moveForward() {
        turnDirection();

        int currentX = currentSquare.getX();
        int currentY = currentSquare.getY();

        if (direction.equals(Direction.RIGHT)) {
            currentX += 1;
        } else if (direction.equals(Direction.DOWN)) {
            currentY += 1;
        } else if (direction.equals(Direction.LEFT)) {
            currentX -= 1;
        } else {
            currentY -= 1;
        }

        Square nextSquare = new Square(currentX, currentY);
        if (!grid.findSquare(nextSquare)) {
            grid.addSquare(nextSquare);
        } else {
            grid.removeSquare(nextSquare);
        }
        currentSquare = nextSquare;

        if (maxX < Math.abs(currentSquare.getX())) {
            maxX = Math.abs(currentSquare.getX());
            grid.setMaxX(maxX);
        }
        if (maxY < Math.abs(currentSquare.getY())) {
            maxY = Math.abs(currentSquare.getY());
            grid.setMaxY(maxY);
        }
    }

    public Square getCurrentSquare() {
        return currentSquare;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setCurrentSquare(Square currentSquare) {
        this.currentSquare = currentSquare;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Grid getGrid() {
        return grid;
    }

}
