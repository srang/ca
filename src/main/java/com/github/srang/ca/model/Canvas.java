package com.github.srang.ca.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by srang on 2/2/17.
 */
public class Canvas {
    private Integer height;
    private Integer width;
    private List<List<Cell>> cells;

    public Canvas() {
    }

    public Canvas(Integer height, Integer width) {
        this.height = height;
        this.width = width;
        this.cells = new ArrayList<>();
        for (int h = 0; h < height; h++) {
            List<Cell> temp = new ArrayList<>();
            for (int w = 0; w < width; w++) {
                temp.add(w, new Cell(1));
            }
            this.cells.add(h, temp);
        }
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public List<List<Cell>> getCells() {
        return cells;
    }

    public void setCells(List<List<Cell>> cells) {
        this.cells = cells;
    }

    /* TODO add function that returns a cell at a particular location */

    @Override
    public String toString() {
        return "Canvas{" +
                "height=" + height +
                ", width=" + width +
                ", cells=" + cells +
                '}';
    }
}
