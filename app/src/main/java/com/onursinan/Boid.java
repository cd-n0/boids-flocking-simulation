package com.onursinan;

import java.awt.*;
// QS: https://youtu.be/zCiMlbu1-aQ
import java.awt.geom.*;
import java.lang.Math;

// TODO: Comment
// TODO: Implement Seperation, alignment and cohesion
// TODO: Implement Seperation, alignment and cohesion
public class Boid{
    private final int WIDTH = 1000;
    private final int HEIGHT = 1000;
    private Vector position;
    private Vector velocity;
    
    Boid(){
        this.position = new Vector(WIDTH/2 , HEIGHT/2);// Vector(WIDTH * Math.random() , HEIGHT * Math.random());
        this.velocity = new Vector(2 * (Math.random() - 0.5), 2 * (Math.random() - 0.5));
    }

    Boid(int x, int y){
        this.position = new Vector(x , y);
        this.velocity = new Vector(-1, 0);
    }

    Boid(int x, int y, int i, int j){
        this.position = new Vector(x , y);
        this.velocity = new Vector(i, j);
    }

    public void updateBoid(Graphics2D g){
        // Calculate the magnitude of the vector
        double magnitude = Math.sqrt(Math.pow(this.velocity.x, 2) + Math.pow(this.velocity.y, 2));

        // Normalize the velocities
        if (magnitude > 0){
        this.velocity.x /= magnitude;
        this.velocity.y /= magnitude;
        }
        this.position.add(this.velocity);
        this.drawBoid(g);
        this.wrapAround(WIDTH, HEIGHT);
    }

    private void drawBoid(Graphics2D g){
        AffineTransform transformation = g.getTransform();
        g.translate(this.position.x, this.position.y);
        g.rotate(velocity.angle());
        // Set color based on rotation
        g.setColor(Color.getHSBColor(velocity.normalizedAngle() * 255, 1 , 1));
        g.fill(boidShape());
        g.setTransform(transformation);
    }

    private void wrapAround(int w, int h) {
        if(position.x > w) position.x = 0;
        else if(position.x < 0) position.x = w;
        if(position.y > h) position.y = 0;
        else if(position.y < 0) position.y = h;
    }

    private Shape boidShape() {
        Path2D shape = new Path2D.Double();
        shape.moveTo(10, 0);
        shape.lineTo(-10, 5);
        shape.lineTo(-7, 0);
        shape.lineTo(-10, -5);
        shape.closePath();

        return shape;
    }

}
