package com.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="tbl_delaycount")
@Data
public class DelayDO {
	
	@Id
	@Column(name="carrierName")
	private String carrierName;
	@Column(name="arrDep")
	private String arrDep;
	@Column(name="carriercode")
	private String carrierCode;
	private Integer month;
	private Integer delay;

}
