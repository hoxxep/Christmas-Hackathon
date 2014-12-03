package com.wiringtheworld.slicktiled.level;

import com.wiringtheworld.slicktiled.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import java.lang.Math;

public class Level extends BasicGameState {

    static final Vector G = new Vector(0F,9.81F * (1E-4F));
    static final Vector RES = new Vector(0.99F,1F);

    Present present;

    public Level(int state) {

    }

    @Override
    public int getID() {
        return Game.LEVEL;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        Present.loadImages();
        present = new Present(new Vector(0,0), new Vector((float) 0,0));
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        present.render(graphics);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        present.update(i);
    }
}
