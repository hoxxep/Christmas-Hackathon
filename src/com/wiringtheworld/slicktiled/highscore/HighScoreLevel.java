package com.wiringtheworld.slicktiled.highscore;

import com.wiringtheworld.slicktiled.Game;
import com.wiringtheworld.slicktiled.level.Present;
import com.wiringtheworld.slicktiled.level.Vector;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import java.util.ArrayList;

/**
 * Created by chris on 03/12/2014.
 */
public class HighScoreLevel extends BasicGameState{

    private Highscores highscore = new Highscores();
    private boolean playagain = false;
    long timeSpent = 0;

    public void addScore(Score s){
        highscore.addScore(s);
    }

    public HighScoreLevel(int state) {

    }

    @Override public int getID() {
        return Game.HIGHSCORES;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.drawString("Leaderboards",50,50);
        float y = 70;
        for(Score score : highscore.getScores() ){

            graphics.drawString(score.name,50,y);
            graphics.drawString(Integer.toString(score.score),100,y);

            y += 14;
        }
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        timeSpent += i;
        if (playagain && timeSpent >= 3000) {
            playagain = false;
            timeSpent = 0;
            stateBasedGame.enterState(Game.LEVEL);
        }
    }

    @Override
    public void keyPressed(int i, char c) {
        if (timeSpent >= 3000) playagain = true;
    }
}



