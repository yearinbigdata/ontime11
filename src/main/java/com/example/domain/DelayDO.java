package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="tbl_delaycount")
@Data
public class DelayDO {
	
	@Id
	private String carrierName;
	private String arrDep;
	private String carrierCode;
	private Integer month;
	private Integer delay;

}
