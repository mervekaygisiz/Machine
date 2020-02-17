package com.merve.machine.model;

import javax.validation.constraints.Min;

public class Step {

    @Min(value = 0L, message = "The value must be positive")
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
