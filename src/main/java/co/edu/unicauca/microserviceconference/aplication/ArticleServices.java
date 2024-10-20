package co.edu.unicauca.microserviceconference.aplication;

import co.edu.unicauca.microserviceconference.domain.interfaces.IArticleRepository;
import co.edu.unicauca.microserviceconference.domain.model.Article;
import co.edu.unicauca.microserviceconference.presentation.dto.ArticleDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticleServices{

    @Autowired
    private IArticleRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public ArticleServices(IArticleRepository repository, ModelMapper modelMapper ) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }
    public ArticleDTO findArtilceByID(String id){
        if(id.equals("") || id == null){
            return null;
        }
        Article articleEntity = this.repository.findArticleById(id);
        if(articleEntity != null){
            return this.modelMapper.map(articleEntity, ArticleDTO.class);
        }
        return null;
    }
}
