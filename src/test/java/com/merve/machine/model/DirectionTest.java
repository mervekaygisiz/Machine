package com.merve.machine.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DirectionTest {

    @Test
    public void turn_clockwise_from_right() {
        // arrange
        Direction expected = Direction.RIGHT;

        // act
        expected = expected.clockwise90();

        // assert
        assertEquals(Direction.DOWN, expected);
    }

    @Test
    public void turn_clockwise_from_down() {
        // arrange
        Direction expected = Direction.DOWN;

        // act
        expected = expected.clockwise90();

        // assert
        assertEquals(Direction.LEFT, expected);
    }

    @Test
    public void shouldTurn90RightFromLeft() {
        // arrange
        Direction expected = Direction.LEFT;

        // act
        expected = expected.clockwise90();

        // aseert
        assertEquals(Direction.UP, expected);
    }

    @Test
    public void shouldTurn90RightFromUp() {
        // arrange
        Direction expected = Direction.UP;

        // act
        expected = expected.clockwise90();

        // aseert
        assertEquals(Direction.RIGHT, expected);
    }

    @Test
    public void shouldTurn90LeftFromRigth() {
        // arrange
        Direction expected = Direction.RIGHT;

        // act
        expected = expected.counterClockwise90();

        // aseert
        assertEquals(Direction.UP, expected);
    }

    @Test
    public void shouldTurn90LeftFromUp() {
        // arrange
        Direction expected = Direction.UP;

        // act
        expected = expected.counterClockwise90();

        // aseert
        assertEquals(Direction.LEFT, expected);
    }

    @Test
    public void shouldTurn90LeftFromLeft() {
        // arrange
        Direction expected = Direction.LEFT;

        // act
        expected = expected.counterClockwise90();

        // aseert
        assertEquals(Direction.DOWN, expected);
    }

    @Test
    public void shouldTurn90LeftFromDown() {
        // arrange
        Direction expected = Direction.DOWN;

        // act
        expected = expected.counterClockwise90();

        // aseert
        assertEquals(Direction.RIGHT, expected);
    }
}
