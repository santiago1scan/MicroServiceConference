package co.edu.unicauca.microserviceconference.domain.interfaces;

import co.edu.unicauca.microserviceconference.domain.model.Author;

import java.util.List;

public interface IAuthorRepository {
    Author findById(String id);
    List<Author> findAllAuthors();
    Author saveAuthor(Author author);
    Author deleteAuthor(String idAuthor);

}
