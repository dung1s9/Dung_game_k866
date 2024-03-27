package com.dung.userinterface;

import com.dung.effect.Animation;
import com.dung.effect.CacheDataLoader;
import com.dung.effect.FrameImage;
import com.dung.gameObject.GameWord;
import com.dung.gameObject.Megaman;
import com.dung.gameObject.PhysicalMap;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel implements Runnable, KeyListener {

    private Thread thread;
    private boolean isRunning;
    private InputManager inputManager;
    private BufferedImage bufImage;
    private Graphics2D buffG2D;
    public GameWord gameWord;


    public GamePanel(){

        gameWord = new GameWord();
        inputManager = new InputManager(gameWord);
        bufImage = new BufferedImage(GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);

    }

    @Override
    public void paint(Graphics g){

        g.drawImage(bufImage, 0, 0, this);
    }

    public void GameUpdate(){
        gameWord.update();
    }

    public void RenderGame(){
        if (bufImage == null)
            bufImage = new BufferedImage(GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        else {
            buffG2D = (Graphics2D) bufImage.getGraphics();
            gameWord.Render(buffG2D);
        }
    }

    public void starGame(){
        if (thread == null){
            isRunning = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    @Override
    public void run() {

        long FPS = 80;
        long period = 1000*1000000/FPS;
        long beginTime;
        long sleepTime;

        beginTime = System.nanoTime();
        while (isRunning){

//            System.out.println("d = " + (d++));
            //update
            GameUpdate();
            RenderGame();
            repaint();

            long deltaTime = System.nanoTime() - beginTime;
            sleepTime = period - deltaTime;

            try {
                if(sleepTime > 0) Thread.sleep(sleepTime/1000000);
                else Thread.sleep(period/2000000);
            } catch (InterruptedException e) {}

            beginTime = System.nanoTime();

        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

       inputManager.processKeyPressed(e.getKeyCode());
    }


    @Override
    public void keyReleased(KeyEvent e) {
        inputManager.processKeyRelease(e.getKeyCode());
    }
}
