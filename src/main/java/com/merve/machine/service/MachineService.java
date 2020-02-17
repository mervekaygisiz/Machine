package com.merve.machine.service;

import com.merve.machine.model.Machine;
import com.merve.machine.model.Grid;
import com.merve.machine.model.Square;
import com.merve.machine.model.Step;
import com.merve.machine.view.GridView;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MachineService {

    public void simulation(Step step) throws IOException {

        Grid grid = new Grid();
        Machine machine = new Machine(grid);

        for (int i = 0; i < step.getSize(); i++) {
            machine.moveForward();
        }

        Square currentSquare = machine.getCurrentSquare();
        GridView view = new GridView(grid, currentSquare);

        view.paintComponent();

    }
}
