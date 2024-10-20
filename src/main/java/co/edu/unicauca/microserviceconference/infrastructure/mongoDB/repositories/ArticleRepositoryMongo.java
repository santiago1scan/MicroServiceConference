package co.edu.unicauca.microserviceconference.infrastructure.mongoDB.repositories;

import co.edu.unicauca.microserviceconference.domain.interfaces.IArticleRepository;
import co.edu.unicauca.microserviceconference.domain.model.Article;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ArticleRepositoryMongo implements IArticleRepository {

    @Override
    public Article saveArticle(Article article) {
        return null;
    }

    @Override
    public List<Article> findAllArticles() {
        return List.of();
    }

    @Override
    public Article findArticleById(String id) {
        return null;
    }

    @Override
    public Article deleteArticleById(String id) {
        return null;
    }

    @Override
    public Article updateArticle(Article article, String id) {
        return null;
    }
}
