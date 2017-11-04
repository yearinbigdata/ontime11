package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.example.domain.DelayDO;
import com.example.domain.QDelayDO;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;


public interface DelayRepository extends JpaRepository<DelayDO, Integer>, QuerydslPredicateExecutor<DelayDO>{
	
	public default Predicate makePredicate(String type, String keyword){
	
		BooleanBuilder builder = new BooleanBuilder();
		QDelayDO delay = QDelayDO.delayDO;
		
		builder.and(delay.carrierName.gt("0"));
		
		if(type==null){
			return builder;
		}
		
		switch(type){
		
		case "n":
			builder.and(delay.carrierName.like("%" + keyword + "%"));
			break;
		case "c":
			builder.and(delay.carrierCode.like("%" + keyword + "%"));
			break;
		case "m":
			builder.and(delay.month.like("%" + keyword + "%"));
			break;
		case "ad":
			builder.and(delay.arrDep.like("%" + keyword + "%"));
			break;
		}
		
		return builder;
	
	}
	

}
