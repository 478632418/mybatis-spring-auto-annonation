package com.dx.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.test.mapper.ArticleMapper;
import com.dx.test.model.Article;
import com.dx.test.repository.ArticleDao;

@Service
public class ArticleService implements ArticleMapper{
	@Autowired
	private ArticleDao articleDao;

	/**
	 * 根据文章id，查询文章实体详情
	 * 
	 * @param id 文章id
	 * @return 返回查找文章详情
	 */
	@Override
	public Article getById(Long id) {
		return articleDao.getById(id);
	}

	@Override
	public Article getByIdWithoutCategory(Long id) {
		return this.articleDao.getByIdWithoutCategory(id);
	}

	@Override
	public List<Article> queryList(Article article) {
		return this.articleDao.queryList(article);
	}

	@Override
	public int insert(Article article) {
		return this.articleDao.insert(article);
	}

	@Override
	public int delete(Long id) {
		return this.articleDao.delete(id);
	}

	@Override
	public int update(Article article) {
		return this.articleDao.update(article);
	}
}
