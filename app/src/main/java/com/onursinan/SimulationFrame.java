package com.onursinan;

import javax.swing.*;
import java.awt.*;

// TODO: Comment
public class SimulationFrame extends JFrame{
    SimulationRenderer panel;

    SimulationFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        panel = new SimulationRenderer(this);
        this.add(panel, BorderLayout.CENTER);
        this.pack();
        this.setTitle("Boids Flocking Simulation");
        this.setLocation(0, 0);
    }
}
