package com.ajay.tcs.framework;

import java.io.IOException;

/**
 * Created by Ajax on 10/24/2015.
 */
public interface Audio {


    /**
     * A Music instance represents a streamed audio file
     * @param fileName - name music file
     * @return instance of Music
     */
    public Music newMusic(String fileName) throws IOException;

    /**
     * A Sound instance represents a short sound
     effect that we keep entirely in memory
     * @param fileNam- name of Sound file
     * @return instance of sound
     */
    public Sound newSound(String fileNam) throws IOException
;}
