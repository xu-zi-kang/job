package top.ludonghuang.mapper;

import top.ludonghuang.entity.Article;

import java.util.List;

public interface ArticleMapper {

	int create(Article article);

	int delete(Integer id);

	int update(Article article);

	List<Article> query(Article article);

	Article detail(Integer id);

	Article detail2(String title);

	int count(Article article);

	List<Article> getArticlesByChannelId(Integer channelId);
}