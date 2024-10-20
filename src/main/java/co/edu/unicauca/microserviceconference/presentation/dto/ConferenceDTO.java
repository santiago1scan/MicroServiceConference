package co.edu.unicauca.microserviceconference.presentation.dto;


import co.edu.unicauca.microserviceconference.domain.model.Article;
import co.edu.unicauca.microserviceconference.domain.model.Author;
import co.edu.unicauca.microserviceconference.domain.model.Organizer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
public class ConferenceDTO {
    private String id;
    private String place;
    private String basicInfo;
    private String topics;
    private Date date;
    private Author author;
    private Organizer organizer;
    private Article article;
}
