package br.edu.icomp.trab02_locadora.entity;

import br.edu.icomp.trab02_locadora.enums.*;

/**
 * @author Suziane Cundiff
 *
 */
public class Video extends Produto{

    private VideoCategoria categoria;
    private VideoGenero genero;
    private String sinopse;
    private ClassIndicativa classificacao;
    private int duracao;
    private String diretor;

    /**
     * @param codigo
     * @param tipo
     * @param titulo
     * @param produtora
     * @param ano
     * @param status
     * @param lancamento
     * @param diretor
     * @param sinopse
     * @param classificacao
     * @param duracao
     */
    public Video(int codigo, ProdutoTipo tipo, String titulo, String produtora, int ano,
                 ProdutoStatus status, boolean lancamento, String diretor, String sinopse, ClassIndicativa classificacao,
                 int duracao) {
        super(codigo, tipo, titulo, produtora, ano, status, lancamento);
        this.diretor = diretor;
        this.sinopse = sinopse;
        this.classificacao = classificacao;
        this.duracao = duracao;
    }

    public VideoCategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(VideoCategoria categoria) {
        this.categoria = categoria;
    }

    public VideoGenero getGenero() {
        return genero;
    }

    public void setGenero(VideoGenero genero) {
        this.genero = genero;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public ClassIndicativa getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(ClassIndicativa classificacao) {
        this.classificacao = classificacao;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
}
