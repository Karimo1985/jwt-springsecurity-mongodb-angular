package com.soprasteria.jwtspringsecuritymongodbangular;

import com.soprasteria.jwtspringsecuritymongodbangular.dao.CategoryRepository;
import com.soprasteria.jwtspringsecuritymongodbangular.dao.ProductRepository;
import com.soprasteria.jwtspringsecuritymongodbangular.entities.Category;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.stream.Stream;

@SpringBootApplication
public class JwtSpringsecurityMongodbAngularApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtSpringsecurityMongodbAngularApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CategoryRepository categoryRepository, ProductRepository productRepository) {
        return args -> {
            Stream.of("C1 Ordianteurs" , "C2 Imprimantes").forEach( category -> {
                categoryRepository.save(new Category(category.split(" ")[0], category.split(" ")[1], new ArrayList<>()));
            });
            categoryRepository.findAll().forEach(System.out::println);
        };
    }

}
