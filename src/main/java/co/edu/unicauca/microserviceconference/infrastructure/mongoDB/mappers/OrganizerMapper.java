package co.edu.unicauca.microserviceconference.infrastructure.mongoDB.mappers;

import co.edu.unicauca.microserviceconference.domain.model.Organizer;
import co.edu.unicauca.microserviceconference.infrastructure.mongoDB.documents.OrganizerDocument;

public class OrganizerMapper {
    public static OrganizerDocument toOrganizerDocument(Organizer organizer) {
        return new OrganizerDocument(organizer.getId(), organizer.getName(), organizer.getEmail(), true);
    }
    public static Organizer toOrganizer(OrganizerDocument organizerDocument) {
        return new Organizer(organizerDocument.getId(), organizerDocument.getName(), organizerDocument.getEmail());
    }
}
