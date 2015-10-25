package com.ajay.tcs.snakegame;

import com.ajay.tcs.framework.FileIO;

import java.io.*;

/**
 * Created by Ajax on 10/25/2015.
 * class to initially store basic settings like sound  and
 * Five High Scores
 */
public class Settings {

    public static boolean soundEnabled = true;
    public static int[] highScores = new int[]{100,80,50,30,10};

    public static void load(FileIO files){

        BufferedReader bufferedReader =null;

        try{

            bufferedReader = new BufferedReader(new InputStreamReader(files.readFile(".mrnom")));
            soundEnabled = Boolean.parseBoolean(bufferedReader.readLine());

            for(int i=0;i<5;i++){
                highScores[i] = Integer.parseInt(bufferedReader.readLine());
            }
        }catch (IOException ie){
            ie.printStackTrace();
        }catch (NumberFormatException ne){
            ne.printStackTrace();
        }finally {
            try{

                if(bufferedReader!=null){
                    bufferedReader.close();
                }
            }catch (IOException ie){
                ie.printStackTrace();
            }

        }

    }


    public static void save(FileIO files){

        BufferedWriter bufferedWriter = null;

        try{
            bufferedWriter = new BufferedWriter( new OutputStreamWriter(files.writeFile(".mrnom")));
            bufferedWriter.write(Boolean.toString(soundEnabled));

            for (int i=0;i<5;i++){
                bufferedWriter.write(Integer.toString(highScores[i]));
            }
        }catch (IOException ie){
            ie.printStackTrace();
        }finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException ie) {
                ie.printStackTrace();
            }
        }
    }

    // adding high scores and sorting them accordingly
    public static void addScore(int score) {
        for (int i = 0; i < 5; i++) {
            if (highScores[i] < score) {
                for (int j = 4; j > i; j--)
                    highScores[j] = highScores[j - 1];
                highScores[i] = score;
                break;
            }
        }
    }

}
