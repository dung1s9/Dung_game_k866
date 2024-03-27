package com.dung.gameObject;

import com.dung.effect.Animation;
import com.dung.effect.CacheDataLoader;

import java.awt.*;

public class RocketBullet extends Bullet{
    private Animation forwardBulletAnimUp, forwardBulletAnimDown, forwardBulletAnim;
    private Animation backBulletAnimUp, backBulletAnimDown, backBulletAnim;

    private long startTimeForChangeSpeedY;

    public RocketBullet(float x, float y, GameWord gameWorld) {

        super(x, y, 30, 30, 1.0f, 10, gameWorld);

        backBulletAnimUp = CacheDataLoader.getInstance().getAnimation("rocketUp");
        backBulletAnimDown = CacheDataLoader.getInstance().getAnimation("rocketDown");
        backBulletAnim = CacheDataLoader.getInstance().getAnimation("rocket");

        forwardBulletAnimUp = CacheDataLoader.getInstance().getAnimation("rocketUp");
        forwardBulletAnimUp.flipAllImage();
        forwardBulletAnimDown = CacheDataLoader.getInstance().getAnimation("rocketDown");
        forwardBulletAnimDown.flipAllImage();
        forwardBulletAnim = CacheDataLoader.getInstance().getAnimation("rocket");
        forwardBulletAnim.flipAllImage();

    }

    @Override
    public Rectangle getBoundForCollisionWithEnemy() {
        return getBoundForCollisionWithMap();
    }

    @Override
    public void draw(Graphics2D g2) {
        if(getSpeedX() > 0){
            if(getSpeedY() > 0){
                forwardBulletAnimDown.draw((int) (getPosX() - getGameWord().C1.getPosX()), (int) getPosY() - (int) getGameWord().C1.getPosY(), g2);
            }else if(getSpeedY() < 0){
                forwardBulletAnimUp.draw((int) (getPosX() - getGameWord().C1.getPosX()), (int) getPosY() - (int) getGameWord().C1.getPosY(), g2);
            }else
                forwardBulletAnim.draw((int) (getPosX() - getGameWord().C1.getPosX()), (int) getPosY() - (int) getGameWord().C1.getPosY(), g2);
        }else{
            if(getSpeedY() > 0){
                backBulletAnimDown.draw((int) (getPosX() - getGameWord().C1.getPosX()), (int) getPosY() - (int) getGameWord().C1.getPosY(), g2);
            }else if(getSpeedY() < 0){
                backBulletAnimUp.draw((int) (getPosX() - getGameWord().C1.getPosX()), (int) getPosY() - (int) getGameWord().C1.getPosY(), g2);
            }else
                backBulletAnim.draw((int) (getPosX() - getGameWord().C1.getPosX()), (int) getPosY() - (int) getGameWord().C1.getPosY(), g2);
        }
        //drawBoundForCollisionWithEnemy(g2);
    }

    private void changeSpeedY(){
        if(System.currentTimeMillis() % 3 == 0){
            setSpeedY(getSpeedX());
        }else if(System.currentTimeMillis() % 3 == 1){
            setSpeedY(-getSpeedX());
        }else {
            setSpeedY(0);

        }
    }

    @Override
    public void Update() {
        super.Update();

        if(System.nanoTime() - startTimeForChangeSpeedY > 500*1000000){
            startTimeForChangeSpeedY = System.nanoTime();
            changeSpeedY();
        }
    }

    @Override
    public void Attack() {}
}
