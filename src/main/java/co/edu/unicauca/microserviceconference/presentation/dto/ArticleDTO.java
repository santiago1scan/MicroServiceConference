package co.edu.unicauca.microserviceconference.presentation.dto;

import co.edu.unicauca.microserviceconference.domain.model.BasicDate;
import co.edu.unicauca.microserviceconference.domain.model.Conference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ArticleDTO {
    private String name;
    private String idAuthor;
    private String keywords;
    private BasicDate publicationDate;
    private ConferenceInDTO conference;
}
