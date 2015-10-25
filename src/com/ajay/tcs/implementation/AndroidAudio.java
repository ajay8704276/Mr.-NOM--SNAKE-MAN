package com.ajay.tcs.implementation;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import com.ajay.tcs.framework.Audio;
import com.ajay.tcs.framework.Music;
import com.ajay.tcs.framework.Sound;

import java.io.IOException;

/**
 * Created by Ajax on 10/25/2015.
 */
public class AndroidAudio implements Audio {

    AssetManager mAssetsManager;
    SoundPool mSoundPool;



    public AndroidAudio(Activity mActivity){

        mActivity.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        this.mAssetsManager = mActivity.getAssets();
        this.mSoundPool = new SoundPool(20,AudioManager.STREAM_MUSIC,0);
    }
    /**
     * A Music instance represents a streamed audio file
     *
     * @param fileName - name music file
     * @return instance of Music
     */
    @Override
    public Music newMusic(String fileName) throws IOException {
        try {
            AssetFileDescriptor mAssetsFileDescriptor = mAssetsManager.openFd(fileName);
            return new AndroidMusic(mAssetsFileDescriptor);
        }catch (IOException ie){
            throw  new RuntimeException("couldnot load Music" + fileName + ".");
        }
    }

    /**
     * A Sound instance represents a short sound
     * effect that we keep entirely in memory
     *
     * @param fileNam - name of Sound file
     * @return instance of sound
     */
    @Override
    public Sound newSound(String fileNam) throws IOException {
        try {
            AssetFileDescriptor mAssetsFileDescriptor = mAssetsManager.openFd(fileNam);
            int soundID = mSoundPool.load(mAssetsFileDescriptor,0);
            return new AndroidSound(mSoundPool,soundID);
        }catch (IOException ie){
            throw new RuntimeException(" Couldnot Load Sound "+ fileNam +".");
        }
    }
}
