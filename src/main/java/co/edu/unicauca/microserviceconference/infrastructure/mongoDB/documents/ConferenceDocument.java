package co.edu.unicauca.microserviceconference.infrastructure.mongoDB.documents;

import co.edu.unicauca.microserviceconference.domain.model.Article;
import co.edu.unicauca.microserviceconference.domain.model.Author;
import co.edu.unicauca.microserviceconference.domain.model.Organizer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Document(collection = "conference")
@Setter
@Getter
@AllArgsConstructor
public class ConferenceDocument {private String id;
    @Id
    private String place;
    private String basicInfo;
    private String topics;
    private Date date;
    private Author author;
    private Organizer organizer;
    private Article article;
}
