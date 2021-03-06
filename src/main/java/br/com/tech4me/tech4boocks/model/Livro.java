package br.com.tech4me.tech4boocks.model;

import java.util.Optional;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.tech4me.dto.LivroDTO;

@Document("livros")
public class Livro {
    @Id
    private String id;
    private String titulo;
    private String autor;
    private String editora;
    private Integer anoLancamento;
    private double valor;
    private double preçoDeCusto;
    private double margemDeLucro;
    
    public String getId() {
        return id;
    }
    
    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getAutor() {
        return autor;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public String getEditora() {
        return editora;
    }
    
    public void setEditora(String editora) {
        this.editora = editora;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getPreçoDeCusto() {
        return preçoDeCusto;
    }

    public void setPreçoDeCusto(double preçoDeCusto) {
        this.preçoDeCusto = preçoDeCusto;
    }

    public double getMargemDeLucro() {
        return margemDeLucro;
    }

    public void setMargemDeLucro(double margemDeLucro) {
        this.margemDeLucro = margemDeLucro;
    }

    public Optional<LivroDTO> stream() {
        return null;
    }
    
    
}
