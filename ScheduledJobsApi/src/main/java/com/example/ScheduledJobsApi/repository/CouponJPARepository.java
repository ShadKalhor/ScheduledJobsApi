package com.example.ScheduledJobsApi.repository;

import com.example.ScheduledJobsApi.entity.Coupon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface CouponJPARepository extends JpaRepository<Coupon, UUID> {
    Page<Coupon> findByActiveTrue(Pageable pageable);
    List<Coupon> findByExpiryDateTimeBeforeAndActiveTrue(LocalDateTime now);

}
