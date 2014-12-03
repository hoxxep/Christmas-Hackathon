package com.wiringtheworld.slicktiled.level;

/**
 * Created by chris on 03/12/2014.
 */
public class Present {



    Vector pos;
    Vector vel;

    public Present(Vector position, Vector velocity){
        pos = position;
        vel = velocity;

    }

    public void update(int i){
        vel.add(Level.G).mult(Level.RES);
        pos.add(vel);


    }

}
