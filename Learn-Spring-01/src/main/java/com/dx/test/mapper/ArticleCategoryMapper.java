package com.dx.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.dx.test.mapper.sqlprovider.ArticleCategorySqlProvider;
import com.dx.test.model.ArticleCategory;

@Mapper
public interface ArticleCategoryMapper {
	/**
	 * 根据文章分类id,查询文件分类详情
	 * @param id 文章分类id
	 * @return 查询到的文章分类详情
	 * */
	@Options(useCache = true, flushCache = Options.FlushCachePolicy.FALSE, timeout = 60000)
	@Results(id="articleCategoryResult",value = {
			@Result(property = "id",column = "id",id = true),
			@Result(property = "title",column = "title"),
			@Result(property = "imgSrc",column = "img_src"),
			@Result(property = "description",column = "description"),
			@Result(property = "createUser",column = "create_user"),
			@Result(property = "createUserId",column = "create_user_id"),
			@Result(property = "createTime",column = "create_time"),
			@Result(property = "updateUser",column = "update_user"),
			@Result(property = "updateUserId",column = "update_user_id"),
			@Result(property = "updateTime",column = "update_time"),
			@Result(property = "version",column = "version")
	})
	@Select("select * from article_category where id=#{id}")
	ArticleCategory getById(Integer id);
	
	@Options(useCache = true, flushCache = Options.FlushCachePolicy.FALSE, timeout = 60000)
	@ResultMap(value ="articleCategoryResult")
	@SelectProvider(type = ArticleCategorySqlProvider.class, method = "queryList")
	List<ArticleCategory> queyrList(ArticleCategory articleCategory);
	/**
	 * 入库文章分类
	 * 
	 * @param articleCategory 待入库实体
	 * @return 影响条数
	 */
	@Options(useCache = true, flushCache = Options.FlushCachePolicy.TRUE, useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	@InsertProvider(type = ArticleCategorySqlProvider.class, method = "insert")
	int insert(ArticleCategory articleCategory);
	
	/**
	 * 根据文章分类id，删除文章分类
	 * 
	 * @param id 文章分类id
	 * @return 影响条数
	 */
	@Options(useCache = true, flushCache = Options.FlushCachePolicy.TRUE)
	@Delete("delete from article_category where id=#{id}")
	int delete(Integer id);
	
	/**
	 * 根据文章id，删除文章
	 * 
	 * @param id 文章id
	 * @return 影响条数
	 */
	@Options(useCache = true, flushCache = Options.FlushCachePolicy.TRUE)
	@UpdateProvider(type = ArticleCategorySqlProvider.class, method = "update")
	int update(ArticleCategory articleCategory);
}
