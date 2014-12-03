package com.wiringtheworld.slicktiled.highscore;

/**
 * Created by chris on 03/12/2014.
 */
public class Score implements Comparable<Score>{

    public String name;
    public int score;

    public Score (String n, int s){
        name = n;
        score = s;

    }

    public int compareTo(Score s){
        if (score == s.score){
                return name.compareTo(s.name);
        }
        return score -s.score;

        }


}
