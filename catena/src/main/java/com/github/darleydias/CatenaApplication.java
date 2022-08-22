package com.github.darleydias;


import com.github.darleydias.domain.entity.Comarca;
import com.github.darleydias.domain.entity.Promotor;
import com.github.darleydias.domain.repository.Comarcas;
import com.github.darleydias.domain.repository.Promotores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;


@SpringBootApplication
public class CatenaApplication {
    @Bean
    public CommandLineRunner commandLineRunner(@Autowired Comarcas comarcas){
        return args -> {
            Comarca comarca = new Comarca("Curitiba","Especial",null);
            comarcas.save(comarca);
        };

    }
    public static void main(String[] args) {
        SpringApplication.run(CatenaApplication.class,args);
    }
}