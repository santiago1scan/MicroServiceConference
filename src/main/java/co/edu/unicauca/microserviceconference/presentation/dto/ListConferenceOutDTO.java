package co.edu.unicauca.microserviceconference.presentation.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class ListConferenceOutDTO {
    private int  totalConference;
    private List<ConferenceOutDTO> conferences;
    public ListConferenceOutDTO() {}
}
