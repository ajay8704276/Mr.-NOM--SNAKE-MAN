package com.ajay.tcs.framework;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Ajax on 10/24/2015.
 */
public interface FileIO {

    /**
     *
     * @param fileName - Name Of File
     * @return Assets as Input Stream
     * @throws IOException
     */
    public InputStream readAssets(String fileName) throws IOException;

    /**
     *
     * @param fileName - Name Of File
     * @return File as Input Stream
     * @throws IOException
     */
    public InputStream readFile(String fileName) throws IOException;

    /**
     *
     * @param fileName - Name Of File where to write
     * @return File as OutputStream
     * @throws IOException
     */
    public OutputStream writeFile(String fileName) throws IOException;
}
