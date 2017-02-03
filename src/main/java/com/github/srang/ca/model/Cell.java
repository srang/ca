package com.github.srang.ca.model;

/**
 * Created by srang on 2/2/17.
 */
public class Cell {
    Integer value;

    public Cell(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String toString() {
        return "Cell(value=" + this.getValue() + ")";
    }
}
