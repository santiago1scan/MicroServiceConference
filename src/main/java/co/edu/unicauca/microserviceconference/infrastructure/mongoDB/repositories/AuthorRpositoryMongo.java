package co.edu.unicauca.microserviceconference.infrastructure.mongoDB.repositories;

import co.edu.unicauca.microserviceconference.domain.interfaces.IAuthorRepository;
import co.edu.unicauca.microserviceconference.domain.model.Author;

import java.util.List;

public class AuthorRpositoryMongo implements IAuthorRepository {
    @Override
    public Author findById(int id) {
        return null;
    }

    @Override
    public List<Author> findAllAuthors() {
        return List.of();
    }

    @Override
    public Author saveAuthor(Author author) {
        return null;
    }

    @Override
    public Author deleteAuthor(Author author) {
        return null;
    }
}
