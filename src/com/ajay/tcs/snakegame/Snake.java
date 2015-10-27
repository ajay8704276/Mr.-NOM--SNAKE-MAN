package com.ajay.tcs.snakegame;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ajax on 10/27/2015.
 */
public class Snake {

    public static final int UP = 0;
    public static final int LEFT = 1;
    public static final int DOWN = 2;
    public static final int RIGHT = 3;

    public List<SnakePart> part = new ArrayList<SnakePart>();
    public int direction;


    public Snake(){
        direction = UP;
        part.add(new SnakePart(5,6));
        part.add(new SnakePart(5,7));
        part.add(new SnakePart(5,8));

    }

    public void turnLeft(){
        direction = direction+1;
        if(direction>RIGHT){
            direction = UP;
        }
    }


    public void turnRight(){
        direction = direction - 1;
        if(direction<UP){
            direction = RIGHT;
        }
    }


    public void eat(){
        SnakePart end = part.get(part.size() - 1);
        part.add(new SnakePart(end.x,end.y));
    }

    public void advance(){

        //Snake Advancement not much clear
        SnakePart head = part.get(0);

        int len = part.size() - 1;
        for(int i = len; i > 0; i--) {
            SnakePart before = part.get(i-1);
            SnakePart parts = part.get(i);
            parts.x = before.x;
            parts.y = before.y;
        }
        if(direction == UP)
            head.y -= 1;
        if(direction == LEFT)
            head.x -= 1;
        if(direction == DOWN)
            head.y += 1;
        if(direction == RIGHT)
            head.x += 1;
        if(head.x < 0)
            head.x = 9;
        if(head.x > 9)
            head.x = 0;
        if(head.y < 0)
            head.y = 12;
        if(head.y > 12)
            head.y = 0;

    }

    public boolean checkBitten(){

        //Logic need to be more clear please focus on this
        int len = part.size();
        SnakePart head = part.get(0);
        for(int i = 1; i < len; i++) {
            SnakePart parts = part.get(i);
            if(parts.x == head.x && parts.y == head.y)
                return true;
        }
        return false;
    }
}
