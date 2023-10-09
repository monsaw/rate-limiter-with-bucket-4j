package com.hommies.ratelimiterforpricingwithbucket4jimpl;

import com.hommies.ratelimiterforpricingwithbucket4jimpl.enums.PricePlanning;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

@Service
public class PricePlanningService {

    public final Map<String, Bucket> cache = new ConcurrentHashMap<>();


    public Bucket resolveBucket(String apiKey){
      return cache.computeIfAbsent(apiKey, this::newBucket);
    }

    private  Bucket newBucket(String apiKey) {
       // PricePlanning limit = PricePlanning.resolvePricePlanningFromApiKey(apiKey);
        Bandwidth limit = returnBandWidth(apiKey);
        return Bucket.builder().
            addLimit(limit)
        .build();
    }

    private Bandwidth returnBandWidth(String apiKey){

        if(apiKey.isEmpty()){
            return Bandwidth.classic(10, Refill.intervally(10, Duration.ofMinutes(1)));
        }
        else if (apiKey.startsWith("BASIC")) {
            return Bandwidth.classic(20, Refill.intervally(20, Duration.ofMinutes(1)));

        } else if (apiKey.startsWith("PROF")) {
            return Bandwidth.classic(40, Refill.intervally(40, Duration.ofMinutes(1)));
        }
        return Bandwidth.classic(10, Refill.intervally(10, Duration.ofMinutes(1)));

    }


}





