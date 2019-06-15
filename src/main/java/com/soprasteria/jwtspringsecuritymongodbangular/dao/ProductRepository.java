package com.soprasteria.jwtspringsecuritymongodbangular.dao;

import com.soprasteria.jwtspringsecuritymongodbangular.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductRepository extends MongoRepository<Product, String> {
}
