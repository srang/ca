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
public class TimerTest {


    /**

     */
    @Test
    public void testSimpleProcess() {
          TimerProcessStrategy strat = new TimerProcessStrategy();
          Canvas testCanvas = new Canvas(1, 1);
          Cell testCell = new Cell(1);
          testCanvas.setCell(0,0, testCell);
          for(int i = 1; i <10; i++){
            testCanvas = strat.process(testCanvas);
            assertThat("cell value should increment by 1", i-1, not(testCell.getValue()));
          }

    }
}
