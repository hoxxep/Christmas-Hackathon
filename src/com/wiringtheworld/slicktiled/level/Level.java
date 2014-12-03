package com.wiringtheworld.slicktiled.level;

import com.wiringtheworld.slicktiled.Game;
import com.wiringtheworld.slicktiled.highscore.Score;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Level extends BasicGameState {

    static final Vector G = new Vector(0F,2F * (1E-2F));
    static final Vector RES = new Vector(0.995F,1F);

    Present present;
    Santa santa;
    Chimney chimney;

    int presentsLeft;
    int score;

    public Level(int state) {
        presentsLeft = 2; //TODO: change to 10
        score = 0;
    }

    @Override
    public int getID() {
        return Game.LEVEL;
    }

    @Override
    public void init(GameContainer container, StateBasedGame stateBasedGame) throws SlickException {
        Present.loadImages();
        Santa.loadImages();
        Chimney.loadImages();
        //present = new Present(new Vector(0,0), new Vector((float) 0,0));
        santa = new Santa();
        chimney = new Chimney(Game.WIDTH/2, Game.HEIGHT - Chimney.height());

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
        chimney.render(graphics);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        if (present != null) {
            present.update(i);

            if (chimney.checkSuccess(present)) {
                score += 1;
                present = null;
                System.out.println("In!");
            } else if (present.needsDestroyed()) {
                present = null;
            } else if(chimney.checkBounce(present)){
                present.bounce();
                System.out.println("Bounce!");
            }
        } else {
            if (presentsLeft <= 0) {
                Game.highscores.addScore(new Score("test", score));
                score = 0;
                presentsLeft = 10;
                stateBasedGame.enterState(Game.HIGHSCORES);
            }
        }
        chimney.update(i);
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
