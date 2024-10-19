package co.edu.unicauca.microserviceconference.aplication;

import co.edu.unicauca.microserviceconference.domain.interfaces.IConferencesRepository;
import co.edu.unicauca.microserviceconference.domain.model.Conference;

public class ConferenceService implements IConferencesRepository {

    private IConferencesRepository repository;
    @Override
    public Conference saveConference(Conference conference) {
        return null;
    }

    @Override
    public Conference findById(int id) {
        return null;
    }

    @Override
    public Conference updateConference(Conference conference, int id) {
        return null;
    }

    @Override
    public Conference deleteById(int id) {
        return null;
    }
}
