package co.edu.unicauca.microserviceconference.infrastructure.mongoDB.mogoRepositories;

import co.edu.unicauca.microserviceconference.infrastructure.mongoDB.documents.OrganizerDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoRepositoryOrganizer extends MongoRepository<OrganizerDocument, String> {
}
