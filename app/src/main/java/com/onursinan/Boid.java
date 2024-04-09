package com.onursinan;

import java.util.*;
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
    private Vector position = null;
    private Vector velocity = null;
    private LinkedList<Boid> boids = null;
    
    public void setBoids(LinkedList<Boid> boids) {
        this.boids = boids;
    }

    Boid(){
        this.position = new Vector(WIDTH * Math.random() , HEIGHT * Math.random());
        this.velocity = new Vector(2 * (Math.random() - 0.5), 2 * (Math.random() - 0.5));
    }

    Boid(int x, int y){
        this.position = new Vector(x , y);
        this.velocity = new Vector(-1, 0);
    }

    Boid(int x, int y, double i, double j){
        this.position = new Vector(x , y);
        this.velocity = new Vector(i, j);
    }

    public void updateBoid(Graphics2D g){
        // Calculate the magnitude of the vector
        double magnitude = Math.sqrt(Math.pow(this.velocity.x, 2) + Math.pow(this.velocity.y, 2));

        //// Normalize the velocities
        //if (magnitude > 1){
        //    this.velocity.x /= magnitude;
        //    this.velocity.y /= magnitude;
        //}
        this.velocity.limit(1);
        this.position.add(this.velocity);
        this.drawBoid(g);
        this.wrapAround(WIDTH, HEIGHT);
        this.align(boids);
    }

    private void drawBoid(Graphics2D g){
        System.out.print("Drawing ");
        System.out.println(this);
        AffineTransform transformation = g.getTransform();
        g.translate(this.position.x, this.position.y);
        g.rotate(velocity.angle());
        // Set color based on rotation
        g.setColor(Color.getHSBColor(velocity.normalizedAngle() * 10, 1 , 1));
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

    // Sum and take the average
    private void align(LinkedList<Boid> boids){
        Boid boid = null;
        int boid_count = 0;
        Vector vec = new Vector();
        for (int i = 0; i < boids.size(); i++){
             boid = boids.get(i);
             double distance = Vector.distance(position, boid.position);
             if (distance < 100){
                 vec.add(boid.velocity);
                 boid_count++;
             }
        }
        // boids.forEach(boid -> {
        //     double distance = Vector.distance(position, boid.position);
        //     if (distance < 10){
        //         vec.add(boid.velocity);
        //         boid_count++;
        //     }
        // });
        vec.div(boid_count);
        vec.sub(this.velocity);
        vec.normalize();

        this.velocity.add(vec);
    }

    @Override
    public String toString(){
        return String.format("Boid[x:%s y:%s i:%s j:%s]", this.position.x, this.position.y, this.velocity.x, this.velocity.y);
    }


}
