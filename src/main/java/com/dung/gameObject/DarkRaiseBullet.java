package com.dung.gameObject;

import com.dung.effect.Animation;
import com.dung.effect.CacheDataLoader;

import java.awt.*;

public class DarkRaiseBullet extends Bullet{

    private Animation forwardBulletAnim, backBulletAnim;

    public DarkRaiseBullet(float x, float y, GameWord gameWorld) {
        super(x, y, 30, 30, 1.0f, 10, gameWorld);
        forwardBulletAnim = CacheDataLoader.getInstance().getAnimation("darkraisebullet");
        backBulletAnim = CacheDataLoader.getInstance().getAnimation("darkraisebullet");
        backBulletAnim.flipAllImage();
    }



    @Override
    public Rectangle getBoundForCollisionWithEnemy() {
        // TODO Auto-generated method stub
        return getBoundForCollisionWithMap();
    }

    @Override
    public void draw(Graphics2D g2) {
        // TODO Auto-generated method stub
        if(getSpeedX() > 0){
            forwardBulletAnim.update(System.nanoTime());
            forwardBulletAnim.draw((int) (getPosX() - getGameWord().C1.getPosX()), (int) getPosY() - (int) getGameWord().C1.getPosY(), g2);
        }else{
            backBulletAnim.update(System.nanoTime());
            backBulletAnim.draw((int) (getPosX() - getGameWord().C1.getPosX()), (int) getPosY() - (int) getGameWord().C1.getPosY(), g2);
        }
        //drawBoundForCollisionWithEnemy(g2);
    }

    @Override
    public void Update() {
        // TODO Auto-generated method stub
        super.Update();
    }

    @Override
    public void Attack() {}
}
