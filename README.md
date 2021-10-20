# cache-demo
quick redis cache demo

{code}
When run this is what I see
localhost:9096/actuator/beans

  "cacheManager": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.data.redis.cache.RedisCacheManager",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/cache/RedisCacheConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.cache.RedisCacheConfiguration",
                        "spring.cache-org.springframework.boot.autoconfigure.cache.CacheProperties",
                        "cacheManagerCustomizers",
                        "redisConnectionFactory",
                        "org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebServerApplicationContext@4c1469ac"
                    ]
                },

localhost:9096/actuator/caches

{
    "cacheManagers": {
        "cacheManager": {
            "caches": {
                "cache": {
                    "target": "org.springframework.data.redis.cache.DefaultRedisCacheWriter"
                }
            }
        }
    }
}

using @cacheConfig and CacheServer 


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

When doing curl --location --request GET 'localhost:9096/image/1' few times 


2021-10-20 11:27:26.936  INFO 12145 --- [or-http-epoll-4] com.cache.cachedemo.CacheService         : >>>>>>>>>>>> TEST
2021-10-20 11:27:32.033  INFO 12145 --- [or-http-epoll-6] com.cache.cachedemo.CacheService         : >>>>>>>>>>>> TEST
2021-10-20 11:27:38.590  INFO 12145 --- [or-http-epoll-9] com.cache.cachedemo.CacheService         : >>>>>>>>>>>> TEST
2021-10-20 11:27:43.271  INFO 12145 --- [r-http-epoll-11] com.cache.cachedemo.CacheService         : >>>>>>>>>>>> TEST


{code}

