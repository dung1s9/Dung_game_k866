package com.dung.gameObject;

public class BulletManager extends PacticularObjectManager{

    public BulletManager(GameWord gameWorld) {
        super(gameWorld);
    }

    @Override
    public void UpdateObjects() {
        super.UpdateObjects();
        synchronized(particularObjects){
            for(int id = 0; id < particularObjects.size(); id++){

                ParticularObject object = particularObjects.get(id);

                if(object.isObjectOutOfCameraView() || object.getState() == ParticularObject.DEATH){
                    particularObjects.remove(id);
                }
            }
        }
    }
}
