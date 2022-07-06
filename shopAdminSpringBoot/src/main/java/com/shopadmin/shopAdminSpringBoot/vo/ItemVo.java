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
@Table(name="item")
@Getter
@Setter
@ToString
public class ItemVo {
	@Id
	@Column(name="item_num")
	private int itemNum;
	private String name;
	private String title;
	private int count;
	private int price;
	private String color;
	@Column(name="main_img", nullable= true, insertable = false, updatable =false)
	private String mainImg;
	@Column(name="detail_img", nullable= true, insertable = false, updatable =false)
	private String detailImg;
	@Column(name="model_num")
	private String modelNum;
	@Column(name="member_id")
	private String memberId;
	@Column(name="post_time")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date postTime;
	@Column(name="sale_time")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date saleTime;
	@Column(name="sale_end_time")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date saleEndTime;
	private byte state;
	@Column(name="cate_num")
	private int cateNum;
}
