package com.wiringtheworld.slicktiled.highscore;
import java.util.*;
/**
 * Created by chris on 03/12/2014.
 */
public class Highscores {

    private ArrayList<Score> scores = new ArrayList<Score>();

    public void addScore(Score s){
        scores.add(s);
    }

    public ArrayList<Score> getScores(){

        Collections.sort(scores);
        return scores;


    }



}
