package com.wiringtheworld.slicktiled.level;

import com.wiringtheworld.slicktiled.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import java.lang.Math;

public class Level extends BasicGameState {

    static final Vector G = new Vector(0F,9.81F);
    static final Vector RES = new Vector(0.99F,1F);

    private double helloWorldMillis = 0;
    private int helloWorldx = 0;

    private int santaXPos;
    private int santaXTime;

    public Level(int state) {

    }

    @Override
    public int getID() {
        return Game.LEVEL;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        santaXPos = 0;

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.drawString("Hello world!", helloWorldx, 400);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        helloWorldMillis += i;
        helloWorldx = (int) ((Math.sin(2 * Math.PI * (helloWorldMillis/1000.0)) + 1)*50 + 300);
        santaXTime += i;
        santaXPos = santaXTime / 100;
    }
}
