package com.dx.test.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dx.test.mapper.ArticleCategoryMapper;
import com.dx.test.model.ArticleCategory;

@Repository
public class ArticleCategoryDao implements ArticleCategoryMapper {
	@Autowired
	private ArticleCategoryMapper articleCategoryMapper;

	/**
	 * 根据文章分类,查询文章分类详情
	 * @param id 文章分类id
	 * @return 查询到的文章分类详情
	 * */
	@Override
	public ArticleCategory getById(Integer id) {
		ArticleCategory articleCategory = this.articleCategoryMapper.getById(id);
		return articleCategory;
	}
	
	/**
	 * 插入文章分类
	 * @param articleCategory 插入文章分类
	 * @return 相应条数
	 * */
	@Override
	public int insert(ArticleCategory articleCategory) {
		int result= this.articleCategoryMapper.insert(articleCategory);
		return result;
	}

	@Override
	public List<ArticleCategory> queyrList(ArticleCategory articleCategory) {
		return this.articleCategoryMapper.queyrList(articleCategory);
	}

	@Override
	public int delete(Integer id) {
		return this.articleCategoryMapper.delete(id);
	}

	@Override
	public int update(ArticleCategory articleCategory) {
		return this.articleCategoryMapper.update(articleCategory);
	}
}
