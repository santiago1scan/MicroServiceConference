package co.edu.unicauca.microserviceconference.infrastructure.mongoDB.repositories;

import co.edu.unicauca.microserviceconference.domain.interfaces.IConferencesRepository;
import co.edu.unicauca.microserviceconference.domain.model.Conference;
import org.springframework.stereotype.Repository;

@Repository
public class ConferenceRepositoryMongo implements IConferencesRepository {


    @Override
    public Conference saveConference(Conference conference) {
        return null;
    }

    @Override
    public Conference findById(String id) {
        return null;
    }

    @Override
    public Conference updateConference(Conference conference, String id) {
        return null;
    }

    @Override
    public Conference deleteById(String id) {
        return null;
    }
}
