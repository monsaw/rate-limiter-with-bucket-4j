//package com.hommies.ratelimiterforpricingwithbucket4jimpl.config;
//
//
//import com.hommies.ratelimiterforpricingwithbucket4jimpl.intercept.RateLimitInterceptor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class AppConfig implements WebMvcConfigurer {
//
//
//    private final RateLimitInterceptor interceptor;
//
//    public AppConfig(RateLimitInterceptor interceptor) {
//        this.interceptor = interceptor;
//    }
//
//    @Override
//        public void addInterceptors(InterceptorRegistry registry) {
//            registry.addInterceptor(interceptor)
//                    .addPathPatterns("/api/v1/rate-limiter/**");
//
//        }
//    }

