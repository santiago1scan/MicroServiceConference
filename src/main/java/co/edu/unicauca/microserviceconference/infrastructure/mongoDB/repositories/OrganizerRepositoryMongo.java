package co.edu.unicauca.microserviceconference.infrastructure.mongoDB.repositories;

import co.edu.unicauca.microserviceconference.domain.interfaces.IOrganizerRepository;
import co.edu.unicauca.microserviceconference.domain.model.Organizer;
import co.edu.unicauca.microserviceconference.infrastructure.mongoDB.documents.OrganizerDocument;
import co.edu.unicauca.microserviceconference.infrastructure.mongoDB.mappers.OrganizerMapper;
import co.edu.unicauca.microserviceconference.infrastructure.mongoDB.mogoRepositories.MongoRepositoryOrganizer;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrganizerRepositoryMongo implements IOrganizerRepository {
    private final MongoRepositoryOrganizer mongoRepositoryOrganizer;
    private final MongoTemplate mongoTemplate;

    public OrganizerRepositoryMongo(MongoRepositoryOrganizer mongoRepositoryOrganizer, MongoTemplate mongoTemplate) {
        this.mongoRepositoryOrganizer = mongoRepositoryOrganizer;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Organizer saveOrganizer(Organizer organizer) {
        OrganizerDocument organizerDocument = OrganizerMapper.toOrganizerDocument(organizer);

        OrganizerDocument savedOrganizer = mongoTemplate.save(organizerDocument);

        return OrganizerMapper.toOrganizer(savedOrganizer);
    }

    @Override
    public List<Organizer> findAllOrganizers() {
        List<OrganizerDocument> organizerDocuments = mongoRepositoryOrganizer.findAll();

        return organizerDocuments.stream()
                .map(OrganizerMapper::toOrganizer)
                .toList();
    }

    @Override
    public Organizer findOrganizerById(String id) {
        Optional<OrganizerDocument> organizerDocumentOptional = mongoRepositoryOrganizer.findById(String.valueOf(id));

        return organizerDocumentOptional.map(OrganizerMapper::toOrganizer).orElse(null);

    }

    @Override
    public Organizer deleteOrganizerById(String id) {
        Optional<OrganizerDocument> organizerDocumentOptional = mongoRepositoryOrganizer.findById(id);

        if (organizerDocumentOptional.isEmpty()) {
            return null;
        }

        mongoRepositoryOrganizer.deleteById(id);

        return OrganizerMapper.toOrganizer(organizerDocumentOptional.get());
    }
}
