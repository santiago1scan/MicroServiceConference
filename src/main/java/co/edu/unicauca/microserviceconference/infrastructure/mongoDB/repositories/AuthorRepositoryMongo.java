package co.edu.unicauca.microserviceconference.infrastructure.mongoDB.repositories;

import co.edu.unicauca.microserviceconference.domain.interfaces.IAuthorRepository;
import co.edu.unicauca.microserviceconference.domain.model.Author;
import co.edu.unicauca.microserviceconference.infrastructure.mongoDB.documents.AuthorDocument;
import co.edu.unicauca.microserviceconference.infrastructure.mongoDB.mappers.AuthorMapper;
import co.edu.unicauca.microserviceconference.infrastructure.mongoDB.mogoRepositories.MongoRepositoryAuthor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepositoryMongo implements IAuthorRepository {

    private final MongoRepositoryAuthor mongoRepositoryAuthor;
    private final MongoTemplate mongoTemplate;

    public AuthorRepositoryMongo(MongoRepositoryAuthor mongoRepositoryAuthor, MongoTemplate mongoTemplate) {
        this.mongoRepositoryAuthor = mongoRepositoryAuthor;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Author findById(String id) {
        Optional<AuthorDocument> authorDocumentOptional = mongoRepositoryAuthor.findById(id);

        return authorDocumentOptional.map(AuthorMapper::toAuthor).orElse(null);
    }

    @Override
    public List<Author> findAllAuthors() {
        List<AuthorDocument> authorDocuments = mongoRepositoryAuthor.findAll();

        return authorDocuments.stream()
                .map(AuthorMapper::toAuthor)
                .toList();
    }

    @Override
    public Author saveAuthor(Author author) {
        author.setId(null);

        AuthorDocument authorDocument = AuthorMapper.toAuthorDocument(author);

        AuthorDocument savedAuthor = mongoTemplate.save(authorDocument);

        return AuthorMapper.toAuthor(savedAuthor);
    }

    @Override
    public Author deleteAuthor(String id) {
        Optional<AuthorDocument> authorDocumentOptional = mongoRepositoryAuthor.findById(id);

        if (authorDocumentOptional.isEmpty()) {
            return null;
        }
        mongoRepositoryAuthor.deleteById(id);

        return AuthorMapper.toAuthor(authorDocumentOptional.get());
    }
}
