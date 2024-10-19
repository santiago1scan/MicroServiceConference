package co.edu.unicauca.microserviceconference.domain.interfaces;

import co.edu.unicauca.microserviceconference.domain.model.Article;

import java.util.List;

public interface IArticleRepository {
    Article saveArticle(Article article);
    List<Article> findAllArticles();
    Article findArticleById(String id);
    Article deleteArticleById(String id);
    Article updateArticle(Article article, String id );
}
