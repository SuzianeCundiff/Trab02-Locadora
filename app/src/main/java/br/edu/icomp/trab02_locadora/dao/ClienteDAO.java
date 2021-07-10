package br.edu.icomp.trab02_locadora.dao;

import br.edu.icomp.trab02_locadora.connection.BancoDeDados;

import br.edu.icomp.trab02_locadora.enums.ClientePendencia;
import br.edu.icomp.trab02_locadora.entity.Cliente;

public class ClienteDAO extends BancoDeDados {
    public void listarClientes() {
        try {
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cliente");

            while(rs.next()) {
                System.out.println("Cliente: " + rs.getString(2) + ", CPF: " + rs.getString(3));
            }
        }catch(SQLException e) { }
    }

    public boolean adicionarCliente(Cliente cliente) {
        try {
            String sql = "INSERT INTO cliente VALUES ('" +
                    cliente.getCpf() + "', '" +
                    cliente.getNome() + "', '" +
                    cliente.getEndereco() + "', '" +
                    cliente.getTelefone() + "', '" +
                    cliente.getEmail() + "', '" +
                    cliente.getDataNascimento() + "', '" +
                    cliente.getPendencia() +"')";

            Statement st = conexao.createStatement();
            st.executeUpdate(sql);

            return true;
        }catch(SQLException e) { return false;}
    }

    public boolean atualizarCliente(Cliente cliente) {
        // UPDATE `locadora`.`cliente` SET `endereco` = 'Rua Marques Donalds' WHERE (`cpf` = '01223445689');
        try {
            String sql = "UPDATE cliente SET "
                    + "nome='" + cliente.getNome() + "', "
                    + "endereco='" + cliente.getEndereco() + "', "
                    + "telefone='" + cliente.getTelefone() + "', "
                    + "email='" + cliente.getEmail() + "', "
                    + "dataNascimento='" + cliente.getDataNascimento() + "', "
                    + "pendencia='" + cliente.getPendencia() +
                    "' WHERE cpf='" + cliente.getCpf() + "'";


            Statement st = conexao.createStatement();
            st.executeUpdate(sql);

            return true;
        }catch(SQLException e) { return false;}
    }

    public boolean removerCliente(Cliente cliente) {
        //DELETE FROM locadora.cliente WHERE cpf=01223445691;
        try {
            String sql = "DELETE FROM cliente WHERE cpf='" + cliente.getCpf() +"'";

            Statement st = conexao.createStatement();
            st.executeUpdate(sql);

            return true;
        }catch(SQLException e) { return false;}
    }

    public Cliente buscarPorNome(String nome) {
        try {
            String sql = "SELECT * FROM cliente WHERE " + "nome= '" + nome + "'";

            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if(rs.next()) {
                return new Cliente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), ClientePendencia.NENHUMA);
            }
            else return null;
        }catch(SQLException e) { return null;}
    }

    public Cliente buscarPorCpf(String cpf) {
        try {
            String sql = "SELECT * FROM cliente WHERE " + "cpf= '" + cpf + "'";

            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if(rs.next()) {
                return new Cliente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), ClientePendencia.NENHUMA);
            }
            else return null;
        }catch(SQLException e) { return null;}
    }

    public static void main (String args []) {
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = new Cliente("02922432686", "Toelho Branquinho", "Oca 02 Floresta", "92999999999", "toelho@email.com", "2018-06-04", ClientePendencia.NENHUMA);
        Cliente cliente01 = clienteDAO.buscarPorNome("Xenoura Veggie");
        System.out.println(cliente01.getNome());

        clienteDAO.adicionarCliente(cliente);
        clienteDAO.listarClientes();
    }
}