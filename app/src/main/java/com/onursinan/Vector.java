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

    public void add(Vector vector){
        this.x += vector.x;
        this.y += vector.y;
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
