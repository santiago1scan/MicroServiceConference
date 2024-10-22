package co.edu.unicauca.microserviceconference.infrastructure.mongoDB.mappers;

import co.edu.unicauca.microserviceconference.domain.model.Article;
import co.edu.unicauca.microserviceconference.infrastructure.dtro.ArticleDTRO;
import co.edu.unicauca.microserviceconference.infrastructure.mongoDB.documents.ArticleDocument;
import co.edu.unicauca.microserviceconference.presentation.dto.ArticleDTO;
import co.edu.unicauca.microserviceconference.presentation.dto.ConferenceInDTO;
import org.modelmapper.ModelMapper;

public class ArticleMapper {
    public static Article toArticle(ArticleDTO article) {
        return new Article(
                article.getId(),
                article.getName(),
                article.getIdAuthor(),
                article.getKeywords(),
                article.getPublicationDate()
        );
    }

    public static ArticleDocument toArticleDocument(Article article) {
        return new ArticleDocument(
                article.getId(),
                article.getName(),
                article.getIdAuthor(),
                article.getKeywords(),
                article.getPublicationDate()
        );
    }

    public static ArticleDTRO toArticleDTRO(ArticleDocument article) {
        return new ArticleDTRO(
                article.getId(),
                article.getName(),
                article.getIdAuthor(),
                article.getKeywords(),
                article.getPublicationDate(),
                article.getIdAuthor()
        );
    }
}