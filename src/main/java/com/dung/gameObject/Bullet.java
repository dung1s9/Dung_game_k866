package com.dung.gameObject;

import java.awt.*;

public abstract class Bullet extends ParticularObject{

    public Bullet(float posX, float posY, float width, float height, float mass, int damage, GameWord gameWord) {
        super(posX, posY, width, height, mass, 1, gameWord);
        setDamage(damage);
    }

    public abstract void draw(Graphics2D g2);

    public void Update(){
        super.Update();
        setPosX(getPosX() + getSpeedX());
        setPosY(getPosY() + getSpeedY());
        ParticularObject object = getGameWord().pacticularObjectManager.getCollisionWidthEnemyObject(this);
        if(object!=null && object.getState() == LIVE){
            setBlood(0);
            object.beHurt(getDamage());
            System.out.println("Bullet set behurt for enemy");
        }
    }
}
