package co.edu.unicauca.microserviceconference.presentation.controlleres;

import co.edu.unicauca.microserviceconference.aplication.ArticleServices;
import co.edu.unicauca.microserviceconference.aplication.ConferenceService;
import co.edu.unicauca.microserviceconference.presentation.dto.ArticleDTO;

import co.edu.unicauca.microserviceconference.presentation.dto.ArticleOutDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/articles/")
public class ArticlesController {
    @Autowired
    private ArticleServices serviceArticles;
    private ConferenceService serviceConference;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("conference/{idConference}")
    public ResponseEntity<Object> createArticleInConference(@RequestBody ArticleDTO article, @PathVariable String idConference) {
        if(article.getName().isEmpty())
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("name Date is needed");
        if(article.getPublicationDate() == null)
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Publish Date is needed");
        if(article.getKeywords() == null || article.getKeywords().isEmpty())
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Keywords is needed");
        article.setConference( serviceConference.findConferenceById(idConference));
        if(article.getConference() == null || serviceConference.findConferenceById(idConference) == null )
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("not found conference, is nedeed");
        ArticleDTO articleToSave = serviceArticles.save(article);
        if(articleToSave == null)
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Sorry, some issue creating user");
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(articleToSave, ArticleOutDTO.class));
    }


    @GetMapping("/conferences/{idConference}")
    public ResponseEntity<Object> listArticlesConference(@PathVariable String idConferenceToFind) {
        if(serviceConference.findConferenceById(idConferenceToFind) == null)
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Sorry, the id is not found");
        return  ResponseEntity.status(HttpStatus.OK).body(serviceArticles.findArticleByConference(idConferenceToFind));
    }


    @GetMapping("author/{idAuthor}")
    public ResponseEntity<Object> getArticleByIdAuthor(@RequestParam String id) {
        if(id.isEmpty())
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Sorry, the id is not found");
        return  ResponseEntity.status(HttpStatus.OK).body(serviceArticles.findArticleByAuthor(id));
    }
    @PutMapping("{idArticle}")
    public ResponseEntity<Object> updateArticle(@RequestBody ArticleDTO article, @PathVariable String idArticle) {
        if(article.getName().isEmpty())
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("name Date is needed");
        if(article.getPublicationDate() == null)
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Finish Date is needed");
        if(article.getKeywords() == null || article.getKeywords().isEmpty())
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Keywords is needed");
        ArticleDTO articleToSave = serviceArticles.update(idArticle, article);
        return ResponseEntity.status(HttpStatus.OK).body(articleToSave);
    }

}
