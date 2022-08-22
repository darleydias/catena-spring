package com.github.darleydias;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Development
// define que estas configurações sá estão validas para desenvolvimento
public class SystemConfiguration {
    //mostrando qual configuração está ativa
    @Bean
    public CommandLineRunner executar(){
        return args ->{
            System.out.println("rodando a configuração de desenvolimento");
        };

    }
}
