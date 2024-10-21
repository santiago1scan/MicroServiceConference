package co.edu.unicauca.microserviceconference.infrastructure.mongoDB.mogoRepositories;

import co.edu.unicauca.microserviceconference.infrastructure.mongoDB.documents.ConferenceDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoRepositoriyConference extends MongoRepository<ConferenceDocument, String> {
}
