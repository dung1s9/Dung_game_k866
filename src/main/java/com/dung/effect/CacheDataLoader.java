package com.dung.effect;

import javax.imageio.ImageIO;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;

public class CacheDataLoader {

    private static CacheDataLoader instance;
    private String frameFile = "data/frame.txt";
    private String animationFile = "data/animation.txt";
    private String physMapFile = "data/phys_map.txt";
    private String backgroundmapfile = "data/background_map.txt";
    private String SoundFile = "data/sounds.txt";
    private int[][] phys_map;
    private int[][] background_map;

    private Hashtable<String, FrameImage> frameImages;
    private Hashtable<String, Animation> animations;
    private Hashtable<String, AudioClip> audios;

    private CacheDataLoader(){

    }

    public static CacheDataLoader getInstance(){

        if(instance == null)
            instance = new CacheDataLoader();
        return instance;

    }
    public void LoadData() throws IOException{
        LoadFrame();
        LoadAnimation();
        LoadBackgroundMap();
        LoadPhysicalMap();
        LoadSounds();
    }

    public int[][] getPhysicalMap(){
        return instance.phys_map;
    }



    public void LoadPhysicalMap() throws IOException{
        FileReader fr = new FileReader(physMapFile);
        BufferedReader br = new BufferedReader(fr);

        String line = null;

        line = br.readLine();
        int NumberOfRows = Integer.parseInt(line);
        line = br.readLine();
        int NumberOfCols = Integer.parseInt(line);

        instance.phys_map = new int[NumberOfRows][NumberOfCols];

        for(int i = 0; i < NumberOfRows; i++){
            line = br.readLine();
            String[] str = line.split(" ");
            for (int j = 0; j < NumberOfCols; j++ ){
                instance.phys_map[i][j] = Integer.parseInt(str[j]);
            }
        }



        br.close();
    }

    public void LoadSounds() throws IOException{
        audios = new Hashtable<String, AudioClip>();

        FileReader fr = new FileReader(SoundFile);
        BufferedReader br = new BufferedReader(fr);

        String line = null;

        if(br.readLine()==null) { // no line = "" or something like that
            System.out.println("No data");
            throw new IOException();
        }
        else {

            fr = new FileReader(SoundFile);
            br = new BufferedReader(fr);

            while((line = br.readLine()).equals(""));

            int n = Integer.parseInt(line);

            for(int i = 0;i < n; i ++){

                AudioClip audioClip = null;
                while((line = br.readLine()).equals(""));

                String[] str = line.split(" ");
                String name = str[0];

                try {
                    audioClip =  Applet.newAudioClip(new URL("file","",str[1]));

                } catch (MalformedURLException ex) {}

                instance.audios.put(name, audioClip);
            }

        }

        br.close();

    }

    public AudioClip getSound(String name){
        return instance.audios.get(name);
    }

    public void LoadFrame() throws IOException{

        frameImages = new Hashtable<String, FrameImage>();

        FileReader fr = new FileReader(frameFile);
        BufferedReader br = new BufferedReader(fr);

        String line = null;

        if(br.readLine() == null){
            System.out.println("No data");
            throw new IOException();
        }

        else {
            fr = new FileReader(frameFile);
            br = new BufferedReader(fr);

            while((line = br.readLine()).equals(""));
            int n = Integer.parseInt(line);

            for(int i = 0; i < n; i++){

                FrameImage frameImage = new FrameImage();
                while ((line = br.readLine()).equals(""));
                frameImage.setName(line);

                while ((line = br.readLine()).equals(""));
                String[] str = line.split(" ");
                String slide = str[1];

                while ((line = br.readLine()).equals(""));
                str = line.split(" ");
                int x = Integer.parseInt(str[1]);

                while ((line = br.readLine()).equals(""));
                str = line.split(" ");
                int y = Integer.parseInt(str[1]);

                while ((line = br.readLine()).equals(""));
                str = line.split(" ");
                int w = Integer.parseInt(str[1]);

                while ((line = br.readLine()).equals(""));
                str = line.split(" ");
                int h = Integer.parseInt(str[1]);

                BufferedImage imageData = ImageIO.read(new File(slide));
                BufferedImage imageData1 = imageData.getSubimage(x, y, w, h);
                frameImage.setImage(imageData1);

                instance.frameImages.put(frameImage.getName(), frameImage);

            }
        }
        br.close();
    }

    public FrameImage getFrameImage(String name){
        FrameImage frameImage = new FrameImage(instance.frameImages.get(name));
        return frameImage;
    }

    public int[][] getBackgroundMap(){
        return instance.background_map;
    }

    public void LoadBackgroundMap() throws IOException{

        FileReader fr = new FileReader(backgroundmapfile);
        BufferedReader br = new BufferedReader(fr);

        String line = null;

        line = br.readLine();
        int numberOfRows = Integer.parseInt(line);
        line = br.readLine();
        int numberOfColumns = Integer.parseInt(line);


        instance.background_map = new int[numberOfRows][numberOfColumns];

        for(int i = 0;i < numberOfRows;i++){
            line = br.readLine();
            String [] str = line.split(" |  ");
            for(int j = 0;j<numberOfColumns;j++)
                instance.background_map[i][j] = Integer.parseInt(str[j]);
        }

        for(int i = 0;i < numberOfRows;i++){

            for(int j = 0;j<numberOfColumns;j++)
                System.out.print(" "+instance.background_map[i][j]);

            System.out.println();
        }

        br.close();

    }

    public void LoadAnimation() throws IOException{

        animations = new Hashtable<String, Animation>();

        FileReader fr = new FileReader(animationFile);
        BufferedReader br = new BufferedReader(fr);

        String line = null;

        if(br.readLine() == null){
            System.out.println("No data");
            throw new IOException();
        }

        else {

            fr = new FileReader(animationFile);
            br = new BufferedReader(fr);

            while((line = br.readLine()).equals(""));
            int n = Integer.parseInt(line);

            for(int i = 0; i < n; i++){

                Animation animation = new Animation();

                while((line = br.readLine()).equals(""));
                animation.setName(line);

                while((line = br.readLine()).equals(""));
                String[] str = line.split(" ");

                for(int j = 0; j < str.length; j+=2){
                    animation.add(getFrameImage(str[j]), Double.parseDouble(str[j+1]));
                }

                instance.animations.put(animation.getName(), animation);
            }
        }

        br.close();
    }

    public Animation getAnimation(String name){
        Animation animation = new Animation(instance.animations.get(name));
        return animation;
    }

}