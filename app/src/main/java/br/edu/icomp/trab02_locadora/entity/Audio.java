package br.edu.icomp.trab02_locadora.entity;

import java.util.ArrayList;

import br.edu.icomp.trab02_locadora.enums.ProdutoTipo;
import br.edu.icomp.trab02_locadora.enums.ProdutoStatus;

/**
 * @author Suziane Cundiff
 *
 */
public class Audio extends Produto{
    private String artista;
    private ArrayList<String> faixas;

    /**
     * @param codigo
     * @param tipo
     * @param titulo
     * @param produtora
     * @param ano
     * @param status
     * @param lancamento
     * @param artista
     */
    public Audio(int codigo, ProdutoTipo tipo, String titulo, String produtora, int ano,
                 ProdutoStatus status, boolean lancamento, String artista) {
        super(codigo, tipo, titulo, produtora, ano, status, lancamento);
        this.artista = artista;
        this.faixas = new ArrayList<String>();
    }

    // Gettters and Setters
    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public ArrayList<String> getFaixas() {
        return faixas;
    }

    // Métodos
	/*
	public void AddFaixa(String faixa) {
		if(!faixas.contains(faixa)) {
			faixas.add(faixa);
		}
	}

	public void MostrarFaixas(Audio cd) {
		for (int i=0; i < cd.faixas.size(); i++) {
			System.out.println(cd.faixas.get(i));
		}
	}
	*/
}