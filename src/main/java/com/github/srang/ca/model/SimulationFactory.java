package com.github.srang.ca.model;

/**
 * Created by samuelrang on 2/12/2017.
 */

import com.github.srang.ca.sim.ProcessStrategy;

/**
 * making a class abstract is one way of preventing
 * it from being instantiated (although not the only
 * way). Why would you want to keep a class from
 * being instantiated? Well so in this example, the
 * class's only purpose is to churn out populated
 * Simulations so if we were to create an instance
 * of it, we'd just be wasting memory. In practice
 * you may not actually see this type of enforcement
 * because sometimes people don't feel like its necessary
 * and people can be lazy, or they may not even think
 * it through. As a good designer though you want
 * the purpose and usage of your code to be immediately
 * apparent from looking at just the code (or even just
 * the code documentation eg javadocs).
 *
 * This class is an example of the factory design pattern.
 */
public abstract class SimulationFactory {

    /**
     * Method is public meaning it can be called from any package.
     * Method is static meaning that it is specified for the class
     * not for instances. This means that you don't have to create
     * and object to call the method.
     * @param canvas
     * @param strategy
     * @return
     */
    public static Simulation build(Canvas canvas, ProcessStrategy strategy) {
        Simulation base = Simulation.getInstance();
        base.setCanvas(canvas);
        base.setProcessStrategy(strategy);
        return base;
    }
}
