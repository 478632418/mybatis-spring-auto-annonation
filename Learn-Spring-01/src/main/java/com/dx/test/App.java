package com.dx.test;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dx.test.model.Article;
import com.dx.test.model.ArticleCategory;
import com.dx.test.service.ArticleCategoryService;
import com.dx.test.service.ArticleService;

/**
 * Hello SpringFramework!
 */
public class App {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
		ArticleService articleService = applicationContext.getBean(ArticleService.class);
		ArticleCategoryService articleCategoryService = applicationContext.getBean(ArticleCategoryService.class);
		
		ArticleCategory articleCategory=new ArticleCategory();
		articleCategory.setTitle("test category");
		articleCategory.setImgSrc("http://im.dic/img/abd.gif");
		articleCategory.setDescription("description");
		articleCategory.setCreateUser("test");
		articleCategory.setCreateUserId("11");
		articleCategory.setCreateTime(new Date());
		articleCategoryService.insert(articleCategory);
		
		Article waitingInsertArticle=new Article();
		waitingInsertArticle.setCategoryId(articleCategory.getId());
		waitingInsertArticle.setTitle("test");
		waitingInsertArticle.setContent("test content");
		waitingInsertArticle.setCreateUser("test");
		waitingInsertArticle.setCreateUserId("11");
		waitingInsertArticle.setCreateTime(new Date());
		
		int result=articleService.insert(waitingInsertArticle);
		System.out.println(result);
		
		Article article = articleService.getById(waitingInsertArticle.getId());
		System.out.println(article);
	}
}
