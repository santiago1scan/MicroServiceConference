package co.edu.unicauca.microserviceconference.infrastructure.mongoDB.documents;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class BasicDateDocument {
    private int day;
    private int month;
    private int year;
}
