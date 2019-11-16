package com.dx.test.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dx.test.mapper.ArticleMapper;
import com.dx.test.model.Article;

@Repository
public class ArticleDao implements ArticleMapper {
	@Autowired()
	private ArticleMapper articleMapper;

	/**
	 * 根据文章id，查询文章详情实体
	 * 
	 * @param id 文章id
	 * @return 返回查找到的文章详情
	 */
	@Override
	public Article getById(Long id) {
		return this.articleMapper.getById(id);
	}

	@Override
	public Article getByIdWithoutCategory(Long id) {
		return this.articleMapper.getByIdWithoutCategory(id);
	}

	@Override
	public List<Article> queryList(Article article) {
		return this.articleMapper.queryList(article);
	}

	@Override
	public int insert(Article article) {
		return this.articleMapper.insert(article);
	}

	@Override
	public int delete(Long id) {
		return this.articleMapper.delete(id);
	}

	@Override
	public int update(Article article) {
		return this.update(article);
	}

}
