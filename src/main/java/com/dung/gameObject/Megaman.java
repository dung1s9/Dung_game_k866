package com.dung.gameObject;

import com.dung.effect.Animation;
import com.dung.effect.CacheDataLoader;

import java.applet.AudioClip;
import java.awt.*;

public class Megaman extends Human{

    private Animation landingForwardAnim, landingBackAnim;
    private Animation runForwardAnim, runBackAnim, runShootingForwarAnim, runShootingBackAnim;
    private Animation idleForwardAnim, idleBackAnim, idleShootingForwardAnim, idleShootingBackAnim;
    private Animation dickForwardAnim, dickBackAnim;
    private Animation flyForwardAnim, flyBackAnim, flyShootingForwardAnim, flyShootingBackAnim;
    private Animation climWallForward, climWallBack;
    private long lastShootingTime;
    private boolean isShooting = false;
    private AudioClip shooting1;
    private AudioClip hurtingSound;

    public Megaman(float posX, float posY, GameWord gameWord) {
        super(posX, posY, 70, 90, 0.1f, 100, gameWord);

        shooting1 = CacheDataLoader.getInstance().getSound("bluefireshooting");
        hurtingSound = CacheDataLoader.getInstance().getSound("megamanhurt");

        setTypeTeam(LEAGUE_TEAM);
        setTimeNobeHurt(2000*1000000);

        runForwardAnim = CacheDataLoader.getInstance().getAnimation("run");
        runBackAnim = CacheDataLoader.getInstance().getAnimation("run");
        runBackAnim.flipAllImage();

        idleForwardAnim = CacheDataLoader.getInstance().getAnimation("idle");
        idleBackAnim = CacheDataLoader.getInstance().getAnimation("idle");
        idleBackAnim.flipAllImage();

        dickForwardAnim = CacheDataLoader.getInstance().getAnimation("dick");
        dickBackAnim = CacheDataLoader.getInstance().getAnimation("dick");
        dickBackAnim.flipAllImage();

        flyForwardAnim = CacheDataLoader.getInstance().getAnimation("flyingup");
        flyForwardAnim.setRepeated(false);
        flyBackAnim = CacheDataLoader.getInstance().getAnimation("flyingup");
        flyBackAnim.setRepeated(false);
        flyBackAnim.flipAllImage();

        landingForwardAnim = CacheDataLoader.getInstance().getAnimation("landing");
        landingBackAnim = CacheDataLoader.getInstance().getAnimation("landing");
        landingBackAnim.flipAllImage();

        climWallBack = CacheDataLoader.getInstance().getAnimation("clim_wall");
        climWallForward = CacheDataLoader.getInstance().getAnimation("clim_wall");
        climWallForward.flipAllImage();

        beHurtForwarAnim = CacheDataLoader.getInstance().getAnimation("hurting");
        beHurtBackAnim = CacheDataLoader.getInstance().getAnimation("hurting");
        beHurtBackAnim.flipAllImage();

        idleShootingForwardAnim = CacheDataLoader.getInstance().getAnimation("idleshoot");
        idleShootingBackAnim = CacheDataLoader.getInstance().getAnimation("idleshoot");
        idleShootingBackAnim.flipAllImage();

        runShootingForwarAnim = CacheDataLoader.getInstance().getAnimation("runshoot");
        runShootingBackAnim = CacheDataLoader.getInstance().getAnimation("runshoot");
        runShootingBackAnim.flipAllImage();

        flyShootingForwardAnim = CacheDataLoader.getInstance().getAnimation("flyingupshoot");
        flyShootingBackAnim = CacheDataLoader.getInstance().getAnimation("flyingupshoot");
        flyShootingBackAnim.flipAllImage();

    }

    public long getLastShootingTime() {
        return lastShootingTime;
    }

    public void setLastShootingTime(long lastShootingTime) {
        this.lastShootingTime = lastShootingTime;
    }

    public boolean isShooting() {
        return isShooting;
    }

    public void setShooting(boolean shooting) {
        isShooting = shooting;
    }

    public void Update(){

        super.Update();

        if(isShooting){
            if(System.nanoTime() - lastShootingTime > 500*1000000){
                isShooting = false;
            }
        }

        if(getIsLanding()){
            landingBackAnim.update(System.nanoTime());
            if(landingBackAnim.isLastFrame()) {
                setIsLanding(false);
                landingBackAnim.reset();
                runForwardAnim.reset();
                runBackAnim.reset();
            }
        }
    }

    public Rectangle getBoundForCollisionWithEnemy() {

        Rectangle rect = getBoundForCollisionWithMap();

        if(getIsDicking()){
            rect.x = (int) getPosX() - 22;
            rect.y = (int) getPosY() - 20;
            rect.width = 44;
            rect.height = 65;
        }else{
            rect.x = (int) getPosX() - 22;
            rect.y = (int) getPosY() - 40;
            rect.width = 44;
            rect.height = 80;
        }

        return rect;
    }

