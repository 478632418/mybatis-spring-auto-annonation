package com.dx.test.model;

import java.util.Date;

/**
 * 文章详情
 */
public class Article {
	private Long id; // 文章id
	private String title; // 文章标题
	private String content; // 文章内容
	private Integer categoryId; // 文章分类id

	private String createUser; // 新建用户
	private String createUserId;// 新建用户id
	private Date createTime; // 新建时间
	private String updateUser; // 修改用户
	private String updateUserId;// 修改用户id
	private Date updateTime; // 修改时间
	private Integer version; // 乐观锁版本号

	private ArticleCategory articleCategory; // [扩展字段]文章分类实体

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
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

	public ArticleCategory getArticleCategory() {
		return articleCategory;
	}

	public void setArticleCategory(ArticleCategory articleCategory) {
		this.articleCategory = articleCategory;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", content=" + content
				+ ", categoryId=" + categoryId + ", articleCategory=" + articleCategory + "]";
	}
}
