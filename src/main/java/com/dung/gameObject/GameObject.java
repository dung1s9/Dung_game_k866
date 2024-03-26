package com.dung.gameObject;

public abstract class GameObject {

    private float posX;
    private float posY;
    private GameWord gameWord;

    public GameObject(float posX, float posY, GameWord gameWord) {
        this.posX = posX;
        this.posY = posY;
        this.gameWord = gameWord;
    }

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    public GameWord getGameWord() {
        return gameWord;
    }

    public abstract void Update();
}
