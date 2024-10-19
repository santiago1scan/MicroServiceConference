package co.edu.unicauca.microserviceconference.aplication;

import co.edu.unicauca.microserviceconference.domain.interfaces.IOrganizerRepository;
import co.edu.unicauca.microserviceconference.domain.model.Organizer;

import java.util.List;

public class OrganizerServices implements IOrganizerRepository {
    @Override
    public Organizer saveOrganizer(Organizer organizer) {
        return null;
    }

    @Override
    public List<Organizer> findAllOrganizers() {
        return List.of();
    }

    @Override
    public Organizer findOrganizerById(int id) {
        return null;
    }

    @Override
    public Organizer deleteOrganizerById(int id) {
        return null;
    }
}
