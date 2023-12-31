//package com.hommies.ratelimiterforpricingwithbucket4jimpl.intercept;
//
//import com.hommies.ratelimiterforpricingwithbucket4jimpl.PricePlanningService;
//import io.github.bucket4j.Bucket;
//import io.github.bucket4j.ConsumptionProbe;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//@Component
//@RequiredArgsConstructor
//public class RateLimitInterceptor implements HandlerInterceptor {
//
//    private final PricePlanningService planningService;
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
//        String apiKey = request.getHeader("X-api-key");
//        if (apiKey == null || apiKey.isEmpty()) {
//            response.sendError(HttpStatus.BAD_REQUEST.value(), "Missing Header: X-api-key");
//            return false;
//
//        }
//
//        Bucket tokenBucket = planningService.resolveBucket(apiKey);
//        ConsumptionProbe probe = tokenBucket.tryConsumeAndReturnRemaining(1);
//        if (probe.isConsumed()) {
//            response.addHeader("X-Rate-Limit-Remaining", String.valueOf(probe.getRemainingTokens()));
//            return true;
//        } else {
//            long waitForRefill = probe.getNanosToWaitForRefill() / 1_000_000_000;
//            response.addHeader("X-Rate-Limit-Retry-After-Seconds", String.valueOf(waitForRefill));
//            response.sendError(HttpStatus.TOO_MANY_REQUESTS.value(),
//                    "You have exhausted your API Request Quota");
//            return false;
//        }
//
//    }
//}