package br.com.tech4me.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Min;

public class LivroDTO {
    
    private String id;
    @NotBlank(message = "O título deve ser preenchido")
    private String titulo;
    @NotBlank(message = "O autor deve ser informado")
    private String autor;
    private String editora;
    @Min(1950)
    private Integer anoLancamento;
    @Positive
    private double valor;
    private double preçoDeCusto;
    private double margemDeLucro;

    public String getId() {
        return id;
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
    public Integer getAnoLancamento() {
        return anoLancamento;
    }
    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
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
    
}
