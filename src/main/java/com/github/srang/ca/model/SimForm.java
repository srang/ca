package com.github.srang.ca.model;

/**
 * Created by srang on 2/2/17.
 */
public class SimForm {
    private String simulation;
    private Integer height;
    private Integer width;

    public SimForm() {
    }

    public SimForm(String simulation, Integer height, Integer width) {
        this.simulation = simulation;
        this.height = height;
        this.width = width;
    }

    public String getSimulation() {
        return this.simulation;
    }

    public Integer getHeight() {
        return this.height;
    }

    public Integer getWidth() {
        return this.width;
    }

    public void setSimulation(String simulation) {
        this.simulation = simulation;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "SimForm{" +
                "simulation='" + simulation + '\'' +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}
