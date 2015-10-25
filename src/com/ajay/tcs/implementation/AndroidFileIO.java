package com.ajay.tcs.implementation;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Environment;
import android.preference.PreferenceManager;
import com.ajay.tcs.framework.FileIO;

import java.io.*;

/**
 * Created by Ajax on 10/25/2015.
 */
public class AndroidFileIO implements FileIO {


    Context mContext;
    AssetManager mAssetsManager;
    String externalStoragePath;


    public AndroidFileIO(Context context){
        this.mContext = context;
        this.mAssetsManager = context.getAssets();
        this.externalStoragePath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;
    }



    /**
     * @param fileName - Name Of File
     * @return Assets as Input Stream
     * @throws java.io.IOException
     */
    @Override
    public InputStream readAssets(String fileName) throws IOException {
        return mAssetsManager.open(fileName);
    }

    /**
     * @param fileName - Name Of File
     * @return File as Input Stream
     * @throws java.io.IOException
     */
    @Override
    public InputStream readFile(String fileName) throws IOException {
        return new FileInputStream(externalStoragePath + fileName);
    }

    /**
     * @param fileName - Name Of File where to write
     * @return File as OutputStream
     * @throws java.io.IOException
     */
    @Override
    public OutputStream writeFile(String fileName) throws IOException {
        return new FileOutputStream(externalStoragePath +fileName);
    }


    public SharedPreferences getPreferences(){
        return PreferenceManager.getDefaultSharedPreferences(mContext);
    }
}
