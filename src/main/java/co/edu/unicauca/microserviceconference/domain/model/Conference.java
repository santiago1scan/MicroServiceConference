package co.edu.unicauca.microserviceconference.domain.model;

import java.util.Date;

public class Conference {
    private String id;
    private String place;
    private String basicInfo;
    private String topics;
    private Date date;
    private Author author;
    private Organizer organizer;
    private Article article;
    public Conference(String id, String place, String basicInfo, String topics, Date date, Author author, Organizer organizer, Article article) {
        this.id = id;
        this.place = place;
        this.basicInfo = basicInfo;
        this.topics = topics;
        this.date = date;
        this.author = author;
        this.organizer = organizer;
        this.article = article;
    }

    public String getPlace() {
        return place;
    }

    public String getBasicInfo() {
        return basicInfo;
    }

    public String getTopics() {
        return topics;
    }

    public Date getDate() {
        return date;
    }

    public Author getAuthor() {
        return author;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public Article getArticle() {
        return article;
    }

    public String getId() {
        return id;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public void setUser(Author author) {
        this.author = author;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }

    public void setBasicInfo(String basicInfo) {
        this.basicInfo = basicInfo;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }
}
