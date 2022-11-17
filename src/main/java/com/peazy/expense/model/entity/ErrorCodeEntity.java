package com.peazy.expense.model.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Common_ErrorCode", schema = "alanlee")
public class ErrorCodeEntity {

	@Id
	@GeneratedValue
	private Long seqNo;
	private String category;
	private String errorCode;
	private String errorMsg;
	private String lang;
	private String createUser;
	private Date createDt;
	private String updateUser;
	private Date updateDt;

}