package com.ajay.tcs.implementation;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import com.ajay.tcs.framework.Music;

import java.io.IOException;

/**
 * Created by Ajax on 10/25/2015.
 */
public class AndroidMusic implements Music ,MediaPlayer.OnCompletionListener {


    MediaPlayer mMediaPlayer;
    boolean isPrepared = false;

    public AndroidMusic(AssetFileDescriptor mAssetsFileDescriptor) {

        mMediaPlayer = new MediaPlayer();
        try {
            mMediaPlayer.setDataSource(mAssetsFileDescriptor.getFileDescriptor(),
                    mAssetsFileDescriptor.getStartOffset(),
                    mAssetsFileDescriptor.getLength());
            mMediaPlayer.prepare();
            isPrepared = true;
            mMediaPlayer.setOnCompletionListener(this);

        }catch (Exception e){
            throw  new RuntimeException("Couldnot load Music");
        }
    }

    @Override
    public void play() {

        if (mMediaPlayer.isPlaying())
            return;
        try {
            synchronized (this) {
                if (!isPrepared) {
                    mMediaPlayer.prepare();
                }
                mMediaPlayer.start();
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {

        mMediaPlayer.stop();
        synchronized (this){
            isPrepared = false;
        }
    }

    @Override
    public void pause() {

        if(mMediaPlayer.isPlaying()){
            mMediaPlayer.pause();
        }
    }

    @Override
    public void setLooping(boolean looping) {

        mMediaPlayer.setLooping(isLooping());
    }

    @Override
    public void setVolume(float volume) {
        mMediaPlayer.setVolume(volume,volume);
    }

    @Override
    public boolean isPlaying() {
        return mMediaPlayer.isPlaying();
    }

    @Override
    public boolean isStopped() {
        return !isPrepared;
    }

    @Override
    public boolean isLooping() {
        return mMediaPlayer.isLooping();
    }

    @Override
    public void dispose() {

        if (mMediaPlayer.isPlaying()) {
            mMediaPlayer.stop();
        }
        mMediaPlayer.release();
    }

    /**
     * Called when the end of a media source is reached during playback.
     *
     * @param mp the MediaPlayer that reached the end of the file
     */
    @Override
    public void onCompletion(MediaPlayer mp) {
        synchronized (this){
            isPrepared = false;
        }
    }
}
