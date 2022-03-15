package br.com.tech4me.tech4boocks.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
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

import br.com.tech4me.dto.LivroDTO;
import br.com.tech4me.tech4boocks.service.LivroService;
import br.com.tech4me.tech4boocks.view.model.LivroResponseDTO;
import br.com.tech4me.tech4boocks.view.model.LivroResponsePorIdDTO;

@RestController
@RequestMapping("/api/livros")
public class LivroController {
    ModelMapper mapper = new ModelMapper();

    @Autowired
    private LivroService serviço;

    @GetMapping
    public ResponseEntity<List<LivroResponseDTO>> obterLivros(){
        List<LivroDTO> dto = serviço.obterLivros();

        List<LivroResponseDTO>livros= dto.stream()
           .map(l -> mapper.map(l, LivroResponseDTO.class))
           .collect(Collectors.toList());

        return new ResponseEntity<>(livros,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroResponsePorIdDTO> obterLivroPorId(@PathVariable String id){
        Optional<LivroDTO> livro = serviço.obterLivroPorId(id);

        if (livro.isPresent()) {
            return new ResponseEntity<>(mapper.map(livro.get(), LivroResponsePorIdDTO.class)
            ,HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PostMapping
    public ResponseEntity<LivroDTO> cadastrarLivro(@RequestBody @Valid LivroDTO livro){
        return new ResponseEntity<>(serviço.criarLivro(livro),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroDTO> atualizarLivro(@PathVariable String id, @RequestBody @Valid LivroDTO livro){
        return new ResponseEntity<>(serviço.atualizaLivro(id, livro),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagarLivro(@PathVariable String id){
        serviço.removerLivroPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    
}
