package com.github.srang.ca.sim;

import com.github.srang.ca.model.Canvas;

/**
 * Created by srang on 2/2/17.
 */
public class Simulation {
    private Canvas canvas;
    private String name;

    public Simulation(Canvas canvas, String name) {
        this.canvas = canvas;
        this.name = name;

        /* todo initialize cells & define simulation function */
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Simulation{" +
                "canvas=" + canvas +
                ", name='" + name + '\'' +
                '}';
    }
}
