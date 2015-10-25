package com.ajay.tcs.implementation;

import android.graphics.Bitmap;
import com.ajay.tcs.framework.Graphics;
import com.ajay.tcs.framework.Pixmap;

/**
 * Created by Ajax on 10/25/2015.
 */
public class AndroidPixmap implements Pixmap {


    Bitmap bitmap;
    Graphics.PixmapFormat format;



    public AndroidPixmap(Bitmap bitmap , Graphics.PixmapFormat format){
        this.bitmap = bitmap;
        this.format = format;
    }
    @Override
    public int getWidth() {
        return bitmap.getWidth();
    }

    @Override
    public int getHeight() {
        return bitmap.getHeight();
    }

    @Override
    public Graphics.PixmapFormat getFormat() {
        return format;
    }

    @Override
    public void dispose() {

        bitmap.recycle();
    }
}
