package com.shopadmin.shopAdminSpringBoot.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name="member")
@Getter
@Setter
@ToString
public class MemberVo {
	@Id
	private String id;
	private String pw;
	private String phone;
	private String email;
	private String name;
	private String address;
	@Column(name="address_detail")
	private String addressDetail;
	@Column(name="signup_time")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date signupTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birth;
	private byte grade;
}
