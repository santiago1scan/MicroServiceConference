package co.edu.unicauca.microserviceconference.domain.interfaces;

import co.edu.unicauca.microserviceconference.domain.model.Article;
import co.edu.unicauca.microserviceconference.infrastructure.dtro.ArticleDTRO;

import java.util.List;

public interface IArticleRepository {
    ArticleDTRO saveArticle(Article article);
    List<ArticleDTRO> findAllArticles();
    ArticleDTRO findArticleById(String id);
    List<ArticleDTRO> findAllArticlesByAuthor(String keyword);
    ArticleDTRO deleteArticleById(String id);
    ArticleDTRO updateArticle(Article article, String id );
}
