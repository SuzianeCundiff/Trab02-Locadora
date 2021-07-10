package br.edu.icomp.trab02_locadora.entity;

/**
 * @author Suziane Cundiff
 *
 */
import br.edu.icomp.trab02_locadora.enums.ProdutoTipo;
import br.edu.icomp.trab02_locadora.enums.ProdutoStatus;

public class Produto {

    private int codigo;
    private String titulo;
    private double valor;
    private int prazo;
    private ProdutoTipo tipo;
    private String produtora;
    private int ano;

    private ProdutoStatus status;
    private boolean lancamento;

    /**
     * @param codigo
     * @param tipo
     * @param titulo
     * @param produtora
     * @param ano
     * @param status
     * @param lancamento
     */
    public Produto(int codigo, ProdutoTipo tipo, String titulo, String produtora, int ano,
                   ProdutoStatus status, boolean lancamento) {
        super();
        this.codigo = codigo;
        this.tipo = tipo;
        this.titulo = titulo;
        this.produtora = produtora;
        this.ano = ano;
        this.status = status;
        this.lancamento = lancamento;

        setPrazo(lancamento);
        setValor(tipo);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(ProdutoTipo tipo) {
        switch(tipo) {
            case DVD:
                this.valor = 6.50;
                break;
            case BLURAY:
                this.valor = 10.00;
                break;
            case VHS:
                this.valor = 8.00;
                break;
            case CD:
                this.valor = 5.00;
                break;
            default:
                this.valor = 0.00;
                break;
        }
    }

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(boolean lancamento) {
        if(lancamento) {
            this.prazo = 1;
        }else {
            this.prazo = 3;
        }
    }

    public ProdutoTipo getTipo() {
        return tipo;
    }

    public void setTipo(ProdutoTipo tipo) {
        this.tipo = tipo;
    }

    public String getProdutora() {
        return produtora;
    }

    public void setProdutora(String produtora) {
        this.produtora = produtora;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public ProdutoStatus isStatus() {
        return status;
    }

    public void setStatus(ProdutoStatus status) {
        this.status = status;
    }

    public boolean isLancamento() {
        return lancamento;
    }

    public void setLancamento(boolean lancamento) {
        this.lancamento = lancamento;
    }


}