    public void draw(Graphics2D g2){

        switch(getState()){

            case LIVE:
            case NOBEHURT:
                if(getState() == NOBEHURT && (System.nanoTime()/10000000)%2!=1)
                {
                    System.out.println("dung vip pro that la vo dich......");
                }
                else{

                    if(getIsLanding()){

                        if(getDirection() == RIGHT_DIR){
                            landingForwardAnim.setCurrentFrame(landingBackAnim.getCurrentFrame());
                            landingForwardAnim.draw((int) (getPosX() - getGameWord().C1.getPosX()),
                                    (int) getPosY() - (int) getGameWord().C1.getPosY() + (getBoundForCollisionWithMap().height/2 - landingForwardAnim.getCurrentImage().getHeight()/2),
                                    g2);
                        }else{
                            landingBackAnim.draw((int) (getPosX() - getGameWord().C1.getPosX()),
                                    (int) getPosY() - (int) getGameWord().C1.getPosY() + (getBoundForCollisionWithMap().height/2 - landingBackAnim.getCurrentImage().getHeight()/2),
                                    g2);
                        }

                    }else if(getIsJumping()){

                        if(getDirection() == RIGHT_DIR){
                            flyForwardAnim.update(System.nanoTime());
                            if(isShooting){
                                flyShootingForwardAnim.setCurrentFrame(flyForwardAnim.getCurrentFrame());
                                flyShootingForwardAnim.draw((int) (getPosX() - getGameWord().C1.getPosX()) + 10, (int) getPosY() - (int) getGameWord().C1.getPosY(), g2);
                            }else
                                flyForwardAnim.draw((int) (getPosX() - getGameWord().C1.getPosX()), (int) getPosY() - (int) getGameWord().C1.getPosY(), g2);
                        }else{
                            flyBackAnim.update(System.nanoTime());
                            if(isShooting){
                                flyShootingBackAnim.setCurrentFrame(flyBackAnim.getCurrentFrame());
                                flyShootingBackAnim.draw((int) (getPosX() - getGameWord().C1.getPosX()) - 10, (int) getPosY() - (int) getGameWord().C1.getPosY(), g2);
                            }else
                                flyBackAnim.draw((int) (getPosX() - getGameWord().C1.getPosX()), (int) getPosY() - (int) getGameWord().C1.getPosY(), g2);
                        }

                    }else if(getIsDicking()){

                        if(getDirection() == RIGHT_DIR){
                            dickForwardAnim.update(System.nanoTime());
                            dickForwardAnim.draw((int) (getPosX() - getGameWord().C1.getPosX()),
                                    (int) getPosY() - (int) getGameWord().C1.getPosY() + (getBoundForCollisionWithMap().height/2 - dickForwardAnim.getCurrentImage().getHeight()/2),
                                    g2);
                        }else{
                            dickBackAnim.update(System.nanoTime());
                            dickBackAnim.draw((int) (getPosX() - getGameWord().C1.getPosX()),
                                    (int) getPosY() - (int) getGameWord().C1.getPosY() + (getBoundForCollisionWithMap().height/2 - dickBackAnim.getCurrentImage().getHeight()/2),
                                    g2);
                        }

                    }else{
                        if(getSpeedX() > 0){
                            runForwardAnim.update(System.nanoTime());
                            if(isShooting){
                                runShootingForwarAnim.setCurrentFrame(runForwardAnim.getCurrentFrame() - 1);
                                runShootingForwarAnim.draw((int) (getPosX() - getGameWord().C1.getPosX()), (int) getPosY() - (int) getGameWord().C1.getPosY(), g2);
                            }else
                                runForwardAnim.draw((int) (getPosX() - getGameWord().C1.getPosX()), (int) getPosY() - (int) getGameWord().C1.getPosY(), g2);
                            if(runForwardAnim.getCurrentFrame() == 1) runForwardAnim.setIgnoreFrame(0);
                        }else if(getSpeedX() < 0){
                            runBackAnim.update(System.nanoTime());
                            if(isShooting){
                                runShootingBackAnim.setCurrentFrame(runBackAnim.getCurrentFrame() - 1);
                                runShootingBackAnim.draw((int) (getPosX() - getGameWord().C1.getPosX()), (int) getPosY() - (int) getGameWord().C1.getPosY(), g2);
                            }else
                                runBackAnim.draw((int) (getPosX() - getGameWord().C1.getPosX()), (int) getPosY() - (int) getGameWord().C1.getPosY(), g2);
                            if(runBackAnim.getCurrentFrame() == 1) runBackAnim.setIgnoreFrame(0);
                        }else{
                            if(getDirection() == RIGHT_DIR){
                                if(isShooting){
                                    idleShootingForwardAnim.update(System.nanoTime());
                                    idleShootingForwardAnim.draw((int) (getPosX() - getGameWord().C1.getPosX()), (int) getPosY() - (int) getGameWord().C1.getPosY(), g2);
                                }else{
                                    idleForwardAnim.update(System.nanoTime());
                                    idleForwardAnim.draw((int) (getPosX() - getGameWord().C1.getPosX()), (int) getPosY() - (int) getGameWord().C1.getPosY(), g2);
                                }
                            }else{
                                if(isShooting){
                                    idleShootingBackAnim.update(System.nanoTime());
                                    idleShootingBackAnim.draw((int) (getPosX() - getGameWord().C1.getPosX()), (int) getPosY() - (int) getGameWord().C1.getPosY(), g2);
                                }else{
                                    idleBackAnim.update(System.nanoTime());
                                    idleBackAnim.draw((int) (getPosX() - getGameWord().C1.getPosX()), (int) getPosY() - (int) getGameWord().C1.getPosY(), g2);
                                }
                            }
                        }
                    }
                }

                break;

            case HURT:
                if(getDirection() == RIGHT_DIR){
                    beHurtForwarAnim.draw((int) (getPosX() - getGameWord().C1.getPosX()), (int) getPosY() - (int) getGameWord().C1.getPosY(), g2);
                }else{
                    beHurtBackAnim.setCurrentFrame(beHurtForwarAnim.getCurrentFrame());
                    beHurtBackAnim.draw((int) (getPosX() - getGameWord().C1.getPosX()), (int) getPosY() - (int) getGameWord().C1.getPosY(), g2);
                }
            break;

            case DEATH:

                break;

        }
        drawBoundForCollisionWithMap(g2);
//        drawBoundForCollisionWithEnemy(g2);
    }

