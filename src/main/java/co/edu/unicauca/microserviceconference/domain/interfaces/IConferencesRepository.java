package co.edu.unicauca.microserviceconference.domain.interfaces;

import co.edu.unicauca.microserviceconference.domain.model.Article;
import co.edu.unicauca.microserviceconference.domain.model.Conference;
import co.edu.unicauca.microserviceconference.infrastructure.dtro.ConferenceDTRO;
import co.edu.unicauca.microserviceconference.presentation.dto.ConferenceOutDTO;
import org.springframework.boot.autoconfigure.jms.artemis.ArtemisNoOpBindingRegistry;

import java.util.List;


public interface IConferencesRepository {
    ConferenceDTRO saveConference(Conference conference);
    ConferenceDTRO findById(String id);
    ConferenceDTRO updateConference(Conference conference, String id);
    ConferenceDTRO deleteById(String id);
    List<ConferenceDTRO> findAllActive();
    List<ConferenceDTRO> findByOrganizer(String idOrganizer);
    List<ConferenceDTRO> findAll();
}
