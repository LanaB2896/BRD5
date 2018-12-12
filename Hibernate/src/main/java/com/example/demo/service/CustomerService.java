package com.example.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Users;

public interface CustomerService extends JpaRepository<Users, Integer> {

}
