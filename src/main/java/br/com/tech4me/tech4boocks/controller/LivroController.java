package br.com.tech4me.tech4boocks.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.tech4boocks.model.Livro;
import br.com.tech4me.tech4boocks.repository.LivroRepository;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    @Autowired
    private LivroRepository repositorio;

    @GetMapping
    public ResponseEntity<List<Livro>> obterLivros(){
        return new ResponseEntity<>(repositorio.findAll(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Livro> obterLivroPorId(@PathVariable String id){
        Optional<Livro> livro = repositorio.findById(id);

        if (livro.isPresent()) {
         return new ResponseEntity<>(livro.get(),HttpStatus.FOUND);
        }
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   
    }
        //return  new ResponseEntity<>(repositorio.findById(id).get(),HttpStatus.FOUND);
    
    
    @PostMapping
    public ResponseEntity<Livro> cadastrarLivro(@RequestBody Livro livro){
        return new ResponseEntity<>(repositorio.save(livro), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable String id, @RequestBody Livro livro){
        livro.setId(id);
        return new ResponseEntity<>(repositorio.save(livro),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagarLivro(@PathVariable String id){
        repositorio.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    
}
