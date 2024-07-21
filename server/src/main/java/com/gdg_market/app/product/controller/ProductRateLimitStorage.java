package com.gdg_market.app.product.controller;


import com.gdg_market.app.bible.exception.TooManyRequestsException;
import com.google.common.util.concurrent.RateLimiter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ProductRateLimitStorage {

    private final int totalRateLimiterCount = 1000;
    private final Map<Long, RateLimiter> rateLimitMap = new ConcurrentHashMap<>();

    //근데 이거 큐를 쓰는게 나은듯 ? ? ? -> LRU 알고리즘
    // 성능 테스트라는게 ->
    // 메모리를 최대한 작게
    // sre jmeter 지표에 대한 의미
    // cpu 캐시 히트
    // 이게 cpu 가 부족할 것 같다.
    // 부하 테스트 툴

    public ProductRateLimitStorage() {
        rateLimitMap.put(1L, RateLimiter.create(1.0 / 60.0));
    }

    public void validateRateLimitAvailable(Long userId){

        RateLimiter rateLimiter = rateLimitMap.get(userId);
        if(rateLimiter == null) {
            rateLimitMap.put(userId, RateLimiter.create(1.0 / 60.0));
            return;
        }
        if (!rateLimiter.tryAcquire()) {
            throw new TooManyRequestsException("Too many request exception");
        }

    }

    private void clearCache(){
        int size = rateLimitMap.size();
        if(size == totalRateLimiterCount);

    }


    @Scheduled(cron = "0 0 0 * * ?")
    public void test(){  // 이걸 좀 처리하자


    }


}
