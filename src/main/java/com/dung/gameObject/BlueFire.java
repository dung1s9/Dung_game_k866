package com.dung.gameObject;

import com.dung.effect.Animation;
import com.dung.effect.CacheDataLoader;

import java.awt.*;

public class BlueFire extends Bullet{

    private Animation ForwarBulletBlue, BackBulletBlue;

    public BlueFire(float posX, float posY,GameWord gameWord) {
        super(posX, posY, 60, 30, 1.0f, 10, gameWord);
        ForwarBulletBlue = CacheDataLoader.getInstance().getAnimation("bluefire");
        BackBulletBlue = CacheDataLoader.getInstance().getAnimation("bluefire");
        BackBulletBlue.flipAllImage();

    }

    public Rectangle getBoundForCollisionWithEnemy(){
        return getBoundForCollisionWithMap();
    }

    public void draw(Graphics2D g2){
        if(getSpeedX() > 0){
            if(!ForwarBulletBlue.isIgnoreFrame(0) && ForwarBulletBlue.getCurrentFrame() ==3){
                ForwarBulletBlue.setIgnoreFrame(0);
                ForwarBulletBlue.setIgnoreFrame(1);
                ForwarBulletBlue.setIgnoreFrame(2);
            }

            ForwarBulletBlue.update(System.nanoTime());
            ForwarBulletBlue.draw((int) (getPosX() - getGameWord().C1.getPosX()), (int) (getPosY() - getGameWord().C1.getPosY()), g2);
            }
            else {
                if (!BackBulletBlue.isIgnoreFrame(0) && BackBulletBlue.getCurrentFrame() == 3){
                    BackBulletBlue.setIgnoreFrame(0);
                    BackBulletBlue.setIgnoreFrame(1);
                    BackBulletBlue.setIgnoreFrame(2);
                }

                BackBulletBlue.update(System.nanoTime());
                BackBulletBlue.draw((int) (getPosX() - getGameWord().C1.getPosX()), (int) (getPosY() - getGameWord().C1.getPosY()), g2);

            }
        }

    public void update(){
        if(ForwarBulletBlue.isIgnoreFrame(0) || BackBulletBlue.isIgnoreFrame(0) ){
            setPosX(getPosX() + getSpeedX());
        }
    }

    public void Attack() {

    }
}
