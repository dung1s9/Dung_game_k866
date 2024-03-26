package com.dung.gameObject;

import com.dung.effect.CacheDataLoader;
import com.dung.userinterface.GameFrame;

import java.awt.*;

public class BackGroudMap extends GameObject{

    public int[][] map;
    private int titleSize;

    public BackGroudMap(float posX, float posY, GameWord gameWord) {
        super(posX, posY, gameWord);
        map = CacheDataLoader.getInstance().getBackgroundMap();
        titleSize = 30;
    }

    public void Update(){}

    public void draw(Graphics2D g2){

        camera C2 = getGameWord().C1;

        g2.setColor(Color.RED);
        for(int i = 0;i< map.length;i++)
            for(int j = 0;j<map[0].length;j++)
                if(map[i][j]!=0 && j*titleSize - C2.getPosX() > -30 && j*titleSize - C2.getPosX() < GameFrame.SCREEN_WIDTH
                        && i*titleSize - C2.getPosY() > -30 && i*titleSize - C2.getPosY() < GameFrame.SCREEN_HEIGHT){
                    g2.drawImage(CacheDataLoader.getInstance().getFrameImage("tiled"+map[i][j]).getImage(), (int) getPosX() + j*titleSize - (int) C2.getPosX(),
                            (int) getPosY() + i*titleSize - (int) C2.getPosY(), null);
                }

    }
}
