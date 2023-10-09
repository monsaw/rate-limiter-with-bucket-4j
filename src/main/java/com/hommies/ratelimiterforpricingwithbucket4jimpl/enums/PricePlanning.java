package com.hommies.ratelimiterforpricingwithbucket4jimpl.enums;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Refill;

import java.time.Duration;

 public enum PricePlanning {

    FREE {
        public  Bandwidth getLimit(){
            return Bandwidth.classic(10, Refill.intervally(10, Duration.ofMinutes(1)));
        }
    },

    BASIC {
        public Bandwidth getLimit(){
            return Bandwidth.classic(20, Refill.intervally(20, Duration.ofMinutes(1)));
        }
    },

    PROFESSIONAL {
        public  Bandwidth getLimit(){
            return Bandwidth.classic(40, Refill.intervally(40, Duration.ofMinutes(1)));
        }
    };



    public static PricePlanning resolvePricePlanningFromApiKey(String apiKey){
        if(apiKey == null || apiKey.isEmpty())
            return FREE;
        else if (apiKey.startsWith("BASIC")) {
            return BASIC;
        } else if (apiKey.startsWith("PROF")) {
            return PROFESSIONAL;
        }
        return FREE;
    }

}
