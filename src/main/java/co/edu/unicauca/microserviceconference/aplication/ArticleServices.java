package co.edu.unicauca.microserviceconference.aplication;

import co.edu.unicauca.microserviceconference.domain.interfaces.IArticleRepository;
import co.edu.unicauca.microserviceconference.domain.interfaces.IAuthorRepository;
import co.edu.unicauca.microserviceconference.domain.interfaces.IConferencesRepository;
import co.edu.unicauca.microserviceconference.domain.model.Article;
import co.edu.unicauca.microserviceconference.infrastructure.dtro.ArticleDTRO;
import co.edu.unicauca.microserviceconference.presentation.dto.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ArticleServices{

    @Autowired
    private final IArticleRepository repository;
    private final IAuthorRepository authorRepository;
    private final IConferencesRepository conferencesRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ArticleServices(IArticleRepository repository, ModelMapper modelMapper, IConferencesRepository conferencesRepository, IAuthorRepository authorRepository ) {
        this.repository = repository;
        this.conferencesRepository = conferencesRepository;
        this.authorRepository = authorRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * @brief save the ArticleDTO
     * @param articleDTO articleDTO to save
     * @return artiticleDTO save or Null
     */
    public ArticleDTO save(ArticleDTO articleDTO) {
        //if(articleDTO.getIdAuthor().equals()) Validar Author
        Article article= modelMapper.map(articleDTO, Article.class);
        this.repository.saveArticle(article);
        return  modelMapper.map(article, ArticleDTO.class);
    }

    /**
     * @brief list Articles by a conference id
     * @param idConference String id confernce to find whit the artilces
     * @return list of Auhtors register whit ARTICLESDTOS (ARRAY), CANTARTICELS, CONFERECNEOUTDTO
     */
    public ListArticleConferenceDTO  findArticleByConference(String idConference){
        if(idConference == null)
            return null;
        List<ArticleDTRO> articles = repository.findAllArticles();
        List<ArticleDTO> articleDTOs = modelMapper.map(articles, new TypeToken<List<ArticleDTO>>(){}.getType());
        ListArticleConferenceDTO  listArticleConferenceDTO = new ListArticleConferenceDTO();
        listArticleConferenceDTO.setArticles(articleDTOs);
        listArticleConferenceDTO.setCantArticles(articles.size());
        listArticleConferenceDTO.setConferenceOutDTO(modelMapper.map(conferencesRepository.findById(idConference), ConferenceOutDTO.class));
        return listArticleConferenceDTO;
    }

    /**
     * @brief list Articles by a articulos id
     * @param idAuthor String id confernce to find whit the artilces
     * @return list of Auhtors register whit ARTICLESDTOS (ARRAY), CANTARTICELS, AUTHORDTO
     */

    public ListArticleAuthorDTO  findArticleByAuthor(String idAuthor){
        if(idAuthor == null){
            return null;
        }
        List<ArticleDTRO> articles = repository.findAllArticles();
        ArrayList<ArticleDTO> articleDTOs = modelMapper.map(articles, new TypeToken<List<ArticleDTO>>(){}.getType());
        ListArticleAuthorDTO listArticleAuthorDTO = new ListArticleAuthorDTO();
        listArticleAuthorDTO.setTotalArticles(articles.size());
        listArticleAuthorDTO.setArticles(articleDTOs);
        listArticleAuthorDTO.setAuthor(authorRepository.findById(idAuthor).getName()); //Fallo de capa?
        return listArticleAuthorDTO;
    }

    /**
     * @brief find the article by id
     * @param id id of ARTICLE
     * @return ArticleDTO find
     */
    public ArticleDTO findArtilceByID(String id){
        if(id.equals("") || id == null){
            return null;
        }
        ArticleDTRO articleEntity = this.repository.findArticleById(id);
        if(articleEntity != null){
            return this.modelMapper.map(articleEntity, ArticleDTO.class);
        }
        return null;
    }

    /**
     * @brief update the register articleDTO
     * @param id id of Article to update
     * @param articleDTO Article to update
     * @return Article update or null
     */
    public ArticleDTO update(String id, ArticleDTO articleDTO) {
        if(repository.findArticleById(id) == null)
                return null;
        Article article = modelMapper.map(articleDTO, Article.class);
        repository.updateArticle(article, id);
        ArticleDTRO updateArticle = repository.findArticleById(id);
        return this.modelMapper.map(updateArticle, ArticleDTO.class);
    }

    /**
     * @breif pass to param id for eliminated ArticleDTO
     * @param id Article id to elimanted
     * @return  ArticleDTO eliminated
     */
    public ArticleDTO delete(String id) {
        if(repository.findArticleById(id) == null)
            return null;
        repository.deleteArticleById(id);
        ArticleDTRO deleteArticle = repository.findArticleById(id);
        return modelMapper.map(deleteArticle, ArticleDTO.class);
    }

}
