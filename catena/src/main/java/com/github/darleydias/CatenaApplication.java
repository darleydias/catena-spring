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
@RestController
public class CatenaApplication {

    @Bean
    public CommandLineRunner init(@Autowired Comarcas comarcas,@Autowired Promotores promotores){
        return args -> {
            // ********* INSERIR
            Comarca comarca1 = comarcas.save(new Comarca("Cassiterita","Especial"));
            Comarca comarca2 = comarcas.save(new Comarca("Lambarí","Odinaria"));
//          Boolean existe = comarcas.existsByNome("Cassiterita");
//          System.out.println("Existe uma comarca chamada Cassiterita? "+existe);

            Promotor p = new Promotor();
            p.setComarca(comarca1);
            p.setMamp("8789");
            p.setNome("Garibaldino");
            p.setDtNasc(LocalDate.now());
            p.setSexo("M");
            promotores.save(p);

            Promotor p2 = new Promotor();
            p2.setComarca(comarca1);
            p2.setMamp("5566");
            p2.setNome("Longinilo");
            p2.setDtNasc(LocalDate.now());
            p2.setSexo("M");
            promotores.save(p2);

//            Comarca comarca  = comarcas.findComarcaFetchPromotores(comarca1.getId());
//            System.out.println(comarca);
//            System.out.println(comarca.getPromotores());

            Set<Promotor> ListaPromotores = promotores.findByComarca(comarca1);
            ListaPromotores.forEach(System.out::println);
//
//
//            List<Comarca> result = comarcas.encontrarPorNome("Cassiterita");
//            result.forEach(System.out::println);
        };
    }

    @Value("${application.name}")
    private String applicationName;

    @GetMapping("/hello")
    public String helloWord(){
        return applicationName;
    }
    public static void main(String[] args) {
        SpringApplication.run(CatenaApplication.class,args);
    }
}

