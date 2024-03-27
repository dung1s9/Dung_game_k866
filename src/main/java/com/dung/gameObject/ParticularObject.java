package com.dung.gameObject;

import com.dung.effect.Animation;

import java.awt.*;

public abstract class ParticularObject extends GameObject{

    public static final int LEAGUE_TEAM = 1;
    public static final int ENEMY_TEAM = 2;
    public static final int LEFT_DIR = 0;
    public static final int RIGHT_DIR = 1;
    public static final int LIVE =0;
    public static final int HURT = 1;
    public static final int DEATH = 2;
    public static final int NOBEHURT = 3;
    private int state = LIVE;

    private float width;
    private float height;
    private float mass;
    private float speedX;
    private float speedY;
    private int Blood;
    private int damage;
    private int Direction;

    protected Animation beHurtForwarAnim, beHurtBackAnim;
    private int typeTeam;
    private long starTimeNobeHurt;
    private long timeNobeHurt;

    public ParticularObject(float posX, float posY, float width, float height, float mass, int blood, GameWord gameWord) {
        super(posX, posY, gameWord);
        this.width = width;
        this.height = height;
        this.mass = mass;
        this.Blood = blood;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getMass() {
        return mass;
    }

    public void setMass(float mass) {
        this.mass = mass;
    }

    public float getSpeedX() {
        return speedX;
    }

    public void setSpeedX(float speedX) {
        this.speedX = speedX;
    }

    public float getSpeedY() {
        return speedY;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }

    public int getBlood() {
        return Blood;
    }

    public void setBlood(int blood) {
        Blood = blood;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDirection() {
        return Direction;
    }

    public void setDirection(int direction) {
        Direction = direction;
    }

    public Animation getBeHurtForwarAnim() {
        return beHurtForwarAnim;
    }

    public void setBeHurtForwarAnim(Animation beHurtForwarAnim) {
        this.beHurtForwarAnim = beHurtForwarAnim;
    }

    public Animation getBeHurtBackAnim() {
        return beHurtBackAnim;
    }

    public void setBeHurtBackAnim(Animation beHurtBackAnim) {
        this.beHurtBackAnim = beHurtBackAnim;
    }

    public int getTypeTeam() {
        return typeTeam;
    }

    public void setTypeTeam(int typeTeam) {
        this.typeTeam = typeTeam;
    }

    public long getStarTimeNobeHurt() {
        return starTimeNobeHurt;
    }

    public void setStarTimeNobeHurt(long starTimeNobeHurt) {
        this.starTimeNobeHurt = starTimeNobeHurt;
    }

    public long getTimeNobeHurt() {
        return timeNobeHurt;
    }

    public void setTimeNobeHurt(long timeNobeHurt) {
        this.timeNobeHurt = timeNobeHurt;
    }

    public Rectangle getBoundForCollisionWithMap(){
        Rectangle bound = new Rectangle();
        bound.x = (int) (getPosX() - (getWidth()/2));
        bound.y = (int) (getPosY() - (getHeight()/2));
        bound.width = (int) getWidth();
        bound.height = (int) getHeight();
        return bound;
    }

    public abstract void Attack();

    public boolean isObjectOutOfCameraView(){
        if(getPosX() - getGameWord().C1.getPosX() > getGameWord().C1.getWitchView() ||
                getPosX() - getGameWord().C1.getPosX() < -50
                ||getPosY() - getGameWord().C1.getPosY() > getGameWord().C1.getHeightView()
                ||getPosY() - getGameWord().C1.getPosY() < -50)
            return true;
        else return false;
    }


    public void beHurt(int damageEat){
        setBlood(getBlood() - damageEat);
        state = HURT;
        hurtingCallBack();
    }

    @Override
    public void Update() {
        switch (state){
            case LIVE:

                ParticularObject object = getGameWord().pacticularObjectManager.getCollisionWidthEnemyObject(this);
                if(object!=null) {


                    if (object.getDamage() > 0) {

                        // switch state to fey if object die

                        System.out.println("eat damage.... from collision with enemy........ " + object.getDamage());
                        beHurt(object.getDamage());
                    }

                }

                    break;


            case HURT:

                if(beHurtBackAnim == null){
                    state = NOBEHURT;
                    starTimeNobeHurt = System.nanoTime();
                    if(getBlood() == 0)
                        state = DEATH;
                } else {
                    beHurtForwarAnim.update(System.nanoTime());
                    if(beHurtForwarAnim.isLastFrame()){
                        beHurtForwarAnim.reset();
                        state = NOBEHURT;
                        if(getBlood() == 0)
                            state = DEATH;
                        starTimeNobeHurt = System.nanoTime();
                    }

                }

                break;

            case DEATH:

                break;

            case NOBEHURT:

                System.out.println("UNDEATH");
                if(System.nanoTime() - starTimeNobeHurt > timeNobeHurt)
                    state = LIVE;
                break;

        }
    }

    public void drawBoundForCollisionWithMap(Graphics2D g2){
        Rectangle rect = getBoundForCollisionWithMap();
        g2.setColor(Color.green);
        g2.drawRect(rect.x - (int) getGameWord().C1.getPosX(), rect.y - (int) getGameWord().C1.getPosY(), rect.width, rect.height);
    }

    public void drawBoundForCollisionWithEnemy(Graphics2D g2){
        Rectangle rect = getBoundForCollisionWithEnemy();
        g2.setColor(Color.yellow);
        g2.drawRect(rect.x - (int) getGameWord().C1.getPosX(), rect.y - (int) getGameWord().C1.getPosY(), rect.width, rect.height);
    }

    public abstract void draw(Graphics2D g2);

    public abstract Rectangle getBoundForCollisionWithEnemy();


    public void hurtingCallBack() {}

}
