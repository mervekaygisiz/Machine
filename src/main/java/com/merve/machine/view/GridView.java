package com.merve.machine.view;

import com.merve.machine.model.Grid;
import com.merve.machine.model.Square;

import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GridView {

    private static final String PROJECT_PATH = System.getProperty("user.dir") + "/machine.png";

    private Grid grid;
    Square currentSquare;

    public GridView(Grid grid, Square currentSquare) {
        this.grid = grid;
        this.currentSquare = currentSquare;
    }

    public void paintComponent() throws IOException {
        int cellSize = 15;
        int padding =  50;
        int imageWidth = Math.max(grid.getMaxX(), 50) * cellSize * 2 + padding;
        int imageHeight = Math.max(grid.getMaxY(), 50) * cellSize * 2 + padding;

        int midWidth = imageWidth / 2;
        int midHeight = imageHeight / 2;

        final BufferedImage image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        final Graphics2D graphics2D = image.createGraphics();
        graphics2D.setPaint(Color.WHITE);
        graphics2D.fillRect(0, 0, imageWidth, imageHeight);
        graphics2D.setPaint(Color.BLACK);

        for (Square square : grid.getSquares()) {
            graphics2D.fillRect((midWidth + square.getX() * cellSize) + 1, (midHeight + square.getY() * cellSize) + 1, cellSize - 1, cellSize - 1);
        }

        graphics2D.setPaint(Color.RED);
        graphics2D.fillRect((midWidth + currentSquare.getX() * cellSize) + 1, (midHeight + currentSquare.getY() * cellSize) + 1, cellSize - 1, cellSize - 1);

        graphics2D.dispose();

        ImageIO.write(image, "png", new File(PROJECT_PATH));

    }

}
