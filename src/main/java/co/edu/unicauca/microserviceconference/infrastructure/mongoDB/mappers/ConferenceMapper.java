package co.edu.unicauca.microserviceconference.infrastructure.mongoDB.mappers;

import co.edu.unicauca.microserviceconference.domain.model.Conference;
import co.edu.unicauca.microserviceconference.infrastructure.dtro.ConferenceDTRO;
import co.edu.unicauca.microserviceconference.infrastructure.mongoDB.documents.ConferenceDocument;

public class ConferenceMapper {
    public static ConferenceDocument toConferenceDocument(Conference conference) {
        return new ConferenceDocument(
                conference.getId(),
                conference.getPlace(),
                conference.getName(),
                BasicDateMapper.toBasicDateDocument(conference.getStartDate()),
                BasicDateMapper.toBasicDateDocument(conference.getFinishDate()),
                conference.getTopic(),
                conference.getOrganizer().getId(),
                conference.getDescription(),
                true
        );
    }
    public static ConferenceDTRO toConferenceDTRO(ConferenceDocument conferenceDocument) {
        return new ConferenceDTRO(
                conferenceDocument.getId(),
                conferenceDocument.getName(),
                BasicDateMapper.toBasicDate(conferenceDocument.getStartDate()),
                BasicDateMapper.toBasicDate(conferenceDocument.getFinishDate()),
                conferenceDocument.getPlace(),
                conferenceDocument.getTopic(),
                conferenceDocument.getIdOrganizer(),
                conferenceDocument.getDescription()
        );
    }
}