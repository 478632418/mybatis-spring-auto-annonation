package com.dx.test;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dx.test.model.ArticleCategory;
import com.dx.test.service.ArticleCategoryService;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-config.xml" })
public class AppTest {
	@Autowired
	private ArticleCategoryService articleCategoryService;
	private ArticleCategory articleCategory;
	private final String title = "category test title";
	private final String titleNew = "category test title new";

	@Before
	public void testArticleCategoryCreate() {
		ArticleCategory articleCategory = new ArticleCategory();
		articleCategory.setTitle(title);
		articleCategory.setDescription("category description");
		articleCategory.setImgSrc("http://www.test.com/img/category/img-" + new Random().nextInt(1000) + ".gif");
		articleCategory.setCreateTime(new Date());
		articleCategory.setCreateUser("create user");
		articleCategory.setCreateUserId("user-" + new Random().nextInt(1000));

		int result = this.articleCategoryService.insert(articleCategory);
		this.articleCategory = articleCategory;
		Assert.assertEquals(result, 1);
	}

	@Test
	public void testSelectById() {
		ArticleCategory articleCategory = this.articleCategoryService.getById(this.articleCategory.getId());
		Assert.assertEquals(articleCategory.getId(), this.articleCategory.getId());
		Assert.assertEquals(articleCategory.getTitle(), this.title);
	}

	@Test
	public void testQueryList() {
		ArticleCategory queryArticleCategory = new ArticleCategory();
		queryArticleCategory.setTitle("test");

		List<ArticleCategory> queryResultList = this.articleCategoryService.queyrList(queryArticleCategory);
		Assert.assertFalse(queryResultList.size() == 0);
	}

	@Test
	public void testUpdate() {
		ArticleCategory articleCategory = this.articleCategoryService.getById(this.articleCategory.getId());
		Assert.assertEquals(articleCategory.getId(), this.articleCategory.getId());
		Assert.assertEquals(articleCategory.getTitle(), this.title);

		articleCategory.setTitle(this.titleNew);
		int result=this.articleCategoryService.update(articleCategory);
		Assert.assertEquals(result, 1);
		
		articleCategory = this.articleCategoryService.getById(this.articleCategory.getId());
		Assert.assertEquals(articleCategory.getId(), this.articleCategory.getId());
		Assert.assertEquals(articleCategory.getTitle(), this.title);
	}

	@After
	public void testDelete() {
		int result = this.articleCategoryService.delete(this.articleCategory.getId());
		Assert.assertEquals(result, 1);
	}
}
