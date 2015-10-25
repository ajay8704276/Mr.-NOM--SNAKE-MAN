package com.ajay.tcs.snakegame;

import com.ajay.tcs.framework.Screen;
import com.ajay.tcs.implementation.AndroidGame;

public class MrSnakeMan extends AndroidGame {
    @Override
    public Screen getStartScreen() {
        return new LoadingScreen(this);
    }

}
