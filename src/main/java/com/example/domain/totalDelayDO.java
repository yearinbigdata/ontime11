package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="tbl_totalDelay")
@Data
public class totalDelayDO {
	
	@Id
	private String carrierName;
	private String carrierCode;
	private Integer delay;

}
