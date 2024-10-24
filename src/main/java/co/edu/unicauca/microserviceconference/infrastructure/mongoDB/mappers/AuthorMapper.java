package co.edu.unicauca.microserviceconference.infrastructure.mongoDB.mappers;

import co.edu.unicauca.microserviceconference.domain.model.Author;
import co.edu.unicauca.microserviceconference.infrastructure.mongoDB.documents.AuthorDocument;

public class AuthorMapper {
    public static AuthorDocument toAuthorDocument(Author author) {
        return new AuthorDocument(author.getId(), author.getName(), author.getEmail(), true);
    }
    public static Author toAuthor(AuthorDocument authorDocument) {
        return new Author(authorDocument.getId(), authorDocument.getName(), authorDocument.getEmail() );
    }
}
