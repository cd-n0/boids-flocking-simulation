package com.onursinan;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.util.*;

// TODO: Comment
public class SimulationRenderer extends JPanel{
    private JFrame frame = null;
    private LinkedList<Boid> boids = new LinkedList<Boid>();
    protected static Dimension dimension = new Dimension(1000, 1000);
    // Game Tick
    private final Timer timer = new Timer(10, listener->repaint());

    SimulationRenderer(){
        // TODO: Initialize boids or generate in some way, and delete the test boids
        for (int i = 0; i < 250; i++){
            Boid boid = new Boid();
            boid.setBoids(boids);
            boids.add(boid);
        }
        this.setPreferredSize(new Dimension(dimension.width, dimension.height));
    }
    public void renderLoop(Graphics graphics){
        Graphics2D g = (Graphics2D) graphics;
        // Enable AA
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        paintBoids(g);
    }
    private void paintBoids(Graphics2D g){
        boids.forEach(boid -> boid.updateBoid(g));
    }

    public void run(JFrame frame){
        this.frame = frame;
        timer.start();
    }

    public void stop(){
        timer.stop();
    }

    /* I do get the appeal, but java devs this is actuallly restarted.
     * Understanding java swing in detail, took me longer than learning SDL
     * and OpenGL combined. Maybe it's language familiarity, but I doubt it.
     */
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D)graphics;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        SimulationRenderer.dimension = frame.getSize();
        
        frame.setSize(SimulationRenderer.dimension);
        
        renderLoop(graphics);
    }

}
