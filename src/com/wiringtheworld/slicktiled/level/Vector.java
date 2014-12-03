package com.wiringtheworld.slicktiled.level;

/**
 * Created by chris on 03/12/2014.
 */
public class Vector {

    public float x;
    public float y;

    public Vector(float x, float y){
        this.x = x;
        this.y = y;
    }

    public Vector add (Vector v){
        x += v.x;
        y += v.y;
        return this;

    }

    public Vector mult (Vector v){
        x *= v.x;
        y *= v.y;

        return this;
    }

}
