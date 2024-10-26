package co.edu.unicauca.microserviceconference.presentation.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ListArticleConferenceDTO {
    private ConferenceOutDTO conferenceOutDTO;
    private int cantArticles;
    List<ArticleDTO> articles;
    public ListArticleConferenceDTO() {}
}
