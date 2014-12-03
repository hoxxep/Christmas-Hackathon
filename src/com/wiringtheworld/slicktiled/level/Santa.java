package com.wiringtheworld.slicktiled.level;

import com.wiringtheworld.slicktiled.Game;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Created by liam on 12/3/14.
 */
public class Santa {
    float x;
    float xTime;

    static Image santaImage;

    public Santa() {

    }

    public static void loadImages() throws SlickException {
        santaImage = new Image(Game.RESOURCE + "santa.png");
    }

    public void update(int i) {
        xTime += i;
        float w = (Game.WIDTH - santaImage.getWidth()) / 2;
        x = (int) (Math.sin(2 * Math.PI * xTime / 3000)*w + w);
    }

    public Vector position() {
        return new Vector(x + santaImage.getWidth()/2, 20 + santaImage.getHeight() - 10);
    }

    public Vector velocity() {
        return new Vector((float) Math.cos(2 * Math.PI * xTime / 3000) * 2, 0);
    }

    public void render(Graphics graphics) {
        graphics.drawImage(santaImage, x, 20);
    }
}
