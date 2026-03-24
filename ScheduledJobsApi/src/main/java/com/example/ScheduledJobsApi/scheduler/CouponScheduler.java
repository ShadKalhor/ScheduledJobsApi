package com.example.ScheduledJobsApi.scheduler;

import com.example.ScheduledJobsApi.service.CouponService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CouponScheduler {

    private final CouponService couponService;

    public CouponScheduler(CouponService couponService){
        this.couponService = couponService;
    }


    @Scheduled(cron = "0 * * * * *")
    public void deactivateExpiredCoupons(){

        couponService.deactivateExpiredCoupons();

    }

}
