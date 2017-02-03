package com.github.srang.ca;

import com.github.srang.ca.model.Canvas;
import com.github.srang.ca.model.SimForm;
import com.github.srang.ca.sim.Simulation;
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
    public Canvas simulate(SimForm simRequest) throws Exception {
        Canvas canvas = new Canvas(simRequest.getWidth(), simRequest.getHeight());
        this.simulation = new Simulation(canvas, simRequest.getSimulation());
        return canvas;
    }
    
}
