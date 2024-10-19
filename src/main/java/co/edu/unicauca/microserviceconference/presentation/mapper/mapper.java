package co.edu.unicauca.microserviceconference.presentation.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class mapper {
    @Bean
    public ModelMapper modelMapper() {
        System.out.println("Invocando metodo automaticamente");
        return new ModelMapper();
    }
}
