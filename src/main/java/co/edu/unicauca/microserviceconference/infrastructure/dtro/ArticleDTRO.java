package co.edu.unicauca.microserviceconference.infrastructure.dtro;

import co.edu.unicauca.microserviceconference.domain.model.BasicDate;
import co.edu.unicauca.microserviceconference.infrastructure.mongoDB.mappers.ArticleMapper;
import co.edu.unicauca.microserviceconference.presentation.dto.ArticleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ArticleDTRO {
    private String id;
    private String name;
    private String idAuthor;
    private String keywords;
    private BasicDate publicationDate;
    private String idconference;
    public ArticleDTRO(){}
}
