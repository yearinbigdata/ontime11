package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.example.domain.DelayDO;
import com.example.domain.QDelayDO;
import com.example.domain.QtotalDelayDO;
import com.example.domain.totalDelayDO;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;


public interface TotalDelayRepository extends JpaRepository<totalDelayDO, Integer>, QuerydslPredicateExecutor<totalDelayDO>{


}
