package com.github.srang.ca.sim;

import com.github.srang.ca.model.Canvas;
import com.github.srang.ca.model.Cell;

/**
 * Created by srang on 2/2/17.
 */
public class IndexProcessStrategy implements ProcessStrategy {
    @Override
    public Canvas process(Canvas canvas) {
        for (int h = 0; h < canvas.getHeight(); h++) {
            for (int w = 0; w < canvas.getWidth(); w++) {

                Cell cell = canvas.getCells().get(h).get(w);
                Integer value = cell.getValue();
                cell.setValue(h + (w * 3));
                canvas.getCells().get(h).set(w, cell);
            }
        }
        return canvas;
    }
}
