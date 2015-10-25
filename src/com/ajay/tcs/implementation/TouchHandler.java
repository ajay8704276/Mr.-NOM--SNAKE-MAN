package com.ajay.tcs.implementation;

import android.view.View.OnTouchListener;
import com.ajay.tcs.framework.Input;

import java.util.List;

/**
 * Created by Ajax on 10/25/2015.
 */
public interface TouchHandler extends OnTouchListener {

    public boolean isTouchDown(int pointer);
    public int getTouchX(int pointer);
    public int getTouchY(int pointer);
    public List<Input.TouchEvent> getTouchEvents();
}
