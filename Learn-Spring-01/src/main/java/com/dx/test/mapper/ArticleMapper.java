package com.dx.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.dx.test.mapper.sqlprovider.ArticleSqlProvider;
import com.dx.test.model.Article;
import com.dx.test.model.ArticleCategory;

@Mapper
public interface ArticleMapper {
	/**
	 * 根据文章id,查询文章详情
	 * 
	 * @param id 文章id
	 * @return 返回查询到的文章详情
	 */
	@Options(useCache = true, flushCache = Options.FlushCachePolicy.FALSE, timeout = 60000)
	@Results(id = "articleResultWithCategory", value = { @Result(property = "id", column = "id", id = true),
			@Result(property = "categoryId", column = "category_id"),
			@Result(property = "articleCategory", javaType = ArticleCategory.class, one = @One(select = "com.dx.test.mapper.ArticleCategoryMapper.getById"), column = "category_id"),
			@Result(property = "title", column = "title"), @Result(property = "content", column = "content"),
			@Result(property = "createUser", column = "create_user"),
			@Result(property = "createUserId", column = "create_user_id"),
			@Result(property = "createTime", column = "create_time"),
			@Result(property = "updateUser", column = "update_user"),
			@Result(property = "updateUserId", column = "update_user_id"),
			@Result(property = "updateTime", column = "update_time"),
			@Result(property = "version", column = "version") })
	@Select({ "select * from article where id=#{id}" })
	Article getById(@Param("id") Long id);

	/**
	 * 根据文章id,查询文章详情
	 * 
	 * @param id 文章id
	 * @return 返回查询到的文章详情
	 */
	@Options(useCache = true, flushCache = Options.FlushCachePolicy.FALSE, timeout = 60000)
	@Results(id = "articleResultWithoutCategory", value = { @Result(property = "id", column = "id", id = true),
			@Result(property = "categoryId", column = "category_id"), @Result(property = "title", column = "title"),
			@Result(property = "content", column = "content"), @Result(property = "createUser", column = "create_user"),
			@Result(property = "createUserId", column = "create_user_id"),
			@Result(property = "createTime", column = "create_time"),
			@Result(property = "updateUser", column = "update_user"),
			@Result(property = "updateUserId", column = "update_user_id"),
			@Result(property = "updateTime", column = "update_time"),
			@Result(property = "version", column = "version") })
	@Select({ "select * from article where id=#{id}" })
	Article getByIdWithoutCategory(@Param("id") Long id);

	/**
	 * 根据条件查询文章列表
	 * 
	 * @param article 查询条件
	 * @return 查询到的文章列表
	 */
	@Options(useCache = true, flushCache = Options.FlushCachePolicy.FALSE, timeout = 60000)
	@SelectProvider(type = ArticleSqlProvider.class, method = "queryList")
	@ResultMap(value = "articleResultWithoutCategory")
	List<Article> queryList(Article article);

	/**
	 * 入库文章
	 * 
	 * @param article 待入库实体
	 * @return 影响条数
	 */
	@Options(useCache = true, flushCache = Options.FlushCachePolicy.TRUE, useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	@InsertProvider(type = ArticleSqlProvider.class, method = "insert")
	int insert(Article article);

	/**
	 * 根据文章id，删除文章
	 * 
	 * @param id 文章id
	 * @return 影响条数
	 */
	@Options(useCache = true, flushCache = Options.FlushCachePolicy.TRUE)
	@Delete("delete from article where id=#{id}")
	int delete(Long id);

	/**
	 * 根据文章id，删除文章
	 * 
	 * @param id 文章id
	 * @return 影响条数
	 */
	@Options(useCache = true, flushCache = Options.FlushCachePolicy.TRUE)
	@UpdateProvider(type = ArticleSqlProvider.class, method = "update")
	int update(Article article);
}
