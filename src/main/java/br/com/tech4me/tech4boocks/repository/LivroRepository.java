package br.com.tech4me.tech4boocks.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.tech4boocks.model.Livro;

public interface LivroRepository extends MongoRepository<Livro, String> {
    
}
