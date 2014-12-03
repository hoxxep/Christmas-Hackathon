package com.wiringtheworld.slicktiled.level;

import com.wiringtheworld.slicktiled.Game;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Level extends BasicGameState {

    static final Vector G = new Vector(0F,2F * (1E-2F));
    static final Vector RES = new Vector(0.995F,1F);

    Present present;
    Santa santa;

    int presentsLeft;

    public Level(int state) {
        presentsLeft = 10;
    }

    @Override
    public int getID() {
        return Game.LEVEL;
    }

    @Override
    public void init(GameContainer container, StateBasedGame stateBasedGame) throws SlickException {
        Present.loadImages();
        Santa.loadImages();
        //present = new Present(new Vector(0,0), new Vector((float) 0,0));
        santa = new Santa();

        container.setMaximumLogicUpdateInterval(8);
        container.setAlwaysRender(true);

        container.setVSync(true);
        container.setTargetFrameRate(60); //Display.getDisplayMode().getFrequency());
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        if (present != null)
            present.render(graphics);
        santa.render(graphics);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        if (present != null) {
            present.update(i);
            if (present.needsDestroyed()) {
                present = null;
            }
        }
        santa.update(i);
    }

    @Override
    public void keyPressed(int i, char c) {
        if (present == null && presentsLeft > 0) {
            present = new Present(santa.position(), santa.velocity());
            presentsLeft--;
        }
    }
}
