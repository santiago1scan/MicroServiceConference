package co.edu.unicauca.microserviceconference.infrastructure.mongoDB.repositories;

import co.edu.unicauca.microserviceconference.domain.interfaces.IArticleRepository;
import co.edu.unicauca.microserviceconference.domain.model.Article;
import co.edu.unicauca.microserviceconference.infrastructure.dtro.ArticleDTRO;
import co.edu.unicauca.microserviceconference.infrastructure.mongoDB.documents.ArticleDocument;
import co.edu.unicauca.microserviceconference.infrastructure.mongoDB.mappers.ArticleMapper;
import co.edu.unicauca.microserviceconference.infrastructure.mongoDB.mogoRepositories.MongoRepositoryArticle;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.amqp.core.Queue;
import java.util.List;
import java.util.Optional;


@Repository
public class ArticleRepositoryMongo implements IArticleRepository {

    private final MongoRepositoryArticle mongoRepositoryArticle;
    private final MongoTemplate mongoTemplate;


    public ArticleRepositoryMongo(MongoRepositoryArticle mongoRepositoryArticle, MongoTemplate mongoTemplate) {
        this.mongoRepositoryArticle = mongoRepositoryArticle;
        this.mongoTemplate = mongoTemplate;
    }


    /**
     * Guarda un nuevo artículo en la base de datos.
     *
     * @param article El artículo que se va a agregar.
     * @return El DTO del artículo creado.
     */
    @Override
    public ArticleDTRO saveArticle(Article article) {
        // Establece el ID del artículo como null para que MongoDB genere uno automáticamente
        article.setId(null);

        // Convierte el objeto Article a ArticleDocument usando el mapper
        ArticleDocument articleDocument = ArticleMapper.toArticleDocument(article);

        // Guarda el documento en la base de datos
        ArticleDocument savedArticle = mongoTemplate.save(articleDocument);

        // Devuelve el DTO del artículo guardado
        return ArticleMapper.toArticleDTRO(savedArticle);
    }

    /**
     * Encuentra y devuelve todos los artículos almacenados en la base de datos.
     *
     * @return Una lista de DTOs de los artículos.
     */
    @Override
    public List<ArticleDTRO> findAllArticles() {
        // Busca todos los documentos de artículos en la base de datos
        List<ArticleDocument> articleDocuments = mongoRepositoryArticle.findAll();

        // Convierte los documentos en una lista de DTOs y los devuelve
        return articleDocuments.stream()
                .map(ArticleMapper::toArticleDTRO)
                .toList();
    }

    /**
     * Encuentra un artículo por su ID.
     *
     * @param id El ID del artículo que se va a buscar.
     * @return El DTO del artículo encontrado, o null si no se encuentra.
     */
    @Override
    public ArticleDTRO findArticleById(String id) {
        // Busca el documento de artículo por su ID
        ArticleDocument articleDocument = mongoRepositoryArticle.findById(id).orElse(null);

        // Si no se encuentra, devuelve null
        if (articleDocument == null) {
            return null;
        }

        // Convierte el documento a DTO y lo devuelve
        return ArticleMapper.toArticleDTRO(articleDocument);
    }

    /**
     * Encuentra y devuelve todos los artículos de un autor específico.
     *
     * @param idAuthor El ID del autor cuyos artículos se van a buscar.
     * @return Una lista de DTOs de los artículos del autor.
     */
    @Override
    public List<ArticleDTRO> findAllArticlesByAuthor(String idAuthor) {
        // Crea una consulta para buscar artículos con el idAuthor dado
        Query query = new Query();
        query.addCriteria(Criteria.where("idAuthor").is(idAuthor));

        // Ejecuta la consulta y obtiene los documentos de artículos
        List<ArticleDocument> articleDocuments = mongoTemplate.find(query, ArticleDocument.class);

        // Convierte los documentos en una lista de DTOs y los devuelve
        return articleDocuments.stream()
                .map(ArticleMapper::toArticleDTRO)
                .toList();
    }

    /**
     * Elimina un artículo por su ID y devuelve el DTO del artículo eliminado.
     *
     * @param id El ID del artículo que se va a eliminar.
     * @return El DTO del artículo eliminado, o null si no se encuentra.
     */
    @Override
    public ArticleDTRO deleteArticleById(String id) {
        // Busca el documento de artículo por su ID
        ArticleDocument articleDocument = mongoRepositoryArticle.findById(id).orElse(null);

        // Si el artículo no se encuentra, devuelve null
        if (articleDocument != null) {
            // Elimina el artículo de la base de datos
            mongoRepositoryArticle.deleteById(id);

            // Devuelve el DTO del artículo eliminado
            return ArticleMapper.toArticleDTRO(articleDocument);
        }
        return null;
    }

    @Override
    public ArticleDTRO updateArticle(Article article, String id) {
        // Busca el artículo por su ID
        Optional<ArticleDocument> articleOptional = mongoRepositoryArticle.findById(id);

        // Si no existe, lanza una excepción
        if (articleOptional.isEmpty()) {
            throw new RuntimeException("Article not found");
        }

        // Obtiene el documento actual del artículo
        ArticleDocument articleDocument = articleOptional.get();

        // Actualiza los campos solo si los valores proporcionados no son nulos o vacíos
        if (article.getName() != null && !article.getName().isEmpty()) {
            articleDocument.setName(article.getName());
        }
        if (article.getIdAuthor() != null && !article.getIdAuthor().isEmpty()) {
            articleDocument.setIdAuthor(article.getIdAuthor());
        }
        if (article.getKeyWords() != null && !article.getKeyWords().isEmpty()) {
            articleDocument.setKeywords(article.getKeyWords());
        }
        if (article.getPublishDate() != null) {
            articleDocument.setPublicationDate(article.getPublishDate());
        }

        // Guarda el artículo actualizado
        ArticleDocument updatedArticle = mongoTemplate.save(articleDocument);

        // Devuelve el DTO del artículo actualizado
        return ArticleMapper.toArticleDTRO(updatedArticle);
    }

}
