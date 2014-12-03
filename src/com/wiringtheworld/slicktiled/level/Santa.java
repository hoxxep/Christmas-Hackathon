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

    static Image santaImage;

    public Santa() {

    }

    public static void loadImages() throws SlickException {
        santaImage = new Image(Game.RESOURCE + "santa.png");
    }

    public void update(int i) {

    }

    public void render(Graphics graphics) {
        graphics.drawImage(santaImage, x, 20);
    }
}
