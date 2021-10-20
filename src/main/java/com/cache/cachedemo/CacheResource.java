package com.cache.cachedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/image")
public class CacheResource {

    private final CacheDemo cacheDemo;

    static final String IMAGE_ID_PARAM = "imageId";

    static final String IMAGE_ID_PATH = "/{" + IMAGE_ID_PARAM + "}";

    @Autowired
    public CacheResource(CacheDemo cacheDemo) {
        this.cacheDemo = cacheDemo;
    }

    @GetMapping(value = IMAGE_ID_PATH)
    public String get(@PathVariable(name = IMAGE_ID_PARAM) Integer imageId) {
        return cacheDemo.getImageId(imageId);
    }

}
