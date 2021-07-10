package br.edu.icomp.trab02_locadora.entity;

import br.edu.icomp.trab02_locadora.enums.ClientePendencia;

/**
 * @author Suziane Cundiff
 *
 */
public class Cliente {
    private String cpf;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String dataNascimento;
    private String pendencia;

    /**
     * @param cpf
     * @param nome
     * @param endereco
     * @param telefone
     * @param email
     * @param dataNascimento
     * @param  pendencia
     */
    public Cliente(String cpf, String nome, String endereco, String telefone, String email, String dataNascimento, ClientePendencia pendencia) {
        super();
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.pendencia = pendencia.toString();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if(cpf.length() == 11) {
            this.cpf = cpf;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if(telefone.length() == 10 || telefone.length() == 11) {
            this.telefone = telefone;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getPendencia() {
        return pendencia;
    }

    public void setPendencia(ClientePendencia pendencia) {
        this.pendencia = pendencia.toString();
    }
}
