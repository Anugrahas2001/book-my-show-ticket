package com.demo.myticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.myticket.entity.UserInfo;

public interface UserRepository extends JpaRepository<UserInfo, Integer>{

}
