package com.hommies.ratelimiterforpricingwithbucket4jimpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RateLimiterForPricingWithBucket4jImplApplication {

    public static void main(String[] args) {
        SpringApplication.run(RateLimiterForPricingWithBucket4jImplApplication.class, args);
    }

}
