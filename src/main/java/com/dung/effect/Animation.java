package com.dung.effect;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Animation {

    private String name;
    private boolean isRepeated;
    private ArrayList<FrameImage> frameImages;
    private int CurrentFrame; // Hình ảnh hiện tại.
    private ArrayList<Boolean> IgnoreFrame;
    private  ArrayList<Double> DelayFrame;
    private long BeginTime;
    private boolean DrawRectFrame;

    public Animation(){
        isRepeated = true;
        DrawRectFrame = false;

        IgnoreFrame = new ArrayList<Boolean>();
        DelayFrame = new ArrayList<Double>();
        frameImages = new ArrayList<FrameImage>();

        CurrentFrame = 0;
        BeginTime = 0;
    }

    public Animation(Animation animation){

        isRepeated = animation.isRepeated;
        CurrentFrame = animation.CurrentFrame;
        BeginTime = animation.BeginTime;
        DrawRectFrame = animation.DrawRectFrame;

        IgnoreFrame = new ArrayList<Boolean>();
        for(Boolean d : animation.IgnoreFrame){
            IgnoreFrame.add(d);
        }

        DelayFrame = new ArrayList<Double>();
        for (Double b : animation.DelayFrame){
            DelayFrame.add(b);
        }

        frameImages = new ArrayList<FrameImage>();
        for (FrameImage f : animation.frameImages){
            frameImages.add(new FrameImage(f));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getRepeated() {
        return isRepeated;
    }

    public void setRepeated(boolean repeated) {
        isRepeated = repeated;
    }

    public ArrayList<FrameImage> getFrameImages() {
        return frameImages;
    }

    public void setFrameImages(ArrayList<FrameImage> frameImages) {
        this.frameImages = frameImages;
    }

    public int getCurrentFrame() {
        return CurrentFrame;
    }

    public void setCurrentFrame(int currentFrame) {
        if(currentFrame >= 0 && currentFrame < frameImages.size())
            this.CurrentFrame = currentFrame;
        else this.CurrentFrame = 0;
    }

    public ArrayList<Boolean> getIgnoreFrame() {
        return IgnoreFrame;
    }

    public void setIgnoreFrame(ArrayList<Boolean> ignoreFrame) {
        IgnoreFrame = ignoreFrame;
    }

    public ArrayList<Double> getDelayFrame() {
        return DelayFrame;
    }

    public void setDelayFrame(ArrayList<Double> delayFrame) {
        DelayFrame = delayFrame;
    }

    public long getBeginTime() {
        return BeginTime;
    }

    public void setBeginTime(long beginTime) {
        BeginTime = beginTime;
    }

    public boolean getDrawRectFrame() {
        return DrawRectFrame;
    }

    public void setDrawRectFrame(boolean drawRectFrame) {
        DrawRectFrame = drawRectFrame;
    }

    public boolean isIgnoreFrame(int id){
        return IgnoreFrame.get(id);
    }
    public  void setIgnoreFrame(int id){
        if(id >= 0 && id < IgnoreFrame.size()) IgnoreFrame.set(id, true);
    }
    public void unIgnoreFrame(int id){
        if (id >= 0 && id < IgnoreFrame.size()) IgnoreFrame.set(id, false);
    }

    public void reset(){
        BeginTime = 0;
        CurrentFrame = 0;
        for(int i = 0; i < IgnoreFrame.size(); i++) IgnoreFrame.set(i, false);
    }

    public void add(FrameImage frameImage, Double timeToNextFrame){
        IgnoreFrame.add(false);
        frameImages.add(frameImage);
        DelayFrame.add(new Double(timeToNextFrame));
    }
    public BufferedImage getCurrentImage(){
        return frameImages.get(CurrentFrame).getImage();
    }

    public void update(Long currentTime){
        if(BeginTime == 0) BeginTime = currentTime;
        else{
            if(currentTime - BeginTime > DelayFrame.get(CurrentFrame)) {
                nextFrame();
                BeginTime = currentTime;
            }
        }
    }

    private void nextFrame(){

        if(CurrentFrame >= frameImages.size() - 1){

            if(isRepeated) CurrentFrame = 0;
        }
        else CurrentFrame++;

        if(IgnoreFrame.get(CurrentFrame)) nextFrame();

    }

    public boolean isLastFrame(){
        if(CurrentFrame == frameImages.size() - 1)
            return true;
        else return false;
    }

    public void flipAllImage(){
        for(int i = 0; i < frameImages.size(); i++){
            BufferedImage image = frameImages.get(i).getImage();

            AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
            tx.translate(-image.getWidth(), 0);

            AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
            image = op.filter(image, null);

            frameImages.get(i).setImage(image);

        }
    }

    public void draw(int x, int y, Graphics2D g2){

        BufferedImage image = getCurrentImage();

        g2.drawImage(image, x - image.getWidth()/2, y - image.getHeight()/2, null);
        if(DrawRectFrame)
            g2.drawRect(x - image.getWidth()/2, y - image.getHeight()/2, image.getWidth(), image.getHeight());

    }
}
