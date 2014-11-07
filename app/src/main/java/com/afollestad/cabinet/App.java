package com.afollestad.cabinet;

import android.app.Application;

import com.afollestad.cabinet.utils.APKIconDownloader;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

/**
 * @author Aidan Follestad (afollestad)
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
                .defaultDisplayImageOptions(getDisplayOptions(0))
                .imageDownloader(new APKIconDownloader(this))
                .build();
        ImageLoader.getInstance().init(config);
    }

    public static DisplayImageOptions getDisplayOptions(int fallback) {
        if (fallback == 0) fallback = R.drawable.ic_file_image;
        return new DisplayImageOptions.Builder()
                .resetViewBeforeLoading(true)
                .showImageOnLoading(fallback)                                   // set the default image while loading the thumb
                .displayer(new RoundedBitmapDisplayer(20))                      // rounds the corners of the thumb to match the style of the other icons
                .showImageForEmptyUri(fallback)
                .showImageOnFail(fallback)
                .cacheInMemory(true)
                .cacheOnDisk(false)
                .build();
    }

}
