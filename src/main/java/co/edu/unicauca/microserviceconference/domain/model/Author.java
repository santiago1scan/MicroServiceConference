package co.edu.unicauca.microserviceconference.domain.model;

public class Author {
    private String id;
    private String name;
    private String email;

    public Author(String id, String name, String email) {
        this.id=id;
        this.name=name;
        this.email=email;
    }
    public Author(){}
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
