package co.edu.unicauca.microserviceconference.presentation.dto;


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
    private AuthorDTO author;
    private OrganizerDTO organizer;
    private ArticleDTO article;
}
