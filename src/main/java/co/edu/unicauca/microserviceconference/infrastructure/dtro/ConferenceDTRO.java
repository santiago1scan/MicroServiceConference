package co.edu.unicauca.microserviceconference.infrastructure.dtro;

import co.edu.unicauca.microserviceconference.domain.model.BasicDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConferenceDTRO {
    private String id;
    private String name;
    private BasicDate startDate;
    private BasicDate finishDate;
    private String place;
    private String topic;
    private String idOrganizer;
    private String description;
}
