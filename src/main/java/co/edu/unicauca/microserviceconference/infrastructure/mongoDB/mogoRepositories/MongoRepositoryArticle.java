package co.edu.unicauca.microserviceconference.infrastructure.mongoDB.mogoRepositories;

import co.edu.unicauca.microserviceconference.infrastructure.mongoDB.documents.ArticleDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoRepositoryArticle extends MongoRepository<ArticleDocument, String> {
}
