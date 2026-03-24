package com.example.ScheduledJobsApi.repository;

import com.example.ScheduledJobsApi.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CouponJPARepository extends JpaRepository<Coupon, UUID> {
}
