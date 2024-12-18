package co.edu.unicauca.microserviceconference.aplication;

import co.edu.unicauca.microserviceconference.domain.interfaces.IAuthorRepository;
import co.edu.unicauca.microserviceconference.domain.interfaces.IConferencesRepository;
import co.edu.unicauca.microserviceconference.domain.interfaces.IOrganizerRepository;
import co.edu.unicauca.microserviceconference.domain.model.Conference;
import co.edu.unicauca.microserviceconference.domain.model.Organizer;
import co.edu.unicauca.microserviceconference.infrastructure.dtro.ConferenceDTRO;
import co.edu.unicauca.microserviceconference.presentation.dto.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ConferenceService {

    @Autowired
    private IConferencesRepository repository;
    @Autowired
    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private IOrganizerRepository organizerRepository;

    @Autowired
    public ConferenceService(IConferencesRepository conferencesRepository, IOrganizerRepository organizerRepository) {
        this.repository= conferencesRepository;
        this.organizerRepository = organizerRepository;
    }

    /**
     *
     * @param conferenceToSave conference for save in repository
     * @return conferenceDTO to save or null
     */
    public ConferenceOutDTO save(ConferenceInDTO conferenceToSave){
        Conference conferenceEntity = this.modelMapper.map(conferenceToSave, Conference.class);
        Organizer organizer =  organizerRepository.findOrganizerById(conferenceEntity.getId());
        if( organizer == null)
            return null;
        ConferenceDTRO conferenceSave =this.repository.saveConference(conferenceEntity);

        if( conferenceSave != null){
            ConferenceOutDTO conferenceOutDTO = this.modelMapper.map(conferenceSave, ConferenceOutDTO.class);
            conferenceOutDTO.setOrganizer(organizer);
            return conferenceOutDTO;
        }else {
            return null;
        }
    }

    /**
     *
     * @param conferenceId id to find in repository
     * @return conferenceDTO find or null
     */
    public ConferenceOutDTO findConferenceById(String conferenceId){
        if(conferenceId == null){
            return null;
        }
        ConferenceDTRO conferenceSave =this.repository.findById(conferenceId);
        if( conferenceSave != null){
            //TODO notify the broker
            return this.modelMapper.map(conferenceSave, ConferenceOutDTO.class);
        }else {
            return null;
        }

    }

    /**
     *
     * @return ListConferenceDTO list of conference ative
     */
    public ListConferenceOutDTO findAllConferencesActive(){
        ArrayList<ConferenceDTRO> listConferencesActive = (ArrayList<ConferenceDTRO>) this.repository.findAllActive();
        ListConferenceOutDTO conferencesOutDTO  =  new ListConferenceOutDTO();
        conferencesOutDTO.setConferences(this.modelMapper.map(listConferencesActive, new TypeToken<ArrayList<ConferenceOutDTO>>(){}.getType()));
        int countConference = listConferencesActive.size();
        conferencesOutDTO.setTotalConference(countConference);
        return conferencesOutDTO;
    }

    /**
     *
     * @param idOrganizer
     * @return ListConfereneOrganizerOut DTO whit idOrganizaer, totalConference and all conference, active and no active
     * @Brief funciton return a dto for controller list for organizer
     */
    public ListConferenceOrganizerOut findAllConfereceByIDOrganizer(String idOrganizer){
        Organizer organizer = organizerRepository.findOrganizerById(idOrganizer);
        if(organizer == null)
            return null;
        ArrayList<ConferenceDTRO> listAllConference = (ArrayList<ConferenceDTRO>) this.repository.findByOrganizer(idOrganizer);
        ListConferenceOrganizerOut conferencesOutDTO = new ListConferenceOrganizerOut();
        conferencesOutDTO.setConferences(this.modelMapper.map(listAllConference, new TypeToken<ArrayList<ConferenceOutDTO>>() {}.getType() )) ;
        conferencesOutDTO.setIdOrganizer(idOrganizer);
        int countConference = listAllConference.size();
        conferencesOutDTO.setTotalConference(countConference);
        return conferencesOutDTO;
    }

    /**
     *
     * @param conferenceId id of conferece to ypdate
     * @param conferenceToUpdate new conference for update
     * @return conference updated or null
     */
    public ConferenceOutDTO updateConference(String conferenceId, ConferenceInDTO conferenceToUpdate){
        if(conferenceId == null){
            return null;
        }
        if(repository.findById(conferenceId) == null){
            return null;
        }
        Conference confernceEntityToUpdate = this.modelMapper.map(conferenceToUpdate, Conference.class);
        ConferenceDTRO confernceEntity = this.repository.updateConference( confernceEntityToUpdate, conferenceId);
        if( conferenceToUpdate != null){
            //TODO notify the broker
            return this.modelMapper.map(confernceEntity, ConferenceOutDTO.class);
        }else {
            return null;
        }
    }

    /**
     *
     * @param conferenceId id to find in repository
     * @return conference eliminated or null
     */
    public ConferenceOutDTO deleteConference(String conferenceId){
        if(conferenceId == null){
            return null;
        }
        ConferenceDTRO conferenceSave =this.repository.deleteById(conferenceId);
        if( conferenceSave != null){
            //TODO notify the broker
            return this.modelMapper.map(conferenceSave, ConferenceOutDTO.class);
        }else {
            return null;
        }
    }


}
