package com.example.ecommerceapp;

import android.app.Application;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initializeFresco();
    }

    private void initializeFresco() {
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                .setMainDiskCacheConfig(DiskCacheConfig.newBuilder(this).build())
                .setDownsampleEnabled(true)
                .build();
        Fresco.initialize(this, config);
    }
}
