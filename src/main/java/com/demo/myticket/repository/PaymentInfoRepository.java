package com.demo.myticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.myticket.entity.PaymentInfo;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, Integer>{

}
