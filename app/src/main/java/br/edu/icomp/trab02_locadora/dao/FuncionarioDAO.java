package br.edu.icomp.trab02_locadora.dao;

import br.edu.icomp.trab02_locadora.connection.BancoDeDados;

import br.edu.icomp.trab02_locadora.enums.ClientePendencia;
import br.edu.icomp.trab02_locadora.entity.Funcionario;

public class FuncionarioDAO extends BancoDeDados {
    public void listarFuncionarios() {
        try {
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM funcionario");

            while(rs.next()) {
                System.out.println("Matricula: " + rs.getString(1) + ", Nome: " + rs.getString(3));
            }
        }catch(SQLException e) { }
    }

    public boolean adicionarFuncionario(Funcionario funcionario) {
        try {
            String sql = "INSERT INTO funcionario VALUES ('" +
                    funcionario.getMatricula() + "', '" +
                    funcionario.getCpf() + "', '" +
                    funcionario.getNome() + "', '" +
                    funcionario.getEndereco() + "', '" +
                    funcionario.getTelefone() + "', '" +
                    funcionario.getEmail() + "', '" +
                    funcionario.getDataNascimento() + "', '" +
                    funcionario.getPendencia() + "', '" +
                    funcionario.getSenha() +"')";

            Statement st = conexao.createStatement();
            st.executeUpdate(sql);

            return true;
        }catch(SQLException e) { return false;}
    }

    public boolean atualizarFuncionario(Funcionario funcionario) {
        try {
            String sql = "UPDATE funcionario SET "
                    + "nome='" + funcionario.getNome() + "', "
                    + "endereco='" + funcionario.getEndereco() + "', "
                    + "telefone='" + funcionario.getTelefone() + "', "
                    + "email='" + funcionario.getEmail() + "', "
                    + "dataNascimento='" + funcionario.getDataNascimento() + "', "
                    + "pendencia='" + funcionario.getPendencia() +
                    "' WHERE matricula='" + funcionario.getMatricula() + "'";


            Statement st = conexao.createStatement();
            st.executeUpdate(sql);

            return true;
        }catch(SQLException e) { return false;}
    }

    public boolean removerFuncionario(Funcionario funcionario) {
        try {
            String sql = "DELETE FROM funcionario WHERE cpf='" + funcionario.getCpf() +"'";

            Statement st = conexao.createStatement();
            st.executeUpdate(sql);

            return true;
        }catch(SQLException e) { return false;}
    }

    public Funcionario buscarPorNome(String nome) {
        try {
            String sql = "SELECT * FROM funcionario WHERE " + "nome= '" + nome + "'";

            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if(rs.next()) {
                return new Funcionario(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), ClientePendencia.NENHUMA, rs.getString(9));
            }
            else return null;
        }catch(SQLException e) { return null;}
    }

    public Funcionario buscarPorCpf(String cpf) {
        try {
            String sql = "SELECT * FROM funcionario WHERE " + "cpf= '" + cpf + "'";

            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if(rs.next()) {
                return new Funcionario(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), ClientePendencia.NENHUMA, rs.getString(9));
            }
            else return null;
        }catch(SQLException e) { return null;}
    }

    public static void main (String args []) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        Funcionario funcionario = new Funcionario("21999945", "02922432607", "Cap Ivara", "Mato verdinho", "9299999997", "cap.@email.com", "1986-04-06", ClientePendencia.NENHUMA, "123");

        funcionarioDAO.adicionarFuncionario(funcionario);
        funcionarioDAO.listarFuncionarios();
    }

}