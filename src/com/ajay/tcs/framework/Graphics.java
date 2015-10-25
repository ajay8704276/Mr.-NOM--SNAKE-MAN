package com.ajay.tcs.framework;

/**
 * Created by Ajax on 10/25/2015.
 */
public interface Graphics {

    /**
     * enums of different pixel format
     */
    public static enum PixmapFormat {
        ARGB8888, ARGB4444, RGB565
    }


    /**
     * The Graphics.newPixmap() method will load an image given in either
     JPEG or PNG format
     * @param fileName
     * @param format
     * @return
     */
    public Pixmap newPixmap(String fileName, PixmapFormat format);


    /**
     *The Graphics.clear() method clears the complete framebuffer with the given
     color
     * @param color-- clear frame buffer
     */
    public void clear(int color);


    /**
     *The Graphics.drawPixel() method will set the pixel at (x,y) in the
     framebuffer to the given color
     * @param x-- xcoordinate
     * @param y-- ycoordinate
     * @param color -- color to draw pixel at that coordinate
     */
    public void drawPixel(int x, int y, int color);

    /**\
     *The Graphics.drawLine() method is analogous to the
     Graphics.drawPixel() method. We specify the start point and
     endpoint of the line, along with a
     * @param x -- point x1 coordinate
     * @param y -- point y1 coordinate
     * @param x2 -- point x2 coordinate
     * @param y2 -- point y2 coordinate
     * @param color -- color of line
     */
    public void drawLine(int x, int y, int x2, int y2, int color);

    /**
     *The Graphics.drawRect() method draws a rectangle to the framebuffer. The
     (x,y) specifies the position of the rectangle's top-left corner in the framebuffer.
     The arguments width and height specify the number of pixels in x and y, and
     the rectangle will fill starting from (x,y). We fill downward in y. The color
     argument is the color that is used to fill the rectangle
     * @param x -- cooordinate
     * @param y --ycoordinate
     * @param width -- width of rct
     * @param height-- height of rct
     * @param color -- color
     */
    public void drawRect(int x, int y, int width, int height, int color);

    /**
     *The Graphics.drawPixmap() method draws rectangular portions of a
     Pixmap to the framebuffer. The (x,y) coordinates specify the top-left
     corner’s position of the Pixmap's target location in the framebuffer. The
     arguments srcX and srcY specify the corresponding top-left corner of
     the rectangular region that is used from the Pixmap, given in the
     Pixmap's own coordinate system. Finally, srcWidth and srcHeight
     specify the size of the portion that we take from the Pixmap
     * @param pixmap
     * @param x
     * @param y
     * @param srcX
     * @param srcY
     * @param srcWidth
     * @param srcHeight
     */
    public void drawPixmap(Pixmap pixmap, int x, int y, int srcX, int srcY,
                               int srcWidth, int srcHeight);


    /**
     *The Graphics.drawPixmap() method draws rectangular portions of a
     Pixmap to the framebuffer. The (x,y) coordinates specify the top-left
     corner’s position of the Pixmap's target location in the framebuffer. The
     arguments srcX and srcY specify the corresponding top-left corner of
     the rectangular region that is used from the Pixmap, given in the
     Pixmap's own coordinate system. Finally, srcWidth and srcHeight
     specify the size of the portion that we take from the Pixmap
     * @param pixmap
     * @param x
     * @param y
     */
    public void drawPixmap(Pixmap pixmap, int x, int y);


    public int getWidth();


    public int getHeight();
}
