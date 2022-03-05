package br.com.tech4me.tech4boocks.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.tech4boocks.model.Livro;

public interface LivroService {
    
    Livro criarLivro(Livro livro);
    List<Livro> obterLivros();
    Optional<Livro> obterLivroPorId(String id);
    void removerLivroPorId(String id);
    Livro atualizaLivro(String id , Livro livro);
}
