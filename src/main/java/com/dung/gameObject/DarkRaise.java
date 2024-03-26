package com.dung.gameObject;

import com.dung.effect.Animation;
import com.dung.effect.CacheDataLoader;

import java.awt.*;

public class DarkRaise extends ParticularObject{

    private Animation forwardAnim, backAnim;

    private long startTimeToShoot;
    private float x1, x2;

    public DarkRaise(float x, float y, GameWord gameWorld) {
        super(x, y, 127, 89, 0, 100, gameWorld);
        backAnim = CacheDataLoader.getInstance().getAnimation("darkraise");
        forwardAnim = CacheDataLoader.getInstance().getAnimation("darkraise");
        forwardAnim.flipAllImage();
        startTimeToShoot = 0;
        setTimeNobeHurt(300000000);

        x1 = x - 100;
        x2 = x + 100;
        setSpeedX(1);

        setDamage(10);
    }

    @Override
    public void Attack() {

        float megaManX = getGameWord().C1.getPosX();
        float megaManY = getGameWord().C1.getPosY();

        float deltaX = megaManX - getPosX();
        float deltaY = megaManY - getPosY();

        float speed = 3;
        float a = Math.abs(deltaX/deltaY);

        float speedX = (float) Math.sqrt(speed*speed*a*a/(a*a + 1));
        float speedY = (float) Math.sqrt(speed*speed/(a*a + 1));



        Bullet bullet = new DarkRaiseBullet(getPosX(), getPosY(), getGameWord());

        if(deltaX < 0)
            bullet.setSpeedX(-speedX);
        else bullet.setSpeedX(speedX);
        bullet.setSpeedY(speedY);
        bullet.setTypeTeam(getTypeTeam());
        getGameWord().bulletManager.addObject(bullet);

    }


    public void Update(){
        super.Update();
        if(getPosX() < x1)
            setSpeedX(1);
        else if(getPosX() > x2)
            setSpeedX(-1);
        setPosX(getPosX() + getSpeedX());

        if(System.nanoTime() - startTimeToShoot > 1000*10000000*1.5){
            Attack();
            startTimeToShoot = System.nanoTime();
        }
    }

    @Override
    public Rectangle getBoundForCollisionWithEnemy() {
        Rectangle rect = getBoundForCollisionWithMap();
        rect.x += 20;
        rect.width -= 40;

        return rect;
    }

    @Override
    public void draw(Graphics2D g2) {
        if(!isObjectOutOfCameraView()){
            if(getState() == NOBEHURT && (System.nanoTime()/10000000)%2!=1){
                // plash...
            }else{
                if(getDirection() == LEFT_DIR){
                    backAnim.update(System.nanoTime());
                    backAnim.draw((int) (getPosX() - getGameWord().C1.getPosX()),
                            (int)(getPosY() - getGameWord().C1.getPosY()), g2);
                }else{
                    forwardAnim.update(System.nanoTime());
                    forwardAnim.draw((int) (getPosX() - getGameWord().C1.getPosX()),
                            (int)(getPosY() - getGameWord().C1.getPosY()), g2);
                }
            }
        }
        //drawBoundForCollisionWithEnemy(g2);
    }
}
