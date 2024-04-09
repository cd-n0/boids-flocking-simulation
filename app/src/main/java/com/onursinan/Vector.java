package com.onursinan;

import java.lang.Math;

/**
 * Represents a 2D vector with x and y components.
 */
public class Vector {

    /** The x component of the vector. */
    public double x;
    
    /** The y component of the vector. */
    public double y;

    /**
     * Constructs a vector with components initialized to zero.
     */
    public Vector() {
        this(0, 0);
    }

    /**
     * Constructs a vector with specified x and y components.
     *
     * @param x The x component of the vector.
     * @param y The y component of the vector.
     */
    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Calculates the magnitude (length) of the vector.
     *
     * @return The magnitude of the vector.
     */
    public double magnitude() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }

    /**
     * Normalizes the vector (sets its length to 1).
     */
    public void normalize() {
        double magnitude = magnitude();
        if (magnitude != 0) {
            x /= magnitude;
            y /= magnitude;
        }
    }

    /**
     * Limits the magnitude of the vector to the specified value.
     *
     * @param limit The maximum magnitude of the vector.
     */
    public void limit(double limit){
        double magnitude = this.magnitude();
        if (magnitude > limit){
            this.x *= limit / magnitude;
            this.y *= limit / magnitude;
        }
    }

    /**
     * Adds the components of another vector to this vector.
     *
     * @param vector The vector to add.
     */
    public void add(Vector vector){
        this.x += vector.x;
        this.y += vector.y;
    }

    /**
     * Subtracts the components of another vector from this vector.
     *
     * @param vector The vector to subtract.
     */
    public void subtract(Vector vector){
        this.x -= vector.x;
        this.y -= vector.y;
    }

    /**
     * Divides the components of this vector by the components of another vector.
     *
     * @param vector The vector to divide by.
     */
    public void divide(Vector vector){
        this.x /= vector.x;
        this.y /= vector.y;
    }

    /**
     * Divides the components of this vector by a scalar value.
     *
     * @param value The value to divide by.
     */
    public void divide(double value){
        this.x /= value;
        this.y /= value;
    }

    /**
     * Multiplies the components of this vector by the components of another vector.
     *
     * @param vector The vector to multiply by.
     */
    public void multiply(Vector vector){
        this.x *= vector.x;
        this.y *= vector.y;
    }

    /**
     * Multiplies the components of this vector by a scalar value.
     *
     * @param value The value to multiply by.
     */
    public void multiply(double value){
        this.x *= value;
        this.y *= value;
    }

    /**
     * Calculates the dot product of this vector and another vector.
     *
     * @param vector The vector to calculate the dot product with.
     * @return The dot product of the two vectors.
     */
    public double dotProduct(Vector vector){
        return this.x * vector.x + this.y * vector.y;
    }

    /**
     * Calculates the distance between two vectors using the Pythagorean theorem.
     *
     * @param a The first vector.
     * @param b The second vector.
     * @return The distance between the two vectors.
     */
    public static double distance(Vector a, Vector b){
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    /**
     * Calculates the angle (in radians) between the vector and the positive x-axis.
     *
     * @return The angle of the vector in radians.
     * @see <a href="https://en.wikipedia.org/wiki/Atan2#/media/File:Atan2definition.svg">Atan2 definition</a>
     */
    public double angle() {
        return Math.atan2(y, x);
    }

    /**
     * Normalizes the angle of the vector to a range between -1 and 1.
     *
     * @return The normalized angle of the vector.
     */
    public float normalizedAngle() {
        return (float) angle() / 180;
    }

}
