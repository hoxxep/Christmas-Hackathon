package com.wiringtheworld.slicktiled.level;

import com.wiringtheworld.slicktiled.Game;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Created by chris on 03/12/2014.
 */
public class Present {

    Vector pos;
    Vector vel;

    public static Image presentImage;

    public Present(Vector position, Vector velocity){
        pos = position;
        vel = velocity;
    }

    public static void loadImages() throws SlickException {
        presentImage = new Image(Game.RESOURCE + "present-red-small.png");
    }

    public void update(int i){
        vel.add(Level.G).mult(Level.RES);
        pos.add(vel);
    }

    public void render(Graphics graphics) {
        graphics.drawImage(presentImage, pos.x, pos.y);
    }

    public boolean needsDestroyed() {
        return (pos.y > Game.HEIGHT);
    }

    public int width(){
        return presentImage.getWidth();
    }

    public int height(){
        return presentImage.getHeight();
    }

    public void bounce(){
        vel.y = -(vel.y / 1.5f);
    }
}
