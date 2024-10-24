package co.edu.unicauca.microserviceconference.infrastructure.broker.consumer;

import co.edu.unicauca.microserviceconference.domain.model.Organizer;
import co.edu.unicauca.microserviceconference.infrastructure.dtro.UserDTRO;
import co.edu.unicauca.microserviceconference.infrastructure.mongoDB.mogoRepositories.MongoRepositoryAuthor;
import co.edu.unicauca.microserviceconference.infrastructure.mongoDB.mogoRepositories.MongoRepositoryOrganizer;
import co.edu.unicauca.microserviceconference.infrastructure.mongoDB.repositories.AuthorRepositoryMongo;
import co.edu.unicauca.microserviceconference.infrastructure.mongoDB.repositories.OrganizerRepositoryMongo;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    private AuthorRepositoryMongo mongoRepositoryAuthor;
    private OrganizerRepositoryMongo mongoRepositoryOrganizer;

    @RabbitListener(queues = "users")
    public void receiveMessage(UserDTRO objClienteCreado) {
        System.out.println("Datos del cliente recibidos");

        if (objClienteCreado.getRol().equals("organizer")) {
            mongoRepositoryOrganizer.saveOrganizer(new Organizer(
                    objClienteCreado.getId(),
                    objClienteCreado.getName(),
                    objClienteCreado.getEmail()
            ));
        } else {
            mongoRepositoryAuthor.saveAuthor(new Organizer(
                    objClienteCreado.getId(),
                    objClienteCreado.getName(),
                    objClienteCreado.getEmail()
            ));
        }
    }
}
    