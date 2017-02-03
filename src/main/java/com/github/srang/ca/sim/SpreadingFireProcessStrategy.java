package com.github.srang.ca.sim;

import com.github.srang.ca.model.Canvas;
import com.github.srang.ca.model.Cell;

/**
 * Created by srang on 2/2/17.
 */
public class SpreadingFireProcessStrategy implements ProcessStrategy {
    @Override
    public Canvas process(Canvas canvas) {
        Canvas newCanvas = new Canvas(canvas.getHeight(), canvas.getWidth());
        for (int h = 0; h < canvas.getHeight(); h++) {
            for (int w = 0; w < canvas.getWidth(); w++) {
                Cell cell = canvas.getCells().get(h).get(w);
                if (w == 0) {
                    Integer value = cell.getValue();
                    cell.setValue((value+1)%3);
                } else {
                    cell.setValue(canvas.getCells().get(h).get(w - 1).getValue() + (w * 2));
                }
                newCanvas.getCells().get(h).set(w, cell);
            }
        }
        return canvas;
    }
}
