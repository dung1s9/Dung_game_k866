package com.dung.userinterface;
import com.dung.gameObject.GameWord;
import com.dung.gameObject.Megaman;

import java.awt.event.KeyEvent;

public class InputManager {

    private GameWord gameWord;

    public InputManager(GameWord gameWord) {
        this.gameWord = gameWord;
    }

    public void processKeyPressed(int keyCode) {

        switch (keyCode) {
            case KeyEvent.VK_W:
                gameWord.megaman.jump();
                break;
            case KeyEvent.VK_S:
                gameWord.megaman.dick();
                break;
            case KeyEvent.VK_D:
                gameWord.megaman.setDirection(gameWord.megaman.RIGHT_DIR);
                gameWord.megaman.run();
                break;
            case KeyEvent.VK_A:
                gameWord.megaman.setDirection(gameWord.megaman.LEFT_DIR);
                gameWord.megaman.run();
                break;
            case KeyEvent.VK_J:
                gameWord.megaman.Attack();
                break;
            case KeyEvent.VK_ENTER:
                if(gameWord.state == gameWord.PAUSEGAME){
                    if(gameWord.previousState == gameWord.GAMEPLAY)
                        gameWord.switchState(gameWord.GAMEPLAY);
                    else gameWord.switchState(gameWord.TUTORIAL);

                    gameWord.bgMusic.loop();
                    gameWord.bgMusic.play();
                }
                if(gameWord.state == gameWord.TUTORIAL && gameWord.storyTutorial >= 1){
                    if(gameWord.storyTutorial<=3){
                        gameWord.storyTutorial ++;
                        gameWord.currentSize = 1;
                        gameWord.textTutorial = gameWord.textD[gameWord.storyTutorial-1];
                    }else{
                        gameWord.switchState(gameWord.GAMEPLAY);
                    }

                    // for meeting boss tutorial
                    if(gameWord.tutorialState == gameWord.MEETFINALBOSS){
                        gameWord.switchState(gameWord.GAMEPLAY);
                    }
                }
                break;
        }
    }

    public void processKeyRelease(int KeyCode) {

        switch (KeyCode) {
            case KeyEvent.VK_UP:


                break;
            case KeyEvent.VK_S:
                gameWord.megaman.standUp();
                break;

            case KeyEvent.VK_D:
                if (gameWord.megaman.getSpeedX() > 0)
                    gameWord.megaman.stopRun();
                break;

            case KeyEvent.VK_A:
                if (gameWord.megaman.getSpeedX() < 0)
                    gameWord.megaman.stopRun();
                break;

                case KeyEvent.VK_ENTER:

                break;
        }
    }
}
