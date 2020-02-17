package com.merve.machine.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MachineTest {

    private Machine machine;

    @Before
    public void setUp() {
        machine = new Machine(new Grid());
    }

    @Test
    public void turn_direction_on_white_square() {
        // arrange
        Direction expected = Direction.DOWN;

        // act
        machine.turnDirection();

        // assert
        assertEquals(machine.getDirection(), expected);
    }

    @Test
    public void turn_direction_on_black_square() {
        // arrange
        Direction expected = Direction.UP;
        machine.setCurrentSquare(new Square(2, 3));

        // act
        machine.turnDirection();

        // assert
        assertEquals(machine.getDirection(), expected);
    }

    @Test
    public void move_forward_on_white_square_while_direction_right() {
        // arrange
        Square expected = new Square(0, 1);

        // act
        machine.moveForward();

        // assert
        assertEquals(machine.getCurrentSquare(), expected);
    }

    @Test
    public void move_forward_on_white_square_while_direction_down() {
        // arrange
        Square expected = new Square(-1, 0);
        machine.setDirection(Direction.DOWN);

        // act
        machine.moveForward();

        // assert
        assertEquals(machine.getCurrentSquare(), expected);
    }


    @Test
    public void move_forward_on_white_square_while_direction_left() {
        // arrange
        Square expected = new Square(0, -1);
        machine.setDirection(Direction.LEFT);

        // act
        machine.moveForward();

        // assert
        assertEquals(machine.getCurrentSquare(), expected);
    }

    @Test
    public void move_forward_on_white_square_while_direction_up() {
        // arrange
        Square expected = new Square(1, 0);
        machine.setDirection(Direction.UP);

        // act
        machine.moveForward();

        // assert
        assertEquals(machine.getCurrentSquare(), expected);
    }


    @Test
    public void move_forward_on_black_square_while_direction_right() {
        // arrange
        Square expected = new Square(2, 2);
        machine.setCurrentSquare(new Square(2, 3));
        machine.setDirection(Direction.RIGHT);

        // act
        machine.moveForward();

        // assert
        assertEquals(machine.getCurrentSquare(), expected);
    }

    @Test
    public void move_forward_on_black_square_while_direction_up() {
        // arrange
        Square expected = new Square(1, 3);
        machine.setCurrentSquare(new Square(2, 3));
        machine.setDirection(Direction.UP);

        // act
        machine.moveForward();

        // assert
        assertEquals(machine.getCurrentSquare(), expected);
    }

    @Test
    public void move_forward_on_black_square_while_direction_left() {
        // arrange
        Square expected = new Square(2, 4);
        machine.setCurrentSquare(new Square(2, 3));
        machine.setDirection(Direction.LEFT);

        // act
        machine.moveForward();

        // assert
        assertEquals(machine.getCurrentSquare(), expected);
    }

    @Test
    public void move_forward_on_black_square_while_direction_down() {
        // arrange
        Square expected = new Square(3, 3);
        machine.setCurrentSquare(new Square(2, 3));
        machine.setDirection(Direction.DOWN);

        // act
        machine.moveForward();

        // assert
        assertEquals(machine.getCurrentSquare(), expected);
    }

    @Test
    public void move_forward_remove_square_if_color_will_be_white() {
        // arrange
        Square expected = new Square(0, 0);
        machine.setCurrentSquare(new Square(-1, 0));
        machine.getGrid().addSquare(machine.getCurrentSquare());
        machine.setDirection(Direction.UP);

        // act
        machine.moveForward();

        // assert
        assertFalse(machine.getGrid().findSquare(expected));
    }

}
