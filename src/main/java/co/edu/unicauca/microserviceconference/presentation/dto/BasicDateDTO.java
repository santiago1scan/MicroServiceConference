package co.edu.unicauca.microserviceconference.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class BasicDateDTO {
    private int day;
    private int month;
    private int year;
    public BasicDateDTO() {}
}
