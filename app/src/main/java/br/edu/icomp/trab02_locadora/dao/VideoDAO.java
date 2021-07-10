package br.edu.icomp.trab02_locadora.dao;

import br.edu.icomp.trab02_locadora.connection.BancoDeDados;

import br.edu.icomp.trab02_locadora.enums.ClassIndicativa;
import br.edu.icomp.trab02_locadora.enums.ProdutoStatus;
import br.edu.icomp.trab02_locadora.enums.ProdutoTipo;
import br.edu.icomp.trab02_locadora.entity.Video;

public class VideoDAO extends BancoDeDados {
    public void listarVideos() {
        try {
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM video");

            while(rs.next()) {
                System.out.println("Codigo: " + rs.getString(1) + ", Titulo: " + rs.getString(3));
            }
        }catch(SQLException e) { }
    }

    public boolean adicionarVideo(Video video) {
        try {
            String sql = "INSERT INTO video VALUES ('" +
                    video.getCodigo() + "', '" +
                    video.getTipo() + "', '" +
                    video.getTitulo() + "', '" +
                    video.getProdutora() + "', '" +
                    video.getAno() + "', '" +
                    video.isStatus() + "', '" +
                    video.isLancamento() + "', '" +
                    video.getDiretor() + "', '" +
                    video.getSinopse() + "', '" +
                    video.getClassificacao() + "', '" +
                    video.getDuracao() +"')";

            Statement st = conexao.createStatement();
            st.executeUpdate(sql);

            return true;
        }catch(SQLException e) { return false;}
    }

    public boolean atualizarVideo(Video video) {
        try {
            String sql = "UPDATE audio SET "
                    + "titulo='" + video.getTitulo() + "', "
                    + "produtora='" + video.getProdutora() + "', "
                    + "ano='" + video.getAno() + "', "
                    + "status='" + video.isStatus() + "', "
                    + "lancamento='" + video.isLancamento() + "', "
                    + "diretor='" + video.getDiretor() + "', "
                    + "sinopse='" + video.getSinopse() + "', "
                    + "classificacao='" + video.getClassificacao() + "', "
                    + "duracao='" + video.getDuracao() +
                    "' WHERE codigo='" + video.getCodigo() + "'";


            Statement st = conexao.createStatement();
            st.executeUpdate(sql);

            return true;
        }catch(SQLException e) { return false;}
    }

    public boolean removerVideo(Video video) {
        try {
            String sql = "DELETE FROM video WHERE codigo='" + video.getCodigo() +"'";

            Statement st = conexao.createStatement();
            st.executeUpdate(sql);

            return true;
        }catch(SQLException e) { return false;}
    }

    public Video buscarPorTitulo (String titulo) {
        try {
            String sql = "SELECT * FROM video WHERE " + "titulo= '" + titulo + "'";

            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if(rs.next()) {
                return new Video(rs.getInt(1), ProdutoTipo.CD, rs.getString(3), rs.getString(4), rs.getInt(5), ProdutoStatus.DISPONIVEL, rs.getBoolean(7),  rs.getString(8), rs.getString(9), ClassIndicativa.LIVRE, rs.getInt(11));
            }
            else return null;
        }catch(SQLException e) { return null;}
    }

    public static void main (String args []) {
        VideoDAO videoDAO = new VideoDAO();
        Video video = new Video(1, ProdutoTipo.CD, "Batidão ao Vivo", "XenouraRecords", 2021, ProdutoStatus.DISPONIVEL, true, "The Blend", "Show realizado na cozinha", ClassIndicativa.LIVRE, 120);

        videoDAO.adicionarVideo(video);
        videoDAO.listarVideos();
    }
}

