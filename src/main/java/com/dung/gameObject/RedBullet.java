package com.dung.gameObject;

import com.dung.effect.Animation;
import com.dung.effect.CacheDataLoader;

import java.awt.*;

public class RedBullet extends Bullet{

    private Animation ForwarBulletRed, BackBulletRed;

    public RedBullet(float posX, float posY, GameWord gameWord) {
        super(posX, posY, 30, 30, 1.0f, 10, gameWord);
        ForwarBulletRed = CacheDataLoader.getInstance().getAnimation("redeyebullet");
        BackBulletRed = CacheDataLoader.getInstance().getAnimation("redeyebullet");
        BackBulletRed.flipAllImage();
    }

    public Rectangle getBoundForCollisionWithEnemy() {
        // TODO Auto-generated method stub
        return getBoundForCollisionWithMap();
    }

    @Override
    public void draw(Graphics2D g2) {
        if(getSpeedX() > 0){
            ForwarBulletRed.update(System.nanoTime());
            ForwarBulletRed.draw((int) (getPosX() - getGameWord().C1.getPosX()), (int) getPosY() - (int) getGameWord().C1.getPosY(), g2);
        }else{
            BackBulletRed.update(System.nanoTime());
            BackBulletRed.draw((int) (getPosX() - getGameWord().C1.getPosX()), (int) getPosY() - (int) getGameWord().C1.getPosY(), g2);
        }
        //drawBoundForCollisionWithEnemy(g2);
    }

    @Override
    public void Update() {
        super.Update();
    }

    public void Attack() {}



}
