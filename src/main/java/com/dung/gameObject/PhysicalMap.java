package com.dung.gameObject;
import com.dung.effect.CacheDataLoader;

import java.awt.*;

public class PhysicalMap extends GameObject{
    public int[][] phys_map;
    private int titleSize;


    public PhysicalMap(float x, float y, GameWord gameWord) {
        super(x, y, gameWord);
        this.titleSize = 30;
        phys_map = CacheDataLoader.getInstance().getPhysicalMap();
    }

    public int getTitleSize() {
        return titleSize;
    }

    public void draw(Graphics2D g2){

        camera C1 = getGameWord().C1;

        g2.setColor(Color.gray);
        for(int i = 0; i < phys_map.length; i++){
            for(int j = 0; j < phys_map[i].length; j++){
                if(phys_map[i][j]!=0) g2.fillRect((int) getPosX() + j*titleSize - (int) C1.getPosX(),
                        (int) getPosY() + i*titleSize - (int) C1.getPosY(), titleSize, titleSize);
            }
        }
    }

    public Rectangle haveCollisionWithTop(Rectangle rect){

        int posX1 = rect.x/titleSize;
        posX1 -=2;
        int posX2 = (rect.x + rect.width)/titleSize;
        posX2 += 2;

        int posY2 = rect.y/titleSize;

        if(posX1 < 0) posX1 = 0;

        if(posX2 >= phys_map[0].length) posX2 = phys_map[0].length - 1;

        for(int i = posY2; i >= 0; i--){
            for(int j = posX1; j <= posX2; j++){
                if(phys_map[i][j] == 1){
                    Rectangle r = new Rectangle((int) getPosX() + j * titleSize, (int) getPosY() + i * titleSize, titleSize, titleSize ) ;
                    if (rect.intersects(r))
                        return r;
                }
            }
        }

        return null;
    }

    public  Rectangle haveCollisionWithRightWall(Rectangle rect){
        int posY1 = rect.y/titleSize;
        posY1 -=2;
        int posY2 = (rect.y + rect.height)/titleSize;
        posY2 +=2;

        int posX1 = (rect.x + rect.width)/titleSize;
        int posX2 = posX1 + 3;
        if(posX2 >= phys_map[0].length) posX2 = phys_map[0].length -1;

        if(posY1 < 0) posY1 = 0;
        if (posY2 >= phys_map.length) posY2 = phys_map.length - 1;

        for (int i = posX1; i <= posX2; i++){
            for(int j = posY1; j <= posY2; j++){
                if (phys_map[j][i] == 1){
                    Rectangle r = new Rectangle((int) getPosX() + i * titleSize, (int) getPosY() + j * titleSize, (int) titleSize, (int) titleSize);
                    if(r.y < rect.y + rect.height - 1 && rect.intersects(r))
                        return r;
                }
            }
        }

        return null;
    }

    public  Rectangle haveCollisionWithLeftWall(Rectangle rect){
        int posY1 = rect.y/titleSize;
        posY1 -=2;
        int posY2 = (rect.y + rect.height)/titleSize;
        posY2 +=2;

        int posX1 = (rect.x)/titleSize;
        int posX2 = posX1 - 3;
        if(posX2 < 0) posX2 = 0;

        if(posY1 < 0) posY1 = 0;
        if (posY2 >= phys_map.length) posY2 = phys_map.length - 1;

        for (int i = posX1; i >= posX2; i--){
            for(int j = posY1; j <= posY2; j++){
                if (phys_map[j][i] == 1){
                    Rectangle r = new Rectangle((int) getPosX() + i * titleSize, (int) getPosY() + j * titleSize, (int) titleSize, (int) titleSize);
                    if(r.y < rect.y + rect.height - 1 && rect.intersects(r))
                        return r;
                }
            }
        }

        return null;
    }

    public Rectangle haveCollisionWithLand(Rectangle rect){

        int posX1 = rect.x/titleSize;
        posX1 -= 2;
        int posX2 = (rect.x + rect.width)/titleSize;
        posX2 += 2;

        int posY1 = (rect.y + rect.height)/titleSize;

        if(posX1 < 0) posX1 = 0;

        if(posX2 >= phys_map[0].length) posX2 = phys_map[0].length - 1;

        for(int y = posY1; y < phys_map.length; y++){
            for(int x = posX1; x <= posX2; x++){

                if(phys_map[y][x] == 1){
                    Rectangle r = new Rectangle((int) getPosX() + x * titleSize, (int) getPosY() + y * titleSize, titleSize, titleSize);
                    if(rect.intersects(r))
                        return r;
                }
            }
        }
        return null;
    }

    @Override
    public void Update() {}
}
