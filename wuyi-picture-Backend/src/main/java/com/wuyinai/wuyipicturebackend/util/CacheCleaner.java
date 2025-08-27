package com.wuyinai.wuyipicturebackend.util;

import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

import static com.wuyinai.wuyipicturebackend.config.LocalCacheConfig.LOCAL_CACHE;

@Component
public class CacheCleaner {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    // 图片列表缓存前缀
    public static final String PICTURE_LIST_CACHE_PREFIX = "wuyinai:listPictureVOByPage";

    /**
     * 清理图片相关的所有缓存
     */
    public void cleanPictureCaches() {
        // 清理本地缓存
        cleanLocalPictureCaches();
        
        // 清理Redis缓存
        cleanRedisPictureCaches();
    }

    /**
     * 清理本地缓存中图片相关的缓存
     */
    private void cleanLocalPictureCaches() {
        // 假设LOCAL_CACHE是一个ConcurrentHashMap或类似的本地缓存实现
        Set<String> keysToRemove = new HashSet<>();
        for (String key : LOCAL_CACHE.asMap().keySet()) {
            if (key.startsWith(PICTURE_LIST_CACHE_PREFIX)) {
                keysToRemove.add(key);
            }
        }
        // 批量删除
        for (String key : keysToRemove) {
            LOCAL_CACHE.invalidate(key);
        }
    }

    /**
     * 清理Redis中图片相关的缓存
     */
    private void cleanRedisPictureCaches() {
        // 使用scan代替keys，避免生产环境性能问题
        ScanOptions options = ScanOptions.scanOptions()
                .match(PICTURE_LIST_CACHE_PREFIX + "*")
                .count(1000)
                .build();

        RedisConnection connection = stringRedisTemplate.getConnectionFactory().getConnection();
        Cursor<byte[]> cursor = connection.scan(options);
        
        try {
            while (cursor.hasNext()) {
                byte[] keyBytes = cursor.next();
                stringRedisTemplate.delete(new String(keyBytes, StandardCharsets.UTF_8));
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}