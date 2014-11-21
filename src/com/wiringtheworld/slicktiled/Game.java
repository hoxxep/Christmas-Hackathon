package com.wiringtheworld.slicktiled;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame {
    public Game(String name) {
        super(name);
    }

    public static void main(String args[]) {
        System.out.println("Wooop!");
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {

    }
}
