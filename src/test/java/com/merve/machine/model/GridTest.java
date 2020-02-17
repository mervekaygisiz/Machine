package com.merve.machine.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GridTest {
    private Grid grid;

    @Before
    public void setUp() {
        grid = new Grid();
    }

    @Test
    public void add_square_into_grid() {
        // arrange
        final int expected = 1;

        // act
        grid.addSquare(new Square(0, 0));
        final int actual = grid.getSquares().size();

        // assert
        assertEquals(actual, expected);
    }

    @Test
    public void remove_square_from_grid() {
        // arrange
        final int expected = 0;
        grid.addSquare(new Square(0, 0));

        // act
        grid.removeSquare(new Square(0, 0));
        final int actual = grid.getSquares().size();

        // assert
        assertEquals(actual, expected);
    }

    @Test
    public void remove_square_from_grid_when_grid_null() {
        // arrange
        final int expected = 0;

        // act
        grid.removeSquare(new Square(0, 0));
        final int actual = grid.getSquares().size();

        // assert
        assertEquals(actual, expected);
    }

    @Test
    public void find_true_square_in_grid() {
        // arrange
        final boolean expected = true;
        Square square = new Square(0, 0);
        grid.addSquare(square);

        // act
        final boolean actual = grid.findSquare(square);

        // assert
        assertEquals(actual, expected);
    }

    @Test
    public void find_false_square_in_grid() {
        // arrange
        final boolean expected = false;
        Square square = new Square(0, 0);

        // act
        final boolean actual = grid.findSquare(square);

        // assert
        assertEquals(actual, expected);
    }

}
