package com.dung.gameObject;

import java.awt.*;

public abstract class Human extends ParticularObject{

    private boolean isJumping;
    private boolean isDicking;
    private boolean isLanding;

    public Human(float posX, float posY, float width, float height, float mass, int blood, GameWord gameWord) {
        super(posX, posY, width, height, mass, blood, gameWord);
        setState(LIVE);
    }

    public abstract void run();
    public abstract void jump();
    public abstract void dick();
    public abstract void standUp();
    public abstract void stopRun();

    public boolean getIsJumping() {
        return isJumping;
    }

    public void setIsJumping(boolean jumping) {
        isJumping = jumping;
    }

    public boolean getIsDicking() {
        return isDicking;
    }

    public void setIsDicking(boolean dicking) {
        isDicking = dicking;
    }

    public boolean getIsLanding() {
        return isLanding;
    }

    public void setIsLanding(boolean landing) {
        isLanding = landing;
    }

    public void Update(){

        super.Update();

        if(getState() == LIVE || getState() == NOBEHURT) {
            if (!isLanding) {

                setPosX(getPosX() + getSpeedX());

                if (getDirection() == LEFT_DIR && getGameWord().physicalMap.haveCollisionWithLeftWall(getBoundForCollisionWithMap()) != null) {
                    Rectangle rectLeftWall = getGameWord().physicalMap.haveCollisionWithLeftWall(getBoundForCollisionWithMap());
                    setPosX(rectLeftWall.x + rectLeftWall.width + getWidth() / 2);
                }

                if (getDirection() == RIGHT_DIR && getGameWord().physicalMap.haveCollisionWithRightWall(getBoundForCollisionWithMap()) != null) {
                    Rectangle recRightWall = getGameWord().physicalMap.haveCollisionWithRightWall(getBoundForCollisionWithMap());
                    setPosX(recRightWall.x - getWidth() / 2);
                }

                Rectangle boundForCollisionWithMapFuture = getBoundForCollisionWithMap();
                boundForCollisionWithMapFuture.y += (getSpeedY()!=0?getSpeedY():2);

                Rectangle rectLand = getGameWord().physicalMap.haveCollisionWithLand(boundForCollisionWithMapFuture);
                Rectangle rectTop = getGameWord().physicalMap.haveCollisionWithTop(boundForCollisionWithMapFuture);

                if (rectTop != null) {
                    setSpeedY(0);
                    setPosY(rectTop.y + getGameWord().physicalMap.getTitleSize() + getHeight() / 2);
                } else if (rectLand != null) {
                    setIsJumping(false);
                    if (getSpeedY() > 0) setIsLanding(true);
                    setSpeedY(0);
                    setPosY(rectLand.y - getHeight()/2 - 1);
                } else {
                    setIsJumping(true);
                    setSpeedY(getSpeedY() + getMass());
                    setPosY(getPosY() + getSpeedY());
                }
            }
        }
    }
}
