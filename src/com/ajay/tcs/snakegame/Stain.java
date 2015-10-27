package com.ajay.tcs.snakegame;

/**
 * Created by Ajax on 10/27/2015.
 */
public class Stain {

    public static final int TYPE_1 = 0;
    public static final int TYPE_2 = 1;
    public static final int TYPE_3 = 2;

    public int x,y;
    public int type;


    public Stain(int x, int y , int type){
        this.x = x;
        this.y = y;
        this.type = type;
    }
}
