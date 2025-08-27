package com.wuyinai.wuyipicturebackend.config;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import java.util.concurrent.TimeUnit;

public class LocalCacheConfig {

    //构建本地缓存，设置缓存容量和过期时间
    public static final  Cache<String,String> LOCAL_CACHE = Caffeine.newBuilder().initialCapacity(1024)
            .maximumSize(10000L)
            .expireAfterWrite(5L, TimeUnit.MINUTES)
            .build();
}