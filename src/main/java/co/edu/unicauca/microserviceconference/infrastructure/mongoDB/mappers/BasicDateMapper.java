package co.edu.unicauca.microserviceconference.infrastructure.mongoDB.mappers;

import co.edu.unicauca.microserviceconference.domain.model.BasicDate;
import co.edu.unicauca.microserviceconference.infrastructure.mongoDB.documents.BasicDateDocument;

public class BasicDateMapper {

    public static BasicDateDocument toBasicDateDocument(BasicDate basicDate) {
        return new BasicDateDocument(
                basicDate.getDay(),
                basicDate.getMonth(),
                basicDate.getYear()
        );
    }

    public static BasicDate toBasicDate(BasicDateDocument basicDateDocument) {
        return new BasicDate(
                basicDateDocument.getDay(),
                basicDateDocument.getMonth(),
                basicDateDocument.getYear()
        );
    }
}
