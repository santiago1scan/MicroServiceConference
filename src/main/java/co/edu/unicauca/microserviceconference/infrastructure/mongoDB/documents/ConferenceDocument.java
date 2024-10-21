package co.edu.unicauca.microserviceconference.infrastructure.mongoDB.documents;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "conference")
@Setter
@Getter
@AllArgsConstructor
public class ConferenceDocument {
    @Id
    private String id;
    private String place;
    private String name;
    private BasicDateDocument startDate;
    private BasicDateDocument finishDate;
    private String topic;
    private String idOrganizer;
    private String description;
}
