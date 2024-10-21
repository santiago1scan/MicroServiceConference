package co.edu.unicauca.microserviceconference.aplication;

import co.edu.unicauca.microserviceconference.domain.interfaces.IConferencesRepository;
import co.edu.unicauca.microserviceconference.domain.model.Conference;
import co.edu.unicauca.microserviceconference.presentation.dto.ConferenceInDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConferenceService {

    @Autowired
    private IConferencesRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public ConferenceService(IConferencesRepository conferencesRepository) {
        this.repository= conferencesRepository;
        this.modelMapper = new ModelMapper();
    }

    /**
     *
     * @param conferenceToSave conference for save in repository
     * @return conferenceDTO to save or null
     */
    public ConferenceInDTO save(ConferenceInDTO conferenceToSave){
        Conference conferenceEntity = this.modelMapper.map(conferenceToSave, Conference.class);
        Conference conferenceSave =this.repository.saveConference(conferenceEntity);
        if( conferenceSave != null){
            //TODO notify the broker
            return this.modelMapper.map(conferenceSave, ConferenceInDTO.class);
        }else {
            return null;
        }
    }

    /**
     *
     * @param conferenceId id to find in repository
     * @return conferenceDTO find or null
     */
    public ConferenceInDTO findConferenceById(String conferenceId){
        if(conferenceId == null){
            return null;
        }
        Conference conferenceSave =this.repository.findById(conferenceId);
        if( conferenceSave != null){
            //TODO notify the broker
            return this.modelMapper.map(conferenceSave, ConferenceInDTO.class);
        }else {
            return null;
        }

    }

    /**
     *
     * @param conferenceId id of conferece to ypdate
     * @param conferenceToUpdate new conference for update
     * @return conference updated or null
     */
    public ConferenceInDTO updateConference(String conferenceId, ConferenceInDTO conferenceToUpdate){
        if(conferenceId == null){
            return null;
        }
        if(repository.findById(conferenceId) == null){
            return null;
        }
        Conference confernceEntityToUpdate = this.modelMapper.map(conferenceToUpdate, Conference.class);
        Conference confernceEntity = this.repository.updateConference( confernceEntityToUpdate, conferenceId);
        if( conferenceToUpdate != null){
            //TODO notify the broker
            return this.modelMapper.map(confernceEntity, ConferenceInDTO.class);
        }else {
            return null;
        }
    }

    /**
     *
     * @param conferenceId id to find in repository
     * @return conference eliminated or null
     */
    public ConferenceInDTO deleteConference(String conferenceId){
        if(conferenceId == null){
            return null;
        }
        Conference conferenceSave =this.repository.deleteById(conferenceId);
        if( conferenceSave != null){
            //TODO notify the broker
            return this.modelMapper.map(conferenceSave, ConferenceInDTO.class);
        }else {
            return null;
        }
    }


}
