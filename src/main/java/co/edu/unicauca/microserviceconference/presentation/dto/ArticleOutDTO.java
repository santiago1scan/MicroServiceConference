package co.edu.unicauca.microserviceconference.presentation.dto;

import co.edu.unicauca.microserviceconference.domain.model.BasicDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ArticleOutDTO {
    private String name;
    private String idAuthor;
    private String KeyWords;
    private BasicDate publishDate;
}
