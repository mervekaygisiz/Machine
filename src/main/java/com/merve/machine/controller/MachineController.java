package com.merve.machine.controller;

import com.merve.machine.model.Step;
import com.merve.machine.service.MachineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@RestController
public class MachineController {

    @Autowired
    private MachineService machineService;

    public static final Logger logger = LoggerFactory.getLogger(MachineController.class);

    @PutMapping(value = "/machine")
    public void simulation(@Valid Step step) throws IOException {
        logger.info("Simulation of grid with step number {}", step.getSize());
        machineService.simulation(step);
    }
}
