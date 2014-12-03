package com.wiringtheworld.slicktiled.level;

import com.wiringtheworld.slicktiled.Game;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Chimney {
    public Vector pos;

    public static Image chimneyImage;

    public Chimney(int x, int y){
        pos = new Vector(x, y);
    }

    public static void loadImages() throws SlickException {
        chimneyImage = new Image(Game.RESOURCE + "chimney.png");
    }

    public boolean checkSuccess(Present present){
        return (pos.x <= present.pos.x && (present.pos.x + present.width()) <= (pos.x + width()) && pos.y >= (present.pos.y + present.width()));
    }

    public boolean checkBounce(Present present){
        return ((present.pos.x < pos.x && (present.pos.x + present.width() > pos.x) || (present.pos.x < pos.x + width()) && ((present.pos.x + present.width()) > (pos.x + width())) && (present.pos.y + present.height()) <= pos.y));
    }

    public void update(int i) {

    }

    public void render(Graphics graphics) {
        //graphics.drawImage(chimneyImage, Game.WIDTH/2, Game.HEIGHT - chimneyImage.getHeight());
        graphics.drawImage(chimneyImage, pos.x, pos.y);
    }

    public static int width(){
        return chimneyImage.getWidth();
    }
    public static int height() {
        return chimneyImage.getHeight();
    }
}
