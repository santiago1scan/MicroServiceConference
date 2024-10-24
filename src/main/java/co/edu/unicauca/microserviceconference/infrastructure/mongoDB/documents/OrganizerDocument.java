package co.edu.unicauca.microserviceconference.infrastructure.mongoDB.documents;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "organizer")
@Setter
@Getter
@AllArgsConstructor
public class OrganizerDocument{
    @Id
    private String id;
    private String name;
    private String email;
    private boolean isActive;
}
