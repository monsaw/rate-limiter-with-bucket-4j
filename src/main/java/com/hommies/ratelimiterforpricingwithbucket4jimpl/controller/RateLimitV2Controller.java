package com.hommies.ratelimiterforpricingwithbucket4jimpl.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/rate-limiter")
public class RateLimitV2Controller {

    @GetMapping("example")
    public ResponseEntity<String> getNames(){
        return ResponseEntity.ok("Loaded successfully");
    }
}
