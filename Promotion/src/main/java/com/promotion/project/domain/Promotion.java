package com.promotion.project.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="promotion")
public class Promotion {
	@Id
	@GeneratedValue
	int promotionid;
	String title;
	String imgurl;
	public int getPromotionid() {
		return promotionid;
	}
	public void setPromotionid(int promotionid) {
		this.promotionid = promotionid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
}
