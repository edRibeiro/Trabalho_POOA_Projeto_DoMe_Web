/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import dominio.Livro;
import dominio.Serie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ederson
 */
public class LivroDAO {

    public static boolean incluir(String isbn, String titulo, int id_serie, String autor, String editora, String cidade, Integer ano, Integer edicao) {
        boolean sucesso = false;
        try {
            String sql = "insert into livro(isbn, titulo, id_serie, autor, editora, cidade, ano, edicao) values (?, ?, ?, ?, ?, ?, ?, ?)";
            Serie s = new Serie();
            s.setId(id_serie);
            Livro l = new Livro(isbn, autor, editora, s, titulo, cidade, ano, edicao, null, null, null);
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, l.getIsbn());
            stmt.setString(2, l.getTitulo());
            stmt.setInt(3, l.getSerie().getId());
            stmt.setString(4, l.getAutor());
            stmt.setString(5, l.getEditora());
            stmt.setString(6, l.getCidade());
            stmt.setInt(7, l.getAno());
            stmt.setInt(8, l.getEdicao());

            return stmt.executeUpdate() != 0;
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return sucesso;
    }

    public static boolean editar(String isbn, String autor, String editora, int id_serie, String titulo, String cidadde, Integer ano, Integer edicao, String sinopse) {
        boolean sucesso = false;
        try {
            Serie s = new Serie();
            s.setId(id_serie);
            Livro l = new Livro(isbn, autor, editora, s, titulo, cidadde, ano, edicao, sinopse, null, null);
            String sql = "update livro set titulo= ?, id_serie= ?, autor= ? , editora= ?, cidade= ?, ano= ?, edicao= ?, sinopse= ? where isbn = ?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, l.getTitulo());
            stmt.setInt(2, l.getSerie().getId());
            stmt.setString(3, l.getAutor());
            stmt.setString(4, l.getEditora());
            stmt.setString(5, l.getCidade());
            stmt.setInt(6, l.getAno());
            stmt.setInt(7, l.getEdicao());
            stmt.setString(8, l.getSinopse());
            stmt.setString(9, l.getIsbn());
            return stmt.executeUpdate() != 0;
        } catch (NullPointerException | SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return sucesso;
    }

    public static boolean excluir(String isbn) {
        boolean sucesso = false;
        try {
            Livro l = new Livro(isbn);
            String sql = "delete from livro where isbn = ?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, l.getIsbn());
            return stmt.executeUpdate() != 0;
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return sucesso;
    }

    public static String listar() {
        String retorno = "";
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "SELECT l.isbn as ISBN, l.titulo as TITULO, s.titulo as SERIE, l.autor as AUTOR, l.editora as EDITORA, l.edicao as EDICAO, l.ano as ANO, l.cidade as CIDADE FROM livro l, serie s where l.id_serie=s.id";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                retorno = retorno + "<tr bgcolor=#f5e79e>"
                        + "<td>" + rs.getString("ISBN") + "<td>"
                        + "<td>" + rs.getString("TITULO") + "<td>"
                        + "<td>" + rs.getString("SERIE") + "<td>"
                        + "<td>" + rs.getString("AUTOR") + "<td>"
                        + "<td>" + rs.getString("EDITORA") + "<td>"
                        + "<td>" + rs.getString("CIDADE") + "<td>"
                        + "<td>" + rs.getInt("EDICAO") + "<td>"
                        + "<tr>";

            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public static String listacomedicao(int id) {
        String retorno = "";
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "select l.isbn as ISBN, l.titulo as TITULO, s.titulo as SERIE, l.autor as AUTOR, l.editora as EDITORA, l.edicao as EDICAO, l.ano as ANO "
                    + "from livro l, serie s "
                    + "where l.id_serie=s.id and not exists(select * from user_livro ul where ul.isbn_livro=l.isbn and ul.id_user=?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                retorno = retorno + "<tr bgcolor=#f5e79e>"
                        
                        + "<td>" + rs.getString("ISBN") + "<td>"
                        + "<td>" + rs.getString("TITULO") + "<td>"
                        + "<td>" + rs.getString("SERIE") + "<td>"
                        + "<td>" + rs.getString("AUTOR") + "<td>"
                        + "<td>" + rs.getString("EDITORA") + "<td>"
                      
                        + "<td>" + rs.getInt("EDICAO") + "<td>"
                        +"<td>" + rs.getInt("ANO") +  "<td><a href=\"srvRedireciona?isbn=" + rs.getString("ISBN") + "&id_user=" + id + "\">Adicionar aos meus livros.</a> <td>"
                        + "<td><a href=\"editarlivros.jsp?isbn=" + rs.getString("ISBN") + "&titulo=" + rs.getString("TITULO") + "&serie=" + rs.getString("SERIE") + "&autor=" + rs.getString("AUTOR") + "&editora=" + rs.getString("EDITORA") + "&edicao=" + rs.getInt("EDICAO") + "&ano=" + rs.getInt("ANO") + "\">Editar</a>"
                        + "<tr>";

            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
}
//+ "<td>" + rs.getInt("ANO") + "<td><a href=\"editarlivros.jsp?id=" + rs.getInt("ID") + "&isbn=" + rs.getString("ISBN") + "&titulo=" + rs.getString("TITULO") + "&serie=" + rs.getString("SERIE") + "&autor=" + rs.getString("AUTOR") + "&editora=" + rs.getString("EDITORA") + "&edicao=" + rs.getInt("EDICAO") + "&ano=" + rs.getInt("ANO") + "&cidade=" + rs.getString("CIDADE") + "\">Editar</a>"
