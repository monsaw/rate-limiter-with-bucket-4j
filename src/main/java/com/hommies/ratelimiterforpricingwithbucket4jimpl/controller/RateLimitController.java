package com.hommies.ratelimiterforpricingwithbucket4jimpl.controller;


import com.hommies.ratelimiterforpricingwithbucket4jimpl.PricePlanningService;
import com.hommies.ratelimiterforpricingwithbucket4jimpl.enums.PricePlanning;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.ConsumptionProbe;
import io.github.bucket4j.Refill;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
@RequestMapping("/api/v1/rate-limiter")
public class RateLimitController {

   // @Autowired
//    public final Bucket bucket;
//    public final PricePlanningService service;


//    public RateLimitController(PricePlanningService service) {
//        this.service = service;
//
//        Bandwidth limit = Bandwidth.classic(10, Refill.greedy(10, Duration.ofMillis(20)));
//
//        this.bucket = Bucket.builder()
//                .addLimit(limit)
//        .build();
//    }


    @GetMapping("example")
    public ResponseEntity<String> getNames(){
       return ResponseEntity.ok("Loaded successfully");
    }

//        Bucket limit = service.resolveBucket(apiKey);
//        ConsumptionProbe probe = limit.tryConsumeAndReturnRemaining(1);
//        if(probe.isConsumed()) {
//            return ResponseEntity.ok()
//                    .header("X-Rate-Limit-Remaining", Long.toString(probe.getRemainingTokens()))
//                    .body("Loaded Successfully");
//        }
//
//        long waitForRefill = probe.getNanosToWaitForRefill() / 1_000_000_000 ;
//        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
//                .header("X-Rate-Limit-Retry-After-Seconds",
//                        String.valueOf(waitForRefill)).
//                build();
//    }
}
