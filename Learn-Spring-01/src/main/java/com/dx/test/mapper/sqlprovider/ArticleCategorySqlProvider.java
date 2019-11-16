package com.dx.test.mapper.sqlprovider;

import org.apache.ibatis.jdbc.SQL;

import com.dx.test.model.ArticleCategory;

public class ArticleCategorySqlProvider {
	/**
	 * 生成插入文章分类的SQL
	 * @param articleCategory文章分类
	 * @return 返回插入文章SQL
	 * */
	public String insert(ArticleCategory articleCategory) {
		return new SQL() {{
			INSERT_INTO("article_category");
			INTO_COLUMNS("title","img_src","description", "create_user", "create_user_id", "create_time","update_user", "update_user_id", "update_time", "version");
			INTO_VALUES("#{title}","#{imgSrc}","#{description}","#{createUser}", "#{createUserId}","now()", "#{updateUser}", "#{updateUserId}", "now()", "0");
		}}.toString();
	}
	
	/**
	 * 生成修改文章分类SQL
	 * @param articleCategory 文章分类实体
	 * @return 返回修改文章分类SQL
	 * */
	public String update(ArticleCategory articleCategory) {
		StringBuilder sql=new StringBuilder();

		sql.append("update `article_category` set id=#{id}");
		if (articleCategory.getTitle() != null) {
			sql.append(", `title`=#{title}");
		}
		if (articleCategory.getImgSrc() != null) {
			sql.append(", `img_src`=#{imgSrc}");
		}
		if(articleCategory.getDescription()!=null) {
			sql.append(", `description`=#{description}");
		}
		if (articleCategory.getCreateUser() != null) {
			sql.append(", `create_user` = #{createUser}");
		}
		if (articleCategory.getCreateUserId() != null) {
			sql.append(", `create_user_id` = #{createUserId}");
		}
		sql.append(", `update_time` = now()");
		if (articleCategory.getUpdateUser() != null) {
			sql.append(", `update_user` = #{updateUser}");
		}
		if (articleCategory.getUpdateUserId() != null) {
			sql.append(", `update_user_id` = #{updateUserId}");
		}

		sql.append(", `version` = `version` + 1");
		sql.append(" WHERE `id` = #{id} AND `version` = #{version}");

		return sql.toString();
	}
	
	public String queryList(ArticleCategory articleCategory) {
		StringBuilder sql=new StringBuilder();
		sql.append("select * from `article_category` where 1=1 ");
		
		if(articleCategory.getId()!=null) {
			sql.append(" AND `id`=#{id}");
		}
		if (articleCategory.getTitle() != null) {
			sql.append("  AND `title` like CONCAT(CONCAT('%', #{title}), '%')");
		}
		if (articleCategory.getCreateTime() != null) {
            sql.append("  AND `create_time` = #{createTime}");
        }
        if (articleCategory.getCreateUser() != null) {
            sql.append("  AND `create_user` = #{createUser}");
        }
        if (articleCategory.getCreateUserId() != null) {
            sql.append("  AND `create_user_id` = #{createUserId}");
        }
        if (articleCategory.getUpdateTime() != null) {
            sql.append("  AND `update_time` = #{updateTime}");
        }
        if (articleCategory.getUpdateUser() != null) {
            sql.append("  AND `update_user` = #{updateUser}");
        }
        if (articleCategory.getUpdateUserId() != null) {
            sql.append("  AND `update_user_id` = #{updateUserId}");
        }
        if (articleCategory.getVersion() != null) {
            sql.append("  AND `version` = #{version}");
        }
        sql.append("  ORDER BY `id` DESC");
        
        return sql.toString();
	}
}
