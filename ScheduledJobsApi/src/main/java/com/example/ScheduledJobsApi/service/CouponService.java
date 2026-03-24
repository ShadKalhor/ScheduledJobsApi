package com.example.ScheduledJobsApi.service;

import com.example.ScheduledJobsApi.entity.Coupon;
import com.example.ScheduledJobsApi.exception.ErrorType;
import com.example.ScheduledJobsApi.exception.StructuredError;
import com.example.ScheduledJobsApi.repository.CouponJPARepository;
import io.vavr.control.Either;
import io.vavr.control.Try;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CouponService {


    private final CouponJPARepository couponJPA;

    public CouponService(CouponJPARepository couponJPA){
        this.couponJPA = couponJPA;
    }

    public Either<StructuredError, Void> save(Coupon coupon){
        return Try.run(() -> couponJPA.save(coupon)).toEither().mapLeft(throwable -> new StructuredError("Failed To save Entity", ErrorType.SERVER_ERROR));
    }


    public Page<Coupon> findAll(Pageable pageable) {
        return couponJPA.findAll(pageable);
    }

    public Page<Coupon> findAllActive(Pageable pageable) {
        return couponJPA.findByActiveTrue(pageable);
    }

    public void deactivateExpiredCoupons() {
        LocalDateTime now = LocalDateTime.now();

        List<Coupon> expiredCoupons =
                couponJPA.findByExpiryDateTimeBeforeAndActiveTrue(now);

        if (expiredCoupons.isEmpty()) {
            System.out.println("No expired coupons found");
            return;
        }

        for (Coupon coupon : expiredCoupons) {
            coupon.setActive(false);
        }

        couponJPA.saveAll(expiredCoupons);

        System.out.println("Deactivated " + expiredCoupons.size() + " coupons");


    }
}
