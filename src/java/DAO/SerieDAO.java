/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
public class SerieDAO {

    public static boolean incluir(String nome) {
        boolean sucesso = false;
        try {
            String sql = "insert into serie(titulo) values (?)";
            Serie s = new Serie();
            s.setTitulo(nome);
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, s.getTitulo());
            return stmt.executeUpdate() != 0;
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return sucesso;
    }

    public static boolean editar(String id, String nome) {
        boolean sucesso = false;
        try {
            Serie s = new Serie();
            s.setTitulo(nome);
            s.setId(Integer.parseInt(id));

            String sql = "update autor set nome = ? where id = ?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, s.getTitulo());
            stmt.setInt(2, s.getId());
            return stmt.executeUpdate() != 0;
        } catch (NullPointerException | SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return sucesso;
    }

    public static boolean excluir(int id) {
        boolean sucesso = false;
        try {
            Serie s = new Serie();
            s.setId(id);
            String sql = "delete from autor where id = ?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, s.getId());
            if (stmt.executeUpdate() == 0) {
                return false;
            }
            return true;
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return sucesso;
    }

    public static String listar() {
        String retorno = "";
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "select * from serie";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                retorno = retorno + "<tr>"
                        + "<td>" + rs.getInt("id") + "<td>"
                        + "<td>" + rs.getString("Titulo") + "<td>"
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

    public static String listaselect() {
        String retorno = "";
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "select * from serie";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                retorno = retorno + " <option value=" + rs.getInt("id") + ">" + rs.getString("Titulo") + "</option>";

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
