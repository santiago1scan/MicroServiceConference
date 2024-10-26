package co.edu.unicauca.microserviceconference.aplication;

import co.edu.unicauca.microserviceconference.domain.interfaces.IOrganizerRepository;
import co.edu.unicauca.microserviceconference.domain.model.Organizer;

import co.edu.unicauca.microserviceconference.presentation.dto.OrganizerDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrganizerServices  {
    @Autowired
    private IOrganizerRepository organizerRepository;
    private final ModelMapper   modelMapper;
    public OrganizerServices(IOrganizerRepository organizerRepository) {
        this.organizerRepository = organizerRepository;
        this.modelMapper = new ModelMapper();
    }

    /**
     *
     * Save the Organizer
     * @param organizer OrganzierDTO complete to save
     * @return OrganizerDTO saved or null
     */
    public OrganizerDTO saveOrganizer(OrganizerDTO organizer) {
        if(organizer == null)
            return null;
        Organizer org = modelMapper.map(organizer, Organizer.class);
        return  modelMapper.map(organizerRepository.saveOrganizer(org), OrganizerDTO.class);
    }

    /**
     *
     * @return All Organizer or null
     */
    public List<OrganizerDTO> findAllOrganizers() {
        return modelMapper.map(organizerRepository.findAllOrganizers(), new TypeToken<List<OrganizerDTO>>(){}.getType());
    }

    /**
     *
     * @param id id Organizer to find
     * @return OrganizerDTO or null
     */
    public OrganizerDTO findOrganizerById(String id) {
        if(id == null){
            return null;
        }
        return modelMapper.map(organizerRepository.findOrganizerById(id), OrganizerDTO.class);
    }

    /**
     *
     * @param id id of Organizer to update
     * @return OrganizerDTO was delete or null
     */
    public OrganizerDTO deleteOrganizerById(String id) {
        if(organizerRepository.findOrganizerById(id) == null)
            return null;
        return modelMapper.map(organizerRepository.deleteOrganizerById(id), OrganizerDTO.class);
    }
}
