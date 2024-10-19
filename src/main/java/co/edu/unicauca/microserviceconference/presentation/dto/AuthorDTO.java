package co.edu.unicauca.microserviceconference.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AuthorDTO {
    private String id;
    private String name;
    private String email;
    private String password;
}
