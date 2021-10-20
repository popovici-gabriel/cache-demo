package com.cache.cachedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "cache")
public class CacheService {

    public static final Logger LOGGER = LoggerFactory.getLogger(CacheService.class);

    @Cacheable
    public String getImageId(Integer imageId) {
        LOGGER.info(">>>>>>>>>>>> TEST");
        return imageId.toString();
    }
}
