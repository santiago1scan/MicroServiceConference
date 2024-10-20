package co.edu.unicauca.microserviceconference.domain.interfaces;

import co.edu.unicauca.microserviceconference.domain.model.Article;
import co.edu.unicauca.microserviceconference.domain.model.Conference;
import org.springframework.boot.autoconfigure.jms.artemis.ArtemisNoOpBindingRegistry;

import java.util.List;


public interface IConferencesRepository {
    Conference saveConference(Conference conference);
    Conference findById(String id);
    Conference updateConference(Conference conference, int id);
    Conference deleteById(String id);

}
