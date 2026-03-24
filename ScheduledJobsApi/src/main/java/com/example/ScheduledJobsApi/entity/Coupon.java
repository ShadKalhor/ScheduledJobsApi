package com.example.ScheduledJobsApi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "coupons")
public class Coupon {

    @Id
    private UUID id;
    @Column(nullable = false, unique = true)
    private String code;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigInteger discount;
    @Column(nullable = false)
    private LocalDateTime expiryDateTime;
    @Column(nullable = false)
    private boolean active;


    @PrePersist
    public void prePersist(){
        if (id == null)
            id = UUID.randomUUID();
    }

}
