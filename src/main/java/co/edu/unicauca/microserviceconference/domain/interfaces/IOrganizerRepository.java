package co.edu.unicauca.microserviceconference.domain.interfaces;

import co.edu.unicauca.microserviceconference.domain.model.Article;
import co.edu.unicauca.microserviceconference.domain.model.Organizer;

import java.util.List;

public interface IOrganizerRepository {
    Organizer saveOrganizer(Organizer organizer);
    List<Organizer> findAllOrganizers();
    Organizer findOrganizerById(int id);
    Organizer deleteOrganizerById(int id);
}
