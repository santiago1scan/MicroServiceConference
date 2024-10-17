package co.edu.unicauca.microserviceconference.domain.model;

import java.util.Date;

public class Conference {
    private int id;
    private String place;
    private String basicInfo;
    private String topics;
    private Date date;
    private User user;
    private Article article;
    public Conference() {

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

    public User getUser() {
        return user;
    }

    public Article getArticle() {
        return article;
    }

    public int getId() {
        return id;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public void setUser(User user) {
        this.user = user;
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

    public void setId(int id) {
        this.id = id;
    }
}
