package com.example.ScheduledJobsApi.controller;

import com.example.ScheduledJobsApi.entity.Coupon;
import com.example.ScheduledJobsApi.exception.ErrorStructureException;
import com.example.ScheduledJobsApi.service.CouponService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/coupons")
public class CouponController {


    private final CouponService couponService;

    public CouponController(CouponService couponService){
        this.couponService = couponService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void postBook(@RequestBody @Valid Coupon coupon){

        couponService.save(coupon).getOrElseThrow(ErrorStructureException::new);

    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Page<Coupon> getAllPages(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "0") int size,
                                    @RequestParam(defaultValue = "id") String sortBy,
                                    @RequestParam(defaultValue = "0") boolean ascending){

        Sort sort = ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return couponService.findAll(pageable);

    }


    @GetMapping("/active")
    @ResponseStatus(HttpStatus.OK)
    public Page<Coupon> getAllActivePages(
                                          @RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "0") int size,
                                          @RequestParam(defaultValue = "0") String sortBy,
                                          @RequestParam(defaultValue = "0") boolean ascending){
        Sort sort = ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return couponService.findAllActive(pageable);
    }



}
