//package br.edu.icomp.trab02_locadora.dao;
//
//import br.edu.icomp.trab02_locadora.connection.BancoDeDados;
//
//import br.edu.icomp.trab02_locadora.enums.ProdutoStatus;
//import br.edu.icomp.trab02_locadora.enums.ProdutoTipo;
//import br.edu.icomp.trab02_locadora.entity.Audio;
//
//public class AudioDAO extends BancoDeDados {
//
//    public void listarAudios() {
//        try {
//            Statement st = conexao.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM audio");
//
//            while(rs.next()) {
//                System.out.println("Codigo: " + rs.getString(1) + ", Titulo: " + rs.getString(3));
//            }
//        }catch(SQLException e) { }
//    }
//
//    public boolean adicionarAudio(Audio audio) {
//        try {
//            String sql = "INSERT INTO audio VALUES ('" +
//                    audio.getCodigo() + "', '" +
//                    audio.getTipo() + "', '" +
//                    audio.getTitulo() + "', '" +
//                    audio.getProdutora() + "', '" +
//                    audio.getAno() + "', '" +
//                    audio.isStatus() + "', '" +
//                    audio.isLancamento() + "', '" +
//                    audio.getArtista() +"')";
//
//            Statement st = conexao.createStatement();
//            st.executeUpdate(sql);
//
//            return true;
//        }catch(SQLException e) { return false;}
//    }
//
//    public boolean atualizarAudio(Audio audio) {
//        try {
//            String sql = "UPDATE audio SET "
//                    + "titulo='" + audio.getTitulo() + "', "
//                    + "produtora='" + audio.getProdutora() + "', "
//                    + "ano='" + audio.getAno() + "', "
//                    + "status='" + audio.isStatus() + "', "
//                    + "lancamento='" + audio.isLancamento() + "', "
//                    + "artista='" + audio.getArtista() +
//                    "' WHERE codigo='" + audio.getCodigo() + "'";
//
//
//            Statement st = conexao.createStatement();
//            st.executeUpdate(sql);
//
//            return true;
//        }catch(SQLException e) { return false;}
//    }
//
//    public boolean removerAudio(Audio audio) {
//        try {
//            String sql = "DELETE FROM audio WHERE codigo='" + audio.getCodigo() +"'";
//
//            Statement st = conexao.createStatement();
//            st.executeUpdate(sql);
//
//            return true;
//        }catch(SQLException e) { return false;}
//    }
//
//    public Audio buscarPorTitulo (String titulo) {
//        try {
//            String sql = "SELECT * FROM audio WHERE " + "titulo= '" + titulo + "'";
//
//            Statement st = conexao.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//
//            if(rs.next()) {
//                return new Audio(rs.getInt(1), ProdutoTipo.CD, rs.getString(3), rs.getString(4), rs.getInt(5), ProdutoStatus.DISPONIVEL, rs.getBoolean(7),  rs.getString(8));
//            }
//            else return null;
//        }catch(SQLException e) { return null;}
//    }
//
//    public static void main (String args []) {
//        AudioDAO audioDAO = new AudioDAO();
//        Audio audio = new Audio(1, ProdutoTipo.CD, "Batidão", "XenouraRecords", 2021, ProdutoStatus.DISPONIVEL, true, "The Vitaminas");
//
//        audioDAO.adicionarAudio(audio);
//        audioDAO.listarAudios();
//    }
//}
