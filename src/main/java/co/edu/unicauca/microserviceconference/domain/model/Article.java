package co.edu.unicauca.microserviceconference.domain.model;

public class Article {
    private String id;
    private String name;
    private String idAuthor;
    private String keyWords;
    private BasicDate publishDate;
    private Conference conference;

    public String getId() {return id;}
    public String getName() {return name;}
    public String getIdAuthor() {return idAuthor;}
    public Conference getConference() {return conference;}
    public String getKeyWords() {return keyWords;}

    public void setId(String id) {this.id = id;}
    public BasicDate getPublishDate() {return publishDate;}
    public void setName(String name) {this.name = name;}
    public void setIdAuthor(String idAuthor) {this.idAuthor = idAuthor;}
    public void setKeyWords(String keyWords) {this.keyWords = keyWords;}
    public void setPublishDate(BasicDate publishDate) {this.publishDate = publishDate;}

    public void setConference(Conference conference) {
        this.conference = conference;
    }
    public Article(){

    }
    public Article(String id, String name, String idAuthor, String keyWords, BasicDate publishDate) {
        this.name = name;
        this.idAuthor = idAuthor;
        this.keyWords = keyWords;
        this.publishDate = publishDate;
    }
}
