package br.com.tech4me.tech4boocks.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.dto.LivroDTO;

public interface LivroService {
    
    LivroDTO criarLivro(LivroDTO livro);
    List<LivroDTO> obterLivros();
    Optional<LivroDTO> obterLivroPorId(String id);
    void removerLivroPorId(String id);
    LivroDTO atualizaLivro(String id , LivroDTO livro);
}
