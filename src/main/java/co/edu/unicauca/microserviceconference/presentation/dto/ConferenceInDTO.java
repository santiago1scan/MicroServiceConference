package co.edu.unicauca.microserviceconference.presentation.dto;


import co.edu.unicauca.microserviceconference.domain.model.BasicDate;
import co.edu.unicauca.microserviceconference.domain.model.Organizer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConferenceInDTO {
    private String name;
    private BasicDate startDate;
    private BasicDate finishDate;
    private String place;
    private String topic;
    private String idOrganizer;
    private String description;
    public ConferenceInDTO() {}

}