    public void run(){
        if(getDirection() == LEFT_DIR)
            setSpeedX(-3);
        else setSpeedX(+3);
    }

    public void jump(){

        if(!getIsJumping()) {
            setIsJumping(true);
            setSpeedY(-6.1f);
            flyBackAnim.reset();
            flyForwardAnim.reset();
        }

        //for clim wall
        else {
            Rectangle rectRightWall = getBoundForCollisionWithMap();
            rectRightWall.x += 1;
            Rectangle rectLeftWall = getBoundForCollisionWithMap();
            rectLeftWall.x -= 1;

            if(getGameWord().physicalMap.haveCollisionWithRightWall(rectRightWall)!=null && getSpeedX() > 0){
                setSpeedY(-5.0f);
                //setSpeedX(-1);
                flyBackAnim.reset();
                flyForwardAnim.reset();
                //setDirection(LEFT_DIR);
            }else if(getGameWord().physicalMap.haveCollisionWithLeftWall(rectLeftWall)!=null && getSpeedX() < 0){
                setSpeedY(-5.0f);
                //setSpeedX(1);
                flyBackAnim.reset();
                flyForwardAnim.reset();
                //setDirection(RIGHT_DIR);
            }
        }
    }

    public void dick(){
        if(!getIsJumping())
            setIsDicking(true);
    }

    public void standUp(){
        setIsDicking(false);
        idleForwardAnim.reset();
        idleBackAnim.reset();
        dickForwardAnim.reset();
        dickBackAnim.reset();
    }

    public void stopRun(){
        setSpeedX(0);
        runForwardAnim.reset();
        runBackAnim.reset();
        runForwardAnim.unIgnoreFrame(0);
        runBackAnim.unIgnoreFrame(0);
    }

    public void Attack(){
        if(!isShooting && !getIsDicking()){

            shooting1.play();

            Bullet bullet = new BlueFire(getPosX(), getPosY(), getGameWord());

            if(getDirection() == LEFT_DIR) {
                bullet.setSpeedX(-10);
                bullet.setPosX(bullet.getPosX() - 40);
                if(getSpeedX() != 0 && getSpeedY() == 0){
                    bullet.setPosX(bullet.getPosX() - 10);
                    bullet.setPosY(bullet.getPosY() - 5);
                }
            }else {
                bullet.setSpeedX(+10);
                bullet.setPosX(bullet.getPosX() + 40);
                if(getSpeedX() != 0 && getSpeedY() == 0){
                    bullet.setPosX(bullet.getPosX() + 10);
                    bullet.setPosY(bullet.getPosY() - 5);
                }
            }
            if(getIsJumping())
                bullet.setPosY(bullet.getPosY() - 20);

            bullet.setTypeTeam(getTypeTeam());
            getGameWord().bulletManager.addObject(bullet);

            lastShootingTime = System.nanoTime();
            isShooting = true;

        }
    }

    public void hurtingCallBack(){
        System.out.println("Call back hurting");
        hurtingSound.play();
    }




}
