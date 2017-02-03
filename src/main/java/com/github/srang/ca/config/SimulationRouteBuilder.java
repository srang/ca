package com.github.srang.ca.config;

import com.github.srang.ca.SimulationController;
import com.github.srang.ca.sim.Simulation;
import org.apache.camel.builder.RouteBuilder;

/**
 * Created by srang on 2/2/17.
 */
public class SimulationRouteBuilder extends RouteBuilder {
    private Simulation simulation;

    public SimulationRouteBuilder(Simulation simulation) {
        this.simulation = simulation;
    }

    @Override
    public void configure() throws Exception {
        from("timer://foo?fixedRate=true&period=5000")
                .id("simulation-processor")
                .bean(this.simulation, "process")
                .bean(SimulationController.class, "publish");
    }
}
