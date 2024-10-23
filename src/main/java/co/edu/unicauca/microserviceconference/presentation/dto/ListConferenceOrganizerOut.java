package co.edu.unicauca.microserviceconference.presentation.dto;

import co.edu.unicauca.microserviceconference.domain.model.Conference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ListConferenceOrganizerOut  {
    private int  totalConference;
    private String idOrganizer;
    private ArrayList<ConferenceOutDTO> conferences;
    public ListConferenceOrganizerOut() {}
}
