package com.onursinan;

import java.awt.geom.Rectangle2D;

/**
 * Represents an axis-aligned bounding box (AABB) in 2D space.
 * 
 * An AABB is defined by its center point and half dimension. It is used in collision detection
 * and spatial partitioning algorithms to efficiently determine the bounds of objects.
 */
public class AABB {
    /**
     * The center point of the AABB.
     */
    Vector center;

    /**
     * Half of the width (or height) of the AABB.
     */
    double halfDimension;

    /**
     * Constructs an AABB with the specified center point and half dimension.
     * 
     * @param center The center point of the AABB.
     * @param halfDimension Half of the width (or height) of the AABB.
     */
    public AABB(Vector center, double halfDimension) {
        this.center = center;
        this.halfDimension = halfDimension;
    }

    /**
     * Checks if the given point lies within the AABB.
     * 
     * @param point The point to check.
     * @return true if the point lies within the AABB, false otherwise.
     */
    public boolean containsPoint(Vector point) {
        // Check if the point lies within the AABB
        return Math.abs(point.x - center.x) <= halfDimension && Math.abs(point.y - center.y) <= halfDimension;
    }

    /**
     * Checks if this AABB intersects with another AABB.
     * 
     * @param other The AABB to check intersection with.
     * @return true if this AABB intersects with the other AABB, false otherwise.
     */
    public boolean intersectsAABB(AABB other) {
        // Check if this AABB intersects with another AABB
        Rectangle2D thisRect
            = new Rectangle2D.Double(center.x - halfDimension,
                    center.y - halfDimension,
                    2 * halfDimension,
                    2 * halfDimension);
        Rectangle2D otherRect
            = new Rectangle2D.Double(other.center.x - other.halfDimension,
                    other.center.y - other.halfDimension,
                    2 * other.halfDimension,
                    2 * other.halfDimension);
        return thisRect.intersects(otherRect);
    }

    public Vector getCenter() {
        return center;
    }

    public void setCenter(Vector center) {
        this.center = center;
    }

    public double getHalfDimension() {
        return halfDimension;
    }

    public void setHalfDimension(double halfDimension) {
        this.halfDimension = halfDimension;
    }
}
