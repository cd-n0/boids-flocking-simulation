// https://en.wikipedia.org/wiki/Quadtree#QuadTree_class
package com.onursinan;

/*
 * Vec2D
 * // Simple coordinate object to represent points and vectors
 * struct XY
 * {
 *     float x;
 *     float y;
 * 
 *     function __construct(float _x, float _y) {...}
 * }
 * 
 * // Axis-aligned bounding box with half dimension and center
 * struct AABB
 * {
 *     XY center;
 *     float halfDimension;
 * 
 *     function __construct(XY _center, float _halfDimension) {...}
 *     function containsPoint(XY point) {...}
 *     function intersectsAABB(AABB other) {...}
 * }
 */

import java.util.ArrayList;

class QuadTree<T> {
    // Arbitrary constant to indicate how many elements can be stored in this quad tree node
    private final int QT_DEFAULT_NODE_CAPACITY = 4;

    // Axis-aligned bounding box stored as a center with half-dimensions
    // to represent the boundaries of this quad tree
    AABB boundary;

    // Points in this quad tree node
    private final ArrayList<T> points;

    // Children
    QuadTree<T> northWest = null;
    QuadTree<T> northEast = null;
    QuadTree<T> southWest = null;
    QuadTree<T> southEast = null;

    // Methods
    QuadTree(AABB boundary) {
        this.boundary = boundary;
        this.points = new ArrayList<>(QT_DEFAULT_NODE_CAPACITY);
    }
    QuadTree(AABB boundary, int nodeCapacity) {
        this.boundary = boundary;
        this.points = new ArrayList<>(nodeCapacity);
    }
//    function insert(T p) {...}
//    function subdivide() {...} // create four children that fully divide this quad into four quads of equal area
//    function queryRange(AABB range) {...}
}
