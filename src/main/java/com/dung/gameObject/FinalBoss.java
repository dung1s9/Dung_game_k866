package com.dung.gameObject;

import com.dung.effect.Animation;
import com.dung.effect.CacheDataLoader;

import java.awt.*;
import java.util.Hashtable;

public class FinalBoss extends Human{
    private Animation idleforward, idleback; // Boss đứng im
    private Animation shootingforward, shootingback; // Boss nhả đạn
    private Animation slideforward, slideback; // Boss trượt
    private long StarTimeForAttack;
    private Hashtable<String, Long> TimeAttack = new Hashtable<String, Long>();
    private String[] TypeAttack = new String[4];
    private int AttackIndex = 0;
    private long LastAttackTime;

    public FinalBoss(float posX, float posY, GameWord gameWord) {
        super(posX, posY, 110, 150, 0.1f, 200, gameWord);
        idleback = CacheDataLoader.getInstance().getAnimation("boss_idle");
        idleforward = CacheDataLoader.getInstance().getAnimation("boss_idle");
        idleforward.flipAllImage();

        shootingback = CacheDataLoader.getInstance().getAnimation("boss_shooting");
        shootingforward = CacheDataLoader.getInstance().getAnimation("boss_shooting");
        shootingforward.flipAllImage();

        slideback = CacheDataLoader.getInstance().getAnimation("boss_slide");
        slideforward = CacheDataLoader.getInstance().getAnimation("boss_slide");
        slideforward.flipAllImage();

        setTimeNobeHurt(500*1000000);
        setDamage(10);

        TypeAttack[0] = "none";
        TypeAttack[1] = "shooting";
        TypeAttack[2] = "none";
        TypeAttack[3] = "slide";

        TimeAttack.put("none", new Long(2000));
        TimeAttack.put("shooting", new Long(500));
        TimeAttack.put("slide", new Long(5000));
    }

    public void Update(){
        super.Update();

        if(getGameWord().megaman.getPosX() > getPosX())
            setDirection(RIGHT_DIR);
        else setDirection(LEFT_DIR);

        if(StarTimeForAttack == 0)
            StarTimeForAttack = System.currentTimeMillis();
        else if(System.currentTimeMillis() - StarTimeForAttack > 300){
            Attack();
            StarTimeForAttack = System.currentTimeMillis();
        }

        if(!TypeAttack[AttackIndex].equals("none")){
            if(TypeAttack[AttackIndex].equals("shooting")){

                Bullet bullet = new RocketBullet(getPosX(), getPosY() - 50, getGameWord());
                if(getDirection() == LEFT_DIR) bullet.setSpeedX(-4);
                else bullet.setSpeedX(+4);
                bullet.setTypeTeam(getTypeTeam());
                getGameWord().bulletManager.addObject(bullet);

            }else if(TypeAttack[AttackIndex].equals("slide")){

                if(getGameWord().physicalMap.haveCollisionWithLeftWall(getBoundForCollisionWithMap())!=null)
                    setSpeedX(5);
                if(getGameWord().physicalMap.haveCollisionWithRightWall(getBoundForCollisionWithMap())!=null)
                    setSpeedX(-5);


                setPosX(getPosX() + getSpeedX());
            }
        }else{
            // stop attack
            setSpeedX(0);
        }
    }

    public void run(){}

    public void jump(){
        setSpeedY(-5);
    }

    public void dick(){}

    public void standUp(){}

    public void stopRun(){}

    public void Attack(){

        if(System.currentTimeMillis() - LastAttackTime > TimeAttack.get(TypeAttack[AttackIndex])){
            LastAttackTime = System.currentTimeMillis();
            AttackIndex++;
            if(AttackIndex >= TypeAttack.length) AttackIndex = 0;

            if(TypeAttack[AttackIndex].equals("slide")){
                if(getPosX() < getGameWord().megaman.getPosX()) setSpeedX(+5);
                else setSpeedX(-5);
            }

        }
    }

    public Rectangle getBoundForCollisionWithEnemy() {
        if(TypeAttack[AttackIndex].equals("slide")){
            Rectangle rect = getBoundForCollisionWithMap();
            rect.y += 100;
            rect.height -= 100;
            return rect;
        }else
            return getBoundForCollisionWithMap();
    }

    public void draw(Graphics2D g2) {

        if(getState() == NOBEHURT && (System.nanoTime()/10000000)%2!=1)
        {
            System.out.println("Plash...");
        }else{

            if(TypeAttack[AttackIndex].equals("none")){
                if(getDirection() == RIGHT_DIR){
                    idleforward.update(System.nanoTime());
                    idleforward.draw((int) (getPosX() - getGameWord().C1.getPosX()), (int) getPosY() - (int) getGameWord().C1.getPosY(), g2);
                }else{
                    idleback.update(System.nanoTime());
                    idleback.draw((int) (getPosX() - getGameWord().C1.getPosX()), (int) getPosY() - (int) getGameWord().C1.getPosY(), g2);
                }
            }else if(TypeAttack[AttackIndex].equals("shooting")){

                if(getDirection() == RIGHT_DIR){
                    shootingforward.update(System.nanoTime());
                    shootingforward.draw((int) (getPosX() - getGameWord().C1.getPosX()), (int) getPosY() - (int) getGameWord().C1.getPosY(), g2);
                }else{
                    shootingback.update(System.nanoTime());
                    shootingback.draw((int) (getPosX() - getGameWord().C1.getPosX()), (int) getPosY() - (int) getGameWord().C1.getPosY(), g2);
                }

            }else if(TypeAttack[AttackIndex].equals("slide")){
                if(getSpeedX() > 0){
                    slideforward.update(System.nanoTime());
                    slideforward.draw((int) (getPosX() - getGameWord().C1.getPosX()), (int) getPosY() - (int) getGameWord().C1.getPosY() + 50, g2);
                }else{
                    slideback.update(System.nanoTime());
                    slideback.draw((int) (getPosX() - getGameWord().C1.getPosX()), (int) getPosY() - (int) getGameWord().C1.getPosY() + 50, g2);
                }
            }
        }
        // drawBoundForCollisionWithEnemy(g2);
    }



}
