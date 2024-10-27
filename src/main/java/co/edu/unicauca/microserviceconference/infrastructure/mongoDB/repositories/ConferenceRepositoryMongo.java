package co.edu.unicauca.microserviceconference.infrastructure.mongoDB.repositories;

import co.edu.unicauca.microserviceconference.domain.interfaces.IConferencesRepository;
import co.edu.unicauca.microserviceconference.domain.model.Conference;
import co.edu.unicauca.microserviceconference.infrastructure.dtro.ConferenceDTRO;
import co.edu.unicauca.microserviceconference.infrastructure.mongoDB.documents.ConferenceDocument;
import co.edu.unicauca.microserviceconference.infrastructure.mongoDB.mappers.BasicDateMapper;
import co.edu.unicauca.microserviceconference.infrastructure.mongoDB.mappers.ConferenceMapper;
import co.edu.unicauca.microserviceconference.infrastructure.mongoDB.mogoRepositories.MongoRepositoriyConference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Repository
public class ConferenceRepositoryMongo implements IConferencesRepository {

    private final MongoRepositoriyConference mongoRepositoriyConference;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public ConferenceRepositoryMongo(MongoRepositoriyConference mongoRepositoriyConference, MongoTemplate mongoTemplate ) {
        this.mongoRepositoriyConference = mongoRepositoriyConference;
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * @param conference conference to be added
     * @return the conference created
     */
    @Override
    public ConferenceDTRO saveConference(Conference conference) {

        conference.setId(null);

        ConferenceDocument conferenceDocument = ConferenceMapper.toConferenceDocument(conference);
        ConferenceDocument createdConference = mongoRepositoriyConference.save(conferenceDocument);

        return ConferenceMapper.toConferenceDTRO(createdConference);
    }

    /**
     *
     * @param id id of Conference to be found
     * @return return the found conference
     */
    @Override
    public ConferenceDTRO findById(String id) {
        ConferenceDocument foundConference = mongoRepositoriyConference.findById(id).orElse(null);
        if(foundConference == null || !foundConference.isActive())
            return null;
        return ConferenceMapper.toConferenceDTRO(foundConference);

    }

    /**
     *
     * @param conference info of conference to be updated
     * @param id id of conference to updated
     * @return the updated conference
     */
    @Override
    public ConferenceDTRO updateConference(Conference conference, String id) {
        Optional<ConferenceDocument> conferenceOptional =mongoRepositoriyConference.findById(id);

        if(conferenceOptional.isEmpty())
            throw new RuntimeException("User not found ");

        ConferenceDocument conferenceDocument = conferenceOptional.get();

        if(conference.getName() != null && !conference.getName().isEmpty())
            conferenceDocument.setName(conference.getName());
        if(conference.getDescription() != null && !conference.getDescription().isEmpty())
            conferenceDocument.setDescription(conference.getDescription());
        if(conference.getStartDate() != null)
            conferenceDocument.setStartDate(BasicDateMapper.toBasicDateDocument(conference.getStartDate()));
        if(conference.getFinishDate() != null)
            conferenceDocument.setFinishDate(BasicDateMapper.toBasicDateDocument(conference.getFinishDate()));
        if(conference.getPlace() != null && !conference.getPlace().isEmpty())
            conferenceDocument.setPlace(conference.getPlace());
        if(conference.getTopic() != null && !conference.getTopic().isEmpty())
            conferenceDocument.setTopic(conference.getTopic());

        ConferenceDocument udpatedConference =mongoRepositoriyConference.save(conferenceDocument);

        return ConferenceMapper.toConferenceDTRO(udpatedConference);
    }

    @Override
    public ConferenceDTRO deleteById(String id) {
        Optional<ConferenceDocument> conferenceOptional =mongoRepositoriyConference.findById(id);

        if(conferenceOptional.isEmpty())
            throw new RuntimeException("User not found ");

        ConferenceDocument conferenceDocument = conferenceOptional.get();
        conferenceDocument.setActive(false);

        ConferenceDocument updatedConference = mongoRepositoriyConference.save(conferenceDocument);

        return ConferenceMapper.toConferenceDTRO(updatedConference);

    }

    /**
     *
     * @return list ConferenceDRTO just Active
     */
    @Override
    public List<ConferenceDTRO> findAllActive() {
        // Use MongoTemplate to find all ConferenceDocuments with active flag set to true
        List<ConferenceDocument> conferenceDocuments = mongoTemplate.find(
                query(where("isActive").is(true)),  // Build query to filter active conferences
                ConferenceDocument.class);

        // Convert ConferenceDocuments to ConferenceDTROs using ConferenceMapper
        List<ConferenceDTRO> conferenceDTROs = conferenceDocuments.stream()
                .map(ConferenceMapper::toConferenceDTRO)
                .collect(Collectors.toList());

        return conferenceDTROs;
    }
    /**
     * Devuelve todas las conferencias organizadas por un organizador específico.
     *
     * @param idOrganizer El ID del organizador de las conferencias a buscar.
     * @return Una lista de DTOs de las conferencias organizadas por el organizador.
     */
    @Override
    public List<ConferenceDTRO> findByOrganizer(String idOrganizer) {
        // Crea una consulta para buscar conferencias con el idOrganizer dado
        Query query = new Query();
        query.addCriteria(where("idOrganizer").is(idOrganizer));

        // Ejecuta la consulta y obtiene los documentos de conferencias
        List<ConferenceDocument> conferenceDocuments = mongoTemplate.find(query, ConferenceDocument.class);

        // Convierte los documentos en una lista de DTOs y los devuelve
        return conferenceDocuments.stream()
                .map(ConferenceMapper::toConferenceDTRO)
                .collect(Collectors.toList());
    }



    /**
     *
     * @return list of conferences DRTO active and no active
     */
    @Override
    public List<ConferenceDTRO> findAll() {
        // Utiliza MongoTemplate para encontrar todos los ConferenceDocuments
        List<ConferenceDocument> conferenceDocuments = mongoTemplate.findAll(
                ConferenceDocument.class);

        // Convierte ConferenceDocuments a ConferenceDTROs usando ConferenceMapper
        List<ConferenceDTRO> conferenceDTROs = conferenceDocuments.stream()
                .map(ConferenceMapper::toConferenceDTRO)
                .collect(Collectors.toList());

        return conferenceDTROs;
    }


}
