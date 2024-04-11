package com.onursinan;

import javax.swing.*;
import java.awt.*;

// TODO: Comment
public class SimulationFrame extends JFrame{
    SimulationRenderer panel;

    SimulationFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new SimulationRenderer();
        this.add(panel, BorderLayout.CENTER);
        this.pack();
        this.setSize(1000, 1000);
        this.setTitle("Boids Flocking Simulation");
        this.setLocation(0, 0);
        this.setVisible(true);
        Rectangle display = this.getBounds();
        System.out.println(display.x + " " + display.y);
        panel.run(this);
    }
}
