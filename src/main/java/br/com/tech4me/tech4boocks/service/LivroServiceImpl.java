package br.com.tech4me.tech4boocks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.tech4boocks.model.Livro;
import br.com.tech4me.tech4boocks.repository.LivroRepository;

@Service
public class LivroServiceImpl implements LivroService{
    
    @Autowired
    private LivroRepository repositorio;

    @Override
    public Livro criarLivro(Livro livro) {
        return repositorio.save(livro);
    }

    @Override
    public Livro obterLivroPorId(String id) {
        return repositorio.findById(id).get();
    }

    @Override
    public List<Livro> obterLivros() {
        return repositorio.findAll();
    }

    @Override
    public void removerLivroPorId(String id) {
        repositorio.deleteById(id);
    }

    @Override
    public Livro atualizaLivro(String id, Livro livro) {
        livro.setId(id);
        return repositorio.save(livro);
    }
    
}
