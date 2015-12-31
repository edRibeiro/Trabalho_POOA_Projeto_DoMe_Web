/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import dominio.Livro;
import dominio.UserLivro;
import dominio.Usuario;
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
public class UserLivroDAO {

    public static boolean incluir(int id_user, String isbn, boolean gotit, boolean interesse) {
        boolean sucesso = false;
        try {
            String sql = "insert into user_livro(id_user, isbn_livro, gotit, interesse) values (?, ?, ?, ?)";
            UserLivro ul = new UserLivro();
            ul.setLivro(new Livro(isbn));
            Usuario u = new Usuario();
            u.setId(id_user);
            ul.setUsuario(u);
            ul.setGotit(gotit);
            ul.setStatus(interesse);
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ul.getUsuario().getId());
            stmt.setString(2, ul.getLivro().getIsbn());
            stmt.setBoolean(3, ul.getGotit());
            stmt.setBoolean(4, ul.getStatus());
            return stmt.executeUpdate() != 0;
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return sucesso;
    }

    public static boolean editar(int id, int id_user, String isbn, boolean gotit, boolean interesse) {
        boolean sucesso = false;
        try {

            String sql = "update user_livro set id_user= ?, isbn_livro= ?, gotit = ?, interesse = ? where id = ?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            UserLivro ul = new UserLivro();
            ul.setLivro(new Livro(isbn));
            Usuario u = new Usuario();
            u.setId(id_user);
            ul.setUsuario(u);
            ul.setGotit(gotit);
            ul.setStatus(interesse);

            stmt.setInt(1, ul.getUsuario().getId());
            stmt.setString(2, ul.getLivro().getIsbn());
            stmt.setBoolean(3, ul.getGotit());
            stmt.setBoolean(4, ul.getStatus());
            stmt.setInt(5, id);
            return stmt.executeUpdate() != 0;
        } catch (NullPointerException | SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return sucesso;
    }

    public static boolean excluir(int id) {
        boolean sucesso = false;
        try {

            String sql = "delete from user_livro where id = ?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return sucesso;
    }

    public static String listar(int id) {
        String retorno = "";
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "SELECT l.isbn as ISBN,l.titulo as TITULO, s.titulo as SERIE, l.autor as AUTOR, l.editora as EDITORA, l.edicao as EDICAO, l.ano as ANO from serie s, livro l , user_livro ul where s.id=l.id_serie and l.isbn=ul.isbn_livro and ul.id_user=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                retorno = retorno + "<tr>"
                        + "<td>" + rs.getString("ISBN") + "<td>"
                        + "<td>" + rs.getString("TITULO") + "<td>"
                        + "<td>" + rs.getString("SERIE") + "<td>"
                        + "<td>" + rs.getString("AUTOR") + "<td>"
                        + "<td>" + rs.getString("EDITORA") + "<td>"
                        + "<td>" + rs.getInt("EDICAO") + "<td>"
                        + "<td>" + rs.getInt("ANO") + "<td>"
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
    public static String lista(int id) {
        String retorno = "";
        try {
           Connection conn = ConnectionFactory.getConnection();
            String sql = "SELECT l.isbn as ISBN,l.titulo as TITULO, s.titulo as SERIE, l.autor as AUTOR, l.editora as EDITORA, l.edicao as EDICAO, l.ano as ANO, ul.id as ID from serie s, livro l , user_livro ul where s.id=l.id_serie and l.isbn=ul.isbn_livro and ul.id_user=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                retorno = retorno + "<tr>"
                        + "<td>" + rs.getString("ISBN") + "<td>"
                        + "<td>" + rs.getString("TITULO") + "<td>"
                        + "<td>" + rs.getString("SERIE") + "<td>"
                        + "<td>" + rs.getString("AUTOR") + "<td>"
                        + "<td>" + rs.getString("EDITORA") + "<td>"
                        + "<td>" + rs.getInt("EDICAO") + "<td>"
                        + "<td>" + rs.getInt("ANO") + "<td>"                        
                        + "<td>" +"<a href=\"srvRemover?id="+rs.getInt("ID")+"\">Excluir</a>" + "<td>"                        
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
