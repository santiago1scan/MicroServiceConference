package co.edu.unicauca.microserviceconference.infrastructure.mongoDB.mogoRepositories;

import co.edu.unicauca.microserviceconference.domain.model.Author;
import co.edu.unicauca.microserviceconference.infrastructure.mongoDB.documents.AuthorDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoRepositoryAuthor extends MongoRepository<AuthorDocument, String> {
}
