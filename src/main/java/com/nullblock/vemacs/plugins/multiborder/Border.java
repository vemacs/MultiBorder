package com.nullblock.vemacs.plugins.multiborder;

import org.bukkit.Location;

public class Border {

    private int radius;
    private Location center;
    Shape shape;
    Blend blend;

    public enum Shape {
        SQUARE, CIRCLE
    }

    public enum Blend {
        ADD, SUBTRACT
    }

    public Border (int radius, Location center, String world, Shape shape, Blend blend) {
        this.radius = radius;
        this.center = center;
        this.shape = shape;
        this.blend = blend;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Location getCenter() {
        return center;
    }

    public void setCenter(Location center) {
        this.center = center;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public Blend getBlend() {
        return blend;
    }

    public void setBlend(Blend blend) {
        // will it blend?
        this.blend = blend;
    }

    public boolean contains(Location pl) {
        // keeping Blends here, will implement later
            if (shape.equals(Shape.CIRCLE) && pl.distance(center) >= radius) {
                if (blend.equals(Blend.ADD)) {
                    return true;
                }
                if (blend.equals(Blend.SUBTRACT)) {
                    return false;
                }
            }
            if (shape.equals(Shape.SQUARE) && Math.abs(pl.getBlockX() - center.getBlockX()) >= radius && Math.abs(pl.getBlockZ() - center.getBlockZ()) >= radius) {
                if (blend.equals(Blend.ADD)) {
                    return true;
                }
                if (blend.equals(Blend.SUBTRACT)) {
                    return false;
                }
            }
        return false;
    }

}
