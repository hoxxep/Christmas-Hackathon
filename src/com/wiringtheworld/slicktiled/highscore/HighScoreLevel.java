package com.wiringtheworld.slicktiled.highscore;

import com.wiringtheworld.slicktiled.Game;
import com.wiringtheworld.slicktiled.level.Present;
import com.wiringtheworld.slicktiled.level.Vector;
import org.newdawn.slick.*;
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

    private boolean isEnteringName;
    private Score newScore;

    public void addScore(int score){
        ArrayList<Score> scores = highscore.getScores();
        if (scores.size() < Highscores.SCORE_LIMIT || score >= scores.get(scores.size() - 1).score) {
            isEnteringName = true;
            newScore = new Score("", score);
        }
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
        if (isEnteringName) {
            graphics.drawString("Enter your name?", 50, 50);
            graphics.drawString(newScore.name + "|", 50, 67);
        } else {
            graphics.drawString("Leaderboards",50,50);
            graphics.drawString("Press any key to play again!",50,350);
            float y = 70;
            for(Score score : highscore.getScores() ){

                graphics.drawString(score.name,50,y);
                graphics.drawString(Integer.toString(score.score),200,y);

                y += 14;
            }
        }

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        if (!isEnteringName) timeSpent += i;
        if (playagain) {
            playagain = false;
            timeSpent = 0;
            stateBasedGame.enterState(Game.LEVEL);
        }
    }

    @Override
    public void keyPressed(int i, char c) {
        //System.out.println(i);
        if (isEnteringName) {
            if (i == 14 && !newScore.name.isEmpty()) {
                newScore.name = newScore.name.substring(0, newScore.name.length() - 1);
            }
            if (i == 28) {
                isEnteringName = false;
                highscore.addScore(newScore);
            }
            if (Character.toString(c).matches("[0-9A-Za-z_\\- ]") && newScore.name.length() < 15) {
                newScore.name += c;
            }
        } else if (timeSpent >= 3000) playagain = true;
    }
}



