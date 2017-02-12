package com.github.srang.ca.model;

import com.github.srang.ca.sim.ProcessStrategy;

/**
 * Created by srang on 2/2/17.
 */
public class Simulation {

    private Canvas canvas;
    private ProcessStrategy processStrategy;

    /**
     * this section is an example of the Singleton
     * pattern. It allows only a single instance of the
     * Simulation class to exist in the program runtime.
     * This makes sense for simulation because in the web
     * app you will only be able to display a single simulation
     * at a time. The way to change the behavior of a
     * Simulation is by changing the Canvas and ProcessStrategy,
     * reinforcing the idea of encapsulation. A canvas encapsulates
     * the data (size and values) of a simulation, while the
     * strategy encapsulates the algorithm for how
     * a simulation updates.
     */
    private static Simulation instance;
    protected static Simulation getInstance() {
        if (instance == null) {
            instance = new Simulation();
        }
        return instance;
    }
    private Simulation() {}

    /**
     * The only public method exposed by Simulation. This means
     * that if the `model` package (anything in the model folder)
     * was separated out into another java project, and then used
     * as a dependency (which is fairly common with object models)
     * the only method allowed for a simulation would be this one.
     * In order to modify the simulation you would need to use the
     * factory to create a new one. This may seem like a round about
     * way, but it simplifies the usage and behavior of Simulations
     * to be just a way of composing (an OO design principle that
     * basically means combining smaller objects into a single concept)
     * a Canvas (or data) and a strategy (our algorithm). By making
     * it a signleton we've eliminated the concern of a lot of
     * objects being created and wasting memory so now it makes sense
     * to remove the ability to directly modify the internals of a
     * simulation.
     * @return updated Canvas
     */
    public Canvas process() {
        this.canvas = this.processStrategy.process(this.canvas);
        return this.canvas;
    }

    protected Canvas getCanvas() {
        return canvas;
    }

    protected void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    protected ProcessStrategy getProcessStrategy() {
        return processStrategy;
    }

    protected void setProcessStrategy(ProcessStrategy processStrategy) {
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
