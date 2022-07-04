package com.shopadmin.shopAdminSpringBoot.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="category")
@Getter
@Setter
@ToString
public class CategoryVo {
	@Id
	@Column(name="cate_num")
	 private int cateNum;
	 private String name;
	 @Column(insertable = false, updatable = false)
	 private Integer sub;
}
