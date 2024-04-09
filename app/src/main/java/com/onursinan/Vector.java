package com.onursinan;

import java.lang.Math;

// TODO: Comprehensive comments & comments to Javadoc
public class Vector {

    public double x;
    public double y;

    public Vector() {
        this(0, 0);
    }

    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double magnitude() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }

    public void normalize() {
        double magnitude = magnitude();
        if (magnitude != 0) {
            x /= magnitude;
            y /= magnitude;
        }
    }

    public void limit(double limit){
        double magnitude = this.magnitude();
        if (magnitude > limit){
            this.x *= limit / magnitude;
            this.y *= limit / magnitude;
        }
    }

    public void add(Vector vector){
        this.x += vector.x;
        this.y += vector.y;
    }

    public void sub(Vector vector){
        this.x -= vector.x;
        this.y -= vector.y;
    }

    public void div(double value){
        this.x /= value;
        this.y /= value;
    }

    // Pythagorean theorem
    public static double distance(Vector a, Vector b){
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    // https://en.wikipedia.org/wiki/Atan2#/media/File:Atan2definition.svg
    // Confined to (-180, 180]
    public double angle() {
        return Math.atan2(y, x);
    }

    // Normalization of the angle
    // Confined to (-1, 1]
    public float normalizedAngle() {
        return (float) angle() / 180;
    }

}
