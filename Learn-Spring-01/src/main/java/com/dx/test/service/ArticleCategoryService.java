package com.dx.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.test.mapper.ArticleCategoryMapper;
import com.dx.test.model.ArticleCategory;
import com.dx.test.repository.ArticleCategoryDao;

@Service
public class ArticleCategoryService implements ArticleCategoryMapper {
	@Autowired
	private ArticleCategoryDao articleCategoryDao;
	
	/**
	 * 根据文章分类,查询文章分类详情
	 * @param id 文章分类id
	 * @return 查询到的文章分类详情
	 * */
	@Override
	public ArticleCategory getById(Integer id) {
		ArticleCategory articleCategory = this.articleCategoryDao.getById(id);
		return articleCategory;
	}

	@Override
	public int insert(ArticleCategory articleCategory) {
		return this.articleCategoryDao.insert(articleCategory);
	}

	@Override
	public List<ArticleCategory> queyrList(ArticleCategory articleCategory) {
		return this.articleCategoryDao.queyrList(articleCategory);
	}

	@Override
	public int delete(Integer id) {
		return this.articleCategoryDao.delete(id);
	}

	@Override
	public int update(ArticleCategory articleCategory) {
		return this.articleCategoryDao.update(articleCategory);
	}
}
