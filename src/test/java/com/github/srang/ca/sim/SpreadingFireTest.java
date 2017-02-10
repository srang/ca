package com.github.srang.ca.sim;

import com.github.srang.ca.model.Canvas;
import com.github.srang.ca.model.Cell;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

/**
 * Created by samuelrang on 2/9/2017.
 */
@RunWith(JUnit4.class)
public class SpreadingFireTest {


    /**
     * shows how java treats objects, it is like a pointer in C where it
     * just references a place in memory so changes to the underlying object
     * are reflected as long as the reference points to the same object.
     *
     * This also tests that the process method changes stuff
     */
    @Test
    public void testSimpleProcess() {
        SpreadingFireProcessStrategy strat = new SpreadingFireProcessStrategy();
        Canvas testCanvas = new Canvas(1, 1);
        Cell testCell = new Cell(1);
        testCanvas.setCell(0,0, testCell);
        testCanvas = strat.process(testCanvas);
        assertThat("cell value should change", 1, not(testCell.getValue()));
    }
}
