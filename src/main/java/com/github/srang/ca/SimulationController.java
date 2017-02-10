package com.github.srang.ca;

import com.github.srang.ca.model.Canvas;
import com.github.srang.ca.model.SimForm;
import com.github.srang.ca.sim.IndexProcessStrategy;
import com.github.srang.ca.sim.ProcessStrategy;
import com.github.srang.ca.sim.Simulation;
import com.github.srang.ca.sim.SpreadingFireProcessStrategy;
import lombok.extern.java.Log;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@Log
public class SimulationController {
    Simulation simulation;

    @MessageMapping("/simulate")
    @SendTo("/topic/cells")
    public Canvas simulate(SimForm simRequest) {
        Canvas canvas = new Canvas(simRequest.getHeight(), simRequest.getWidth());
        ProcessStrategy strategy;
        if(simRequest.getSimulation().equals("index")) {
            strategy = new IndexProcessStrategy();
        } else {
            strategy = new SpreadingFireProcessStrategy();
        }
        this.simulation = new Simulation(canvas, strategy);
        return this.simulation.process();
    }

    @MessageMapping("/propagate")
    @SendTo("/topic/cells")
    public Canvas asdf(Object obj) {
        return this.simulation.process();
    }

}
