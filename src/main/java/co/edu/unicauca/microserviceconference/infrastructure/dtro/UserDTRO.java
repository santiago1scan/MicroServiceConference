package co.edu.unicauca.microserviceconference.infrastructure.dtro;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDTRO {
    private String id;
    private String name;
    private String email;
    private String password;
    private String address;
    private String rol;
    private int phone;
}
