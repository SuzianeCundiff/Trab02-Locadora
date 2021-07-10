package br.edu.icomp.trab02_locadora.entity;

import br.edu.icomp.trab02_locadora.enums.ClientePendencia;

/**
 * @author Suziane Cundiff
 *
 */
public class Funcionario extends Cliente{
    private String matricula;
    private String senha;

    /**
     * @param cpf
     * @param nome
     * @param endereco
     * @param telefone
     * @param email
     * @param dataNascimento
     * @param matricula
     * @param senha
     * @param pendencia
     */
    public Funcionario(String matricula, String cpf, String nome, String endereco, String telefone, String email, String dataNascimento, ClientePendencia pendencia,
                       String senha) {
        super(cpf, nome, endereco, telefone, email, dataNascimento, pendencia);
        this.matricula = matricula;
        this.senha = senha;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        if(matricula.length() == 8) {
            this.matricula = matricula;
        }
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if(3<=senha.length() && senha.length() >=15) {
            this.senha = senha;
        }
    }

}