package com.ajay.tcs.implementation;

import android.media.SoundPool;
import com.ajay.tcs.framework.Sound;

/**
 * Created by Ajax on 10/25/2015.
 */
public class AndroidSound implements Sound {


    int soundID;
    SoundPool mSoundPool;


    public AndroidSound(SoundPool mSoundPool, int soundID) {
        this.mSoundPool = mSoundPool;
        this.soundID = soundID;
    }

    @Override
    public void play(float volume) {

        mSoundPool.play(soundID , volume,volume ,0,0,1);
    }

    @Override
    public void dispose() {
        mSoundPool.unload(soundID);
    }
}
