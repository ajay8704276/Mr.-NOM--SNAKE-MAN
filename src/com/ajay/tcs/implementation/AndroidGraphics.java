package com.ajay.tcs.implementation;

import android.content.res.AssetManager;
import android.graphics.*;
import com.ajay.tcs.framework.Graphics;
import com.ajay.tcs.framework.Pixmap;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Ajax on 10/25/2015.
 */
public class AndroidGraphics implements Graphics {


    AssetManager assets;
    Bitmap frameBuffer;
    Canvas canvas;
    Paint paint;
    Rect srcRect = new Rect();
    Rect dstRect = new Rect();



    public AndroidGraphics(AssetManager assets, Bitmap frameBuffer) {
        this.assets = assets;
        this.frameBuffer = frameBuffer;
        this.canvas = new Canvas(frameBuffer);
        this.paint = new Paint();
    }


    /**
     * The Graphics.newPixmap() method will load an image given in either
     * JPEG or PNG format
     *
     * @param fileName
     * @param format
     * @return
     */
    @Override
    public Pixmap newPixmap(String fileName, PixmapFormat format) {

        Bitmap.Config config = null;
        if (format == PixmapFormat.RGB565)
            config = Bitmap.Config.RGB_565;
        else if (format == PixmapFormat.ARGB4444)
            config = Bitmap.Config.ARGB_4444;
        else
            config = Bitmap.Config.ARGB_8888;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = config;
        InputStream in = null;
        Bitmap bitmap = null;
        try {
            in = assets.open(fileName);
            bitmap = BitmapFactory.decodeStream(in);
            if (bitmap == null)
                throw new RuntimeException("Couldn't load bitmap from asset '"
                        + fileName + "'");
        } catch (IOException e) {
            throw new RuntimeException("Couldn't load bitmap from asset '"
                    + fileName + "'");
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }
        if (bitmap.getConfig() == Bitmap.Config.RGB_565)
            format = PixmapFormat.RGB565;
        else if (bitmap.getConfig() == Bitmap.Config.ARGB_4444)
            format = PixmapFormat.ARGB4444;
        else
            format = PixmapFormat.ARGB8888;
        return new AndroidPixmap(bitmap, format);
    }

    /**
     * The Graphics.clear() method clears the complete framebuffer with the given
     * color
     *
     * @param color -- clear frame buffer
     */
    @Override
    public void clear(int color) {

        canvas.drawRGB((color & 0xff0000) >> 16, (color & 0xff00) >> 8,
                (color & 0xff));
    }

    /**
     * The Graphics.drawPixel() method will set the pixel at (x,y) in the
     * framebuffer to the given color
     *
     * @param x     -- xcoordinate
     * @param y     -- ycoordinate
     * @param color -- color to draw pixel at that coordinate
     */
    @Override
    public void drawPixel(int x, int y, int color) {
        paint.setColor(color);
        canvas.drawPoint(x, y, paint);
    }

    /**
     * \
     * The Graphics.drawLine() method is analogous to the
     * Graphics.drawPixel() method. We specify the start point and
     * endpoint of the line, along with a
     *
     * @param x     -- point x1 coordinate
     * @param y     -- point y1 coordinate
     * @param x2    -- point x2 coordinate
     * @param y2    -- point y2 coordinate
     * @param color -- color of line
     */
    @Override
    public void drawLine(int x, int y, int x2, int y2, int color) {

        paint.setColor(color);
        canvas.drawLine(x, y, x2, y2, paint);
    }

    /**
     * The Graphics.drawRect() method draws a rectangle to the framebuffer. The
     * (x,y) specifies the position of the rectangle's top-left corner in the framebuffer.
     * The arguments width and height specify the number of pixels in x and y, and
     * the rectangle will fill starting from (x,y). We fill downward in y. The color
     * argument is the color that is used to fill the rectangle
     *
     * @param x      -- cooordinate
     * @param y      --ycoordinate
     * @param width  -- width of rct
     * @param height -- height of rct
     * @param color  -- color
     */
    @Override
    public void drawRect(int x, int y, int width, int height, int color) {

        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(x, y, x + width - 1, y + width - 1, paint);
    }

    /**
     * The Graphics.drawPixmap() method draws rectangular portions of a
     * Pixmap to the framebuffer. The (x,y) coordinates specify the top-left
     * corner’s position of the Pixmap's target location in the framebuffer. The
     * arguments srcX and srcY specify the corresponding top-left corner of
     * the rectangular region that is used from the Pixmap, given in the
     * Pixmap's own coordinate system. Finally, srcWidth and srcHeight
     * specify the size of the portion that we take from the Pixmap
     *
     * @param pixmap
     * @param x
     * @param y
     * @param srcX
     * @param srcY
     * @param srcWidth
     * @param srcHeight
     */
    @Override
    public void drawPixmap(Pixmap pixmap, int x, int y, int srcX, int srcY, int srcWidth, int srcHeight) {

        srcRect.left = srcX;
        srcRect.top = srcY;
        srcRect.right = srcX + srcWidth - 1;
        srcRect.bottom = srcY + srcHeight - 1;
        dstRect.left = x;
        dstRect.top = y;
        dstRect.right = x + srcWidth - 1;
        dstRect.bottom = y + srcHeight - 1;
        canvas.drawBitmap(((AndroidPixmap) pixmap).bitmap, srcRect, dstRect,
                null);
    }

    /**
     * The Graphics.drawPixmap() method draws rectangular portions of a
     * Pixmap to the framebuffer. The (x,y) coordinates specify the top-left
     * corner’s position of the Pixmap's target location in the framebuffer. The
     * arguments srcX and srcY specify the corresponding top-left corner of
     * the rectangular region that is used from the Pixmap, given in the
     * Pixmap's own coordinate system. Finally, srcWidth and srcHeight
     * specify the size of the portion that we take from the Pixmap
     *
     * @param pixmap
     * @param x
     * @param y
     */
    @Override
    public void drawPixmap(Pixmap pixmap, int x, int y) {

        canvas.drawBitmap(((AndroidPixmap)pixmap).bitmap, x, y, null);
    }

    @Override
    public int getWidth() {
        return frameBuffer.getWidth();
    }

    @Override
    public int getHeight() {
        return frameBuffer.getHeight();
    }
}
