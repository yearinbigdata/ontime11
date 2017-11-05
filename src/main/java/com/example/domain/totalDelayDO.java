package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="tbl_totaldelay")
@Data
public class totalDelayDO {
	
	@Id
	private String carriername;
	private String carriercode;
	private Integer delay;

}
