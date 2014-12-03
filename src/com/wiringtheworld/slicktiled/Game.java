package com.wiringtheworld.slicktiled;

import com.wiringtheworld.slicktiled.highscore.HighScoreLevel;
import com.wiringtheworld.slicktiled.level.Level;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.CanvasGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Game extends StateBasedGame {
    public static int WIDTH = 800;
    public static int HEIGHT = 600;
    public static final boolean FULLSCREEN = false;

    public static final String TITLE = "Santa Claus";
    public static final String RESOURCE = "res/";

    // States list
    public static final int LEVEL = 0;
    public static final int HIGHSCORES = 1;

    public static HighScoreLevel highscores;

    public Game(String name) {
        super(name);
        this.addState(new Level(LEVEL));
        this.addState(highscores = new HighScoreLevel(HIGHSCORES));
    }

    public static void main(String args[]) {
        try {
            Game game = new Game(TITLE);
            CanvasGameContainer container = new CanvasGameContainer(game);

            Frame frame = new Frame(TITLE);
            frame.setLayout(new GridLayout(1,2));

            if(!FULLSCREEN) {
                frame.setSize(WIDTH,HEIGHT);
            } else {
                frame.setExtendedState(Frame.MAXIMIZED_BOTH);
                frame.setUndecorated(true);
                frame.setResizable(false);
                //frame.setSize(Display.getWidth(), Display.getHeight());
            }

            frame.add(container);
            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    Display.destroy();

                    System.out.println("Exiting " + TITLE + "...");
                    System.exit(0);
                }
            });
            frame.setVisible(true);

            container.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        this.enterState(LEVEL);
        //this.enterState(HIGHSCORES);
    }
}
