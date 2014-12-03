package com.wiringtheworld.slicktiled.highscore;
import java.util.*;

/**
 * Created by chris on 03/12/2014.
 */
public class Highscores {

    private ArrayList<Score> scores = new ArrayList<Score>();

    static final int SCORE_LIMIT = 5;

    public void addScore(Score s){
        scores.add(s);
        Collections.sort(scores);
        if (scores.size() > SCORE_LIMIT){
            scores.remove(scores.size() -1);
        }
    }

    public ArrayList<Score> getScores(){
        return scores;
    }

}
