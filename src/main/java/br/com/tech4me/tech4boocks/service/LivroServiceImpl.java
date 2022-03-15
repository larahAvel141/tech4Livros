package br.com.tech4me.tech4boocks.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.dto.LivroDTO;
import br.com.tech4me.tech4boocks.model.Livro;
import br.com.tech4me.tech4boocks.repository.LivroRepository;

@Service
public class LivroServiceImpl implements LivroService{
    
    @Autowired
    private LivroRepository repositorio;
    ModelMapper mapper = new ModelMapper();

    @Override
    public LivroDTO criarLivro(LivroDTO livro) {
        Livro livroCriar = mapper.map(livro, Livro.class);
        livroCriar = repositorio.save(livroCriar);

        return mapper.map(livroCriar, LivroDTO.class);
    }

    @Override
    public Optional<LivroDTO> obterLivroPorId(String id) {
        Optional<Livro> livros = repositorio.findById(id);
        
        if (livros.isPresent()) {
             return Optional.of(mapper.map(livros.get(), LivroDTO.class));
        }
        return Optional.empty();
    }

    @Override
    public List<LivroDTO> obterLivros() {
        List<Livro> livros = repositorio.findAll();
        
        return livros.stream()
        .map(l -> mapper.map(l, LivroDTO.class))
        .collect(Collectors.toList());
    }

    @Override
    public void removerLivroPorId(String id) {
        repositorio.deleteById(id);
    }

    @Override
    public LivroDTO atualizaLivro(String id, LivroDTO livro) {
        Livro livroAtualizar= mapper.map(livro ,Livro.class);
        livroAtualizar.setId(id);
        livroAtualizar = repositorio.save(livroAtualizar);
         
        return mapper.map(livroAtualizar,LivroDTO.class);

        
    }
    
}
