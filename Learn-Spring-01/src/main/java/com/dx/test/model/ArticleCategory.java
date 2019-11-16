package com.dx.test.model;

import java.util.Date;

/**
 * 文章分类
 * */
public class ArticleCategory {
	private Integer id; //文章分类id
	private String title; // 文章分类名称
	private String imgSrc; // 文章分类banner图片
	private String description; // 文章分类描述

	private String createUser; // 新建用户
	private String createUserId;// 新建用户id
	private Date createTime; // 新建时间
	private String updateUser; // 修改用户
	private String updateUserId;// 修改用户id
	private Date updateTime; // 修改时间
	private Integer version; // 乐观锁版本号
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImgSrc() {
		return imgSrc;
	}
	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public String getUpdateUserId() {
		return updateUserId;
	}
	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	@Override
	public String toString() {
		return "ArticleCategory [id=" + id + ", title=" + title + ", imgSrc=" + imgSrc + ", description=" + description
				+ "]";
	}
}
