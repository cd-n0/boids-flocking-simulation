package com.onursinan;

import java.util.*;
import java.awt.*;
// QS: https://youtu.be/zCiMlbu1-aQ
import java.awt.geom.*;
import java.lang.Math;

// TODO: Implement Seperation, alignment and cohesion
// TODO: Implement Seperation, alignment and cohesion

/**
 * Boid class represents an individual boid in a simulation.
 */
public class Boid {
    // Width and height of the simulation area
    private final int WIDTH = 1000;
    private final int HEIGHT = 1000;

    // Position and velocity vectors of the boid
    private Vector position = null;
    private Vector velocity = null;

    // List of all boids in the simulation
    private LinkedList<Boid> boids = null;

    /**
     * Sets the list of boids in the simulation.
     *
     * @param boids The list of boids.
     */
    public void setBoids(LinkedList<Boid> boids) {
        this.boids = boids;
    }

    /**
     * Constructs a boid with a random position and velocity within the simulation area.
     */
    Boid() {
        this.position = new Vector(WIDTH * Math.random(), HEIGHT * Math.random());
        this.velocity = new Vector(2 * (Math.random() - 0.5), 2 * (Math.random() - 0.5));
    }

    /**
     * Constructs a boid with specified position and velocity.
     *
     * @param x The x-coordinate of the position.
     * @param y The y-coordinate of the position.
     * @param i The x-component of the velocity.
     * @param j The y-component of the velocity.
     */
    Boid(int x, int y, double i, double j) {
        this.position = new Vector(x, y);
        this.velocity = new Vector(i, j);
    }

    /**
     * Updates the the boid.
     *
     * @param g The graphics context for drawing.
     */
    public void updateBoid(Graphics2D g) {
        this.position.add(this.velocity);
        this.drawBoid(g);
        this.wrapAround(WIDTH, HEIGHT);
        this.velocity.add(align(boids));
        this.velocity.limit(1);
        this.velocity.normalize();
    }

    /**
     * Draws the boid on the specified graphics context.
     *
     * @param g The graphics context for drawing.
     */
    private void drawBoid(Graphics2D g) {
        System.out.print("Drawing ");
        System.out.println(this);
        AffineTransform transformation = g.getTransform();
        g.translate(this.position.x, this.position.y);
        g.rotate(velocity.angle());
        // Set color based on rotation
        g.setColor(Color.getHSBColor(velocity.normalizedAngle() * 10, 1, 1));
        g.fill(boidShape());
        g.setTransform(transformation);
    }

    /**
     * Wraps the boid around the edges of the simulation area if it goes out of bounds.
     *
     * @param w The width of the simulation area.
     * @param h The height of the simulation area.
     */
    private void wrapAround(int w, int h) {
        if (position.x > w) position.x = 0;
        else if (position.x < 0) position.x = w;
        if (position.y > h) position.y = 0;
        else if (position.y < 0) position.y = h;
    }

    /**
     * Defines the shape of the boid.
     *
     * @return The shape of the boid.
     */
    private Shape boidShape() {
        Path2D shape = new Path2D.Double();
        shape.moveTo(10, 0);
        shape.lineTo(-10, 5);
        shape.lineTo(-7, 0);
        shape.lineTo(-10, -5);
        shape.closePath();

        return shape;
    }

    /**
     * Calculates the alignment vector for the boid based on neighboring boids.
     *
     * @param boids The list of all boids.
     * @return The alignment vector.
     */
    private Vector align(LinkedList<Boid> boids) {
        Boid boid = null;
        int boid_count = 0;
        Vector vec = new Vector();
        for (int i = 0; i < boids.size(); i++) {
            boid = boids.get(i);
            double distance = Vector.distance(position, boid.position);
            if (distance < 100) {
                vec.add(boid.velocity);
                boid_count++;
            }
        }
        vec.divide(boid_count);
        vec.subtract(this.velocity);
        vec.multiply(0.1);

        return vec;
    }

    /**
     * Returns a string representation of the boid.
     *
     * @return A string representation of the boid.
     */
    @Override
    public String toString() {
        return String.format("Boid[x:%s y:%s i:%s j:%s]", this.position.x, this.position.y, this.velocity.x, this.velocity.y);
    }
}
