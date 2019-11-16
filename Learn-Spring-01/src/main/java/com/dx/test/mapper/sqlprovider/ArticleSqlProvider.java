package com.dx.test.mapper.sqlprovider;

import org.apache.ibatis.jdbc.SQL;

import com.dx.test.model.Article;

public class ArticleSqlProvider {
	/**
	 * 生成文章入库SQL
	 * 
	 * @param article 待插入文章实体
	 * @return 生成SQL
	 */
	public String insert(final Article article) {
		return new SQL() {
			{
				INSERT_INTO("article");
				INTO_COLUMNS("title", "content", "category_id", "create_user", "create_user_id", "create_time","update_user", "update_user_id", "update_time", "version");
				INTO_VALUES("#{title}", "#{content}", "#{categoryId}", "#{createUser}", "#{createUserId}","now()", "#{updateUser}", "#{updateUserId}", "now()", "0");
			}
		}.toString();
	}

	public String update(final Article article) {
		StringBuilder sql = new StringBuilder();

		sql.append("update `article` set `id`=#{id}");
		if (article.getCategoryId() != null) {
			sql.append(", `category_id`=#{categoryId}");
		}
		if (article.getTitle() != null) {
			sql.append(", `title`=#{title}");
		}
		if (article.getContent() != null) {
			sql.append(", `content`=#{content}");
		}
		if (article.getCreateUser() != null) {
			sql.append(", `create_user` = #{createUser}");
		}
		if (article.getCreateUserId() != null) {
			sql.append(", `create_user_id` = #{createUserId}");
		}
		sql.append(", `update_time` = now()");
		if (article.getUpdateUser() != null) {
			sql.append(", `update_user` = #{updateUser}");
		}
		if (article.getUpdateUserId() != null) {
			sql.append(", `update_user_id` = #{updateUserId}");
		}

		sql.append(", `version` = `version` + 1");
		sql.append(" WHERE `id` = #{id} AND `version` = #{version}");

		return sql.toString();
	}

	public String queryList(Article article) {
		StringBuilder sql=new StringBuilder();
		sql.append("select * from `article_category` where 1=1 ");
		
		if(article.getId()!=null) {
			sql.append(" AND `id`=#{id}");
		}
		if (article.getCategoryId() != null) {
			sql.append("  AND `category_id`=#{categoryId}");
		}
		if (article.getTitle() != null) {
			sql.append("  AND `title` like CONCAT(CONCAT('%', #{title}), '%')");
		}
		if (article.getCreateTime() != null) {
            sql.append("  AND `create_time` = #{createTime}");
        }
        if (article.getCreateUser() != null) {
            sql.append("  AND `create_user` = #{createUser}");
        }
        if (article.getCreateUserId() != null) {
            sql.append("  AND `create_user_id` = #{createUserId}");
        }
        if (article.getUpdateTime() != null) {
            sql.append("  AND `update_time` = #{updateTime}");
        }
        if (article.getUpdateUser() != null) {
            sql.append("  AND `update_user` = #{updateUser}");
        }
        if (article.getUpdateUserId() != null) {
            sql.append("  AND `update_user_id` = #{updateUserId}");
        }
        if (article.getVersion() != null) {
            sql.append("  AND `version` = #{version}");
        }
        sql.append("  ORDER BY `id` DESC");
        
        return sql.toString();
	}
}
