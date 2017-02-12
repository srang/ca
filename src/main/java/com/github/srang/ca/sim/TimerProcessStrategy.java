package com.github.srang.ca.sim;

import com.github.srang.ca.model.Canvas;
import com.github.srang.ca.model.Cell;

/**
 * Created by MichaelB94 on 2/9/17.
 */
public class TimerProcessStrategy implements ProcessStrategy {
    @Override
    public Canvas process(Canvas canvas) {
        Canvas newCanvas = new Canvas(canvas.getHeight(), canvas.getWidth());  // create a new canvas
        for (int h = 0; h < canvas.getHeight(); h++) {
            for (int w = 0; w < canvas.getWidth(); w++) {
                Cell cell = canvas.getCells().get(h).get(w); // populate this canvas with cells from an ArrayList
                
                cell.setValue(cell.getValue()+1); //increment by one 
                newCanvas.getCells().get(h).set(w, cell);
            }
        }
        return canvas;
    }
}
