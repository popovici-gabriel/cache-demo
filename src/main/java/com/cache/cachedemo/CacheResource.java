package com.cache.cachedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/image")
public class CacheResource {

    private final CacheService cacheService;

    static final String IMAGE_ID_PARAM = "imageId";

    static final String IMAGE_ID_PATH = "/{" + IMAGE_ID_PARAM + "}";

    @Autowired
    public CacheResource(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @GetMapping(value = IMAGE_ID_PATH)
    public String get(@PathVariable(name = IMAGE_ID_PARAM) Integer imageId) {
        return cacheService.getImageId(imageId);
    }

}
