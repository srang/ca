package com.github.srang.ca.sim;

import com.github.srang.ca.model.Canvas;

/**
 * Created by srang on 2/2/17.
 */
public class Simulation {
    private Canvas canvas;
    private ProcessStrategy processStrategy;

    public Simulation(Canvas canvas, ProcessStrategy processStrategy) {
        this.canvas = canvas;
        this.processStrategy = processStrategy;
    }

    public Canvas process() {
        return this.processStrategy.process(this.canvas);
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public ProcessStrategy getProcessStrategy() {
        return processStrategy;
    }

    public void setProcessStrategy(ProcessStrategy processStrategy) {
        this.processStrategy = processStrategy;
    }

    @Override
    public String toString() {
        return "Simulation{" +
                "canvas=" + canvas +
                ", name='" + processStrategy.getClass().getName() + '\'' +
                '}';
    }
}
