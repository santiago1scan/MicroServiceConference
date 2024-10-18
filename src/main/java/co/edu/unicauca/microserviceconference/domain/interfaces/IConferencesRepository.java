package co.edu.unicauca.microserviceconference.domain.interfaces;

import co.edu.unicauca.microserviceconference.domain.model.Article;
import co.edu.unicauca.microserviceconference.domain.model.Conference;
import org.springframework.boot.autoconfigure.jms.artemis.ArtemisNoOpBindingRegistry;

import java.util.List;


public interface IConferencesRepository {
    Conference save(Conference conference);
    Conference findById(int id);
    Conference update(Conference conference, int id);
    Conference deleteById(int id);
    Article saveArticle(Article article);
    List<Article> findAllArticles();
    Article findArticleById(int id);
    Article deleteArticleById(int id);
}
