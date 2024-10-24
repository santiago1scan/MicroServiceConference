package co.edu.unicauca.microserviceconference.presentation.dto;

import co.edu.unicauca.microserviceconference.domain.model.Conference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ListArticleConferenceDTO {
    private Conference conference;
    private int cantArticles;
    List<ArticleDTO> articles;
}
