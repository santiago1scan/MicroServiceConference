package co.edu.unicauca.microserviceconference.aplication;

import co.edu.unicauca.microserviceconference.domain.interfaces.IArticleRepository;
import co.edu.unicauca.microserviceconference.domain.model.Article;

import java.util.List;

public class ArticleServices implements IArticleRepository {
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
