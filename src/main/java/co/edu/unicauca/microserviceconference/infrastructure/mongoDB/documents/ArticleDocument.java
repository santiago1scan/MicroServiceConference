package co.edu.unicauca.microserviceconference.infrastructure.mongoDB.documents;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "articles")
@Setter
@Getter
@AllArgsConstructor
public class ArticleDocument {
    @Id
    private String id;
}
