package com.wiringtheworld.slicktiled.level;

import com.wiringtheworld.slicktiled.Game;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Created by hyun-hoshin on 03/12/14.
 */
public class Chimney {
    public Vector pos;

    public static Image chimneyImage;

    public Chimney(int x, int y){
        pos = new Vector(x, y);
    }

    public static void loadImages() throws SlickException {
        presentImage = new Image(Game.RESOURCE + "Santa_in_a_chimney.png");
    }

    public boolean checkSuccess(Present present){
        return (pos.x <= present.pos.x && (present.pos.x + present.width()) <= (pos.x + width()) && pos.y >= (present.pos.y + present.width()));
    }

    public boolean checkBounce(Present present){
        return ((present.pos.x < pos.x && (present.pos.x + present.width() > pos.x) || (present.pos.x < pos.x + width()) && ((present.pos.x + present.width()) > (pos.x + width())) && (present.pos.y + present.height()) <= pos.y));
    }

    public int width(){
        return chimneyImage.getWidth();
    }
}
