package co.edu.unicauca.microserviceconference.domain.model;

import jakarta.websocket.RemoteEndpoint;

public class Article {
    private String id;
    private String name;
    private String idAuthor;
    private String keywords;
    private BasicDate publicationDate;
    private Conference conference;

    public String getId() {return id;}
    public String getName() {return name;}
    public String getIdAuthor() {return idAuthor;}
    public Conference getConference() {return conference;}
    public String getKeywords() {return keywords;}

    public void setId(String id) {this.id = id;}
    public BasicDate getPublicationDate() {return publicationDate;}
    public void setName(String name) {this.name = name;}
    public void setIdAuthor(String idAuthor) {this.idAuthor = idAuthor;}
    public void setKeywords(String keywords) {this.keywords = keywords;}
    public void setPublicationDate(BasicDate publicationDate) {this.publicationDate = publicationDate;}

    public void setConference(Conference conference) {
        this.conference = conference;
    }
    public Article(){

    }
    public Article(String id, String name, String idAuthor, String keywords, BasicDate publicationDate) {
        this.name = name;
        this.idAuthor = idAuthor;
        this.keywords = keywords;
        this.publicationDate = publicationDate;
    }
}
