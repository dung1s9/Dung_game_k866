package com.dung.gameObject;

import com.dung.effect.CacheDataLoader;
import com.dung.effect.FrameImage;
import com.dung.userinterface.GameFrame;

import java.applet.AudioClip;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameWord {

    private BufferedImage bufferedImage;
    public Megaman megaman;
    public PhysicalMap physicalMap;
    public BulletManager bulletManager;
    public BackGroudMap backGroudMap;
    public PacticularObjectManager pacticularObjectManager;
    public camera C1;
    public AudioClip bgMusic;

    public static final int finalBossX = 3600;

    public static final int PAUSEGAME = 0;
    public static final int TUTORIAL = 1;
    public static final int GAMEPLAY = 2;
    public static final int GAMEOVER = 3;
    public static final int GAMEWIN = 4;
    public static final int INTROGAME = 0;
    public static final int MEETFINALBOSS = 1;
    public int openIntroGameY = 0;
    public int state = PAUSEGAME;
    public int previousState = state;
    public int tutorialState = INTROGAME;
    public int storyTutorial = 0;
    public String[] textD = new String[6];

    public String textTutorial;
    public int currentSize = 1;

    private boolean finalbossTrigger = true;
    public ParticularObject boss;
    FrameImage avatar = CacheDataLoader.getInstance().getFrameImage("avatar");
    private int numberOfLife = 3;


    public void update(){

        switch(state){

            case TUTORIAL:
                TutorialUpdate();

                break;
            case GAMEPLAY:
                pacticularObjectManager.UpdateObjects();
                bulletManager.UpdateObjects();
                physicalMap.Update();
                C1.Update();

                if(megaman.getPosX() > finalBossX && finalbossTrigger){
                    finalbossTrigger = false;
                    switchState(TUTORIAL);
                    tutorialState = MEETFINALBOSS;
                    storyTutorial = 0;
                    openIntroGameY = 550;

                    boss = new FinalBoss(finalBossX + 700, 460, this);
                    boss.setTypeTeam(ParticularObject.ENEMY_TEAM);
                    boss.setDirection(ParticularObject.LEFT_DIR);
                    pacticularObjectManager.addObject(boss);

                }

                if(megaman.getState() == ParticularObject.DEATH){
                    numberOfLife --;
                    if(numberOfLife >= 0){
                        megaman.setBlood(100);
                        megaman.setPosY(megaman.getPosY() - 50);
                        megaman.setState(ParticularObject.NOBEHURT);
                        pacticularObjectManager.addObject(megaman);
                    }else{
                        switchState(GAMEOVER);
                        bgMusic.stop();
                    }
                }
                if(!finalbossTrigger && boss.getState() == ParticularObject.DEATH)
                    switchState(GAMEWIN);

                break;
            case GAMEOVER:

                break;
            case GAMEWIN:

                break;
        }

    }

    public GameWord() {

        textD[0] = "Dũng pro hiện tại sẽ tham gia một chuyến phiêu lưu";
        textD[1] = "mn chú ý....";
        textD[2] = "Hiện tại đây là một trò chơi được thiết kế bởi coder ";
        textD[3] = "Trương việt Dũng sau một quá trình học tập và thực hành....";
        textD[4] = "và hiện tại hãy cùng tôi tham gia vào chuyến phiêu lưu này!....";
        textD[5] = "LET'S GO!.....";
        textTutorial = textD[0];

        megaman = new Megaman(300, 300, this);
        megaman.setTypeTeam(ParticularObject.LEAGUE_TEAM);
        physicalMap = new PhysicalMap(0, 0, this);
        C1 = new camera(0, 0, this, GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT);
        bulletManager = new BulletManager(this);
        backGroudMap = new BackGroudMap(0, 0, this);
        pacticularObjectManager = new PacticularObjectManager(this);
        pacticularObjectManager.addObject(megaman);

        bgMusic = CacheDataLoader.getInstance().getSound("bgmusic");
        intEnemy();
    }

    private void intEnemy(){

        ParticularObject red = new RedDemon(1700, 460, this);
        red.setDirection(ParticularObject.RIGHT_DIR);
        red.setTypeTeam(ParticularObject.ENEMY_TEAM);
        pacticularObjectManager.addObject(red);

        ParticularObject darkraise = new DarkRaise(2000, 200, this);
        darkraise.setTypeTeam(ParticularObject.ENEMY_TEAM);
        pacticularObjectManager.addObject(darkraise);

        ParticularObject darkraise2 = new DarkRaise(2900, 350, this);
        darkraise2.setTypeTeam(ParticularObject.ENEMY_TEAM);
        pacticularObjectManager.addObject(darkraise2);

        ParticularObject darkraise3 = new DarkRaise(2000, 980, this);
        darkraise3.setTypeTeam(ParticularObject.ENEMY_TEAM);
        pacticularObjectManager.addObject(darkraise3);

        ParticularObject darkraise4 = new DarkRaise(800, 350, this);
        darkraise4.setTypeTeam(ParticularObject.ENEMY_TEAM);
        pacticularObjectManager.addObject(darkraise4);


        ParticularObject red1 = new RedDemon(1000, 1250, this);
        red1.setDirection(ParticularObject.LEFT_DIR);
        red1.setTypeTeam(ParticularObject.ENEMY_TEAM);
        pacticularObjectManager.addObject(red1);

        ParticularObject red2 = new RedDemon(2500, 500, this);
        red2.setDirection(ParticularObject.LEFT_DIR);
        red2.setTypeTeam(ParticularObject.ENEMY_TEAM);
        pacticularObjectManager.addObject(red2);

        ParticularObject red3 = new RedDemon(3400, 500, this);
        red3.setDirection(ParticularObject.LEFT_DIR);
        red3.setTypeTeam(ParticularObject.ENEMY_TEAM);
        pacticularObjectManager.addObject(red3);

        ParticularObject red4 = new RedDemon(500, 1190, this);
        red4.setDirection(ParticularObject.RIGHT_DIR);
        red4.setTypeTeam(ParticularObject.ENEMY_TEAM);
        pacticularObjectManager.addObject(red4);

        ParticularObject red5 = new RedDemon(1700, 1220, this);
        red5.setDirection(ParticularObject.LEFT_DIR);
        red5.setTypeTeam(ParticularObject.ENEMY_TEAM);
        pacticularObjectManager.addObject(red5);

        ParticularObject red6 = new RedDemon(1250, 407, this);
        red6.setDirection(ParticularObject.LEFT_DIR);
        red6.setTypeTeam(ParticularObject.ENEMY_TEAM);
        pacticularObjectManager.addObject(red6);


    }

    public void switchState(int state){
        previousState = this.state;
        this.state = state;
    }

    private void TutorialUpdate(){
        switch(tutorialState){
            case INTROGAME:

                if(storyTutorial == 0){
                    if(openIntroGameY < 450) {
                        openIntroGameY+=4;
                    }else storyTutorial ++;

                }else{

                    if(currentSize < textTutorial.length()) currentSize++;
                }
                break;
            case MEETFINALBOSS:
                if(storyTutorial == 0){
                    if(openIntroGameY >= 450) {
                        openIntroGameY-=1;
                    }
                    if(C1.getPosX() < finalBossX){
                        C1.setPosX(C1.getPosX() + 2);
                    }

                    if(megaman.getPosX() < finalBossX + 150){
                        megaman.setDirection(ParticularObject.RIGHT_DIR);
                        megaman.run();
                        megaman.Update();
                    }else{
                        megaman.stopRun();
                    }

                    if(openIntroGameY < 450 && C1.getPosX() >= finalBossX && megaman.getPosX() >= finalBossX + 150){
                        C1.lock();
                        storyTutorial++;
                        megaman.stopRun();
                        physicalMap.phys_map[14][120] = 1;
                        physicalMap.phys_map[15][120] = 1;
                        physicalMap.phys_map[16][120] = 1;
                        physicalMap.phys_map[17][120] = 1;

                        backGroudMap.map[14][120] = 17;
                        backGroudMap.map[15][120] = 17;
                        backGroudMap.map[16][120] = 17;
                        backGroudMap.map[17][120] = 17;
                    }

                }else{

                    if(currentSize < textTutorial.length()) currentSize++;
                }
                break;
        }
    }

    private void drawString(Graphics2D g2, String text, int x, int y){
        for(String str : text.split("\n"))
            g2.drawString(str, x, y+=g2.getFontMetrics().getHeight());
    }

    private void TutorialRender(Graphics2D g2){
        switch(tutorialState){
            case INTROGAME:
                int yMid = GameFrame.SCREEN_HEIGHT/2 - 15;
                int y1 = yMid - GameFrame.SCREEN_HEIGHT/2 - openIntroGameY/2;
                int y2 = yMid + openIntroGameY/2;

                g2.setColor(Color.BLACK);
                g2.fillRect(0, y1, GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT/2);
                g2.fillRect(0, y2, GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT/2);

                if(storyTutorial >= 1){
                    g2.drawImage(avatar.getImage(), 600, 350, null);
                    g2.setColor(Color.BLUE);
                    g2.fillRect(280, 450, 350, 80);
                    g2.setColor(Color.WHITE);
                    String text = textTutorial.substring(0, currentSize - 1);
                    drawString(g2, text, 290, 480);
                }

                break;
            case MEETFINALBOSS:
                yMid = GameFrame.SCREEN_HEIGHT/2 - 15;
                y1 = yMid - GameFrame.SCREEN_HEIGHT/2 - openIntroGameY/2;
                y2 = yMid + openIntroGameY/2;

                g2.setColor(Color.BLACK);
                g2.fillRect(0, y1, GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT/2);
                g2.fillRect(0, y2, GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT/2);
                break;
        }
    }



    public void Render(Graphics2D g2){

        if(g2!=null){

            switch(state){
                case PAUSEGAME:
                    g2.setColor(Color.black);
                    g2.fillRect(0, 0, GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT);
                    g2.setColor(Color.WHITE);
                    g2.drawString("PRESS ENTER TO CONTINUE", 400, 300);
                    break;
                case TUTORIAL:
                    backGroudMap.draw(g2);
                    if(tutorialState == MEETFINALBOSS){
                        pacticularObjectManager.draw(g2);
                    }
                    TutorialRender(g2);

                    break;
                case GAMEWIN:
                case GAMEPLAY:
                    backGroudMap.draw(g2);
                    pacticularObjectManager.draw(g2);
                    bulletManager.draw(g2);

                    g2.setColor(Color.GRAY);
                    g2.fillRect(19, 59, 102, 22);
                    g2.setColor(Color.red);
                    g2.fillRect(20, 60, megaman.getBlood(), 20);

                    for(int i = 0; i < numberOfLife; i++){
                        g2.drawImage(CacheDataLoader.getInstance().getFrameImage("hearth").getImage(), 20 + i*40, 18, null);
                    }


                    if(state == GAMEWIN){
                        g2.drawImage(CacheDataLoader.getInstance().getFrameImage("gamewin").getImage(), 300, 300, null);
                    }

                    break;
                case GAMEOVER:
                    g2.setColor(Color.BLACK);
                    g2.fillRect(0, 0, GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT);
                    g2.setColor(Color.WHITE);
                    g2.drawString("GAME OVER!", 450, 300);
                    break;

            }
        }

    }

}
