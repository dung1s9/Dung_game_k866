package com.dung.gameObject;

public class camera extends GameObject{

    private float witchView;
    private float heightView;

    private boolean UnLock = false;

    public camera(float posX, float posY, GameWord gameWord, float witchView, float heightView) {
        super(posX, posY, gameWord);
        this.witchView = witchView;
        this.heightView = heightView;
    }

    public void lock(){
        UnLock = false;
    }

    public void unLock(){
        UnLock = true;
    }



    public void Update(){
        if(!UnLock){
            Megaman mainCharacter = getGameWord().megaman;

            if(mainCharacter.getPosX() - getPosX() > 400) setPosX(mainCharacter.getPosX()-400);
            else if(mainCharacter.getPosX() - getPosX() < 200) setPosX(mainCharacter.getPosX() - 200);

            if(mainCharacter.getPosY() - getPosY() > 400) setPosY(mainCharacter.getPosY() -400);
            else if(mainCharacter.getPosY() - getPosY() < 250) setPosY(mainCharacter.getPosY() -250);
        }
    }

    public float getWitchView() {
        return witchView;
    }

    public void setWitchView(float witchView) {
        this.witchView = witchView;
    }

    public float getHeightView() {
        return heightView;
    }

    public void setHeightView(float heightView) {
        this.heightView = heightView;
    }
}
