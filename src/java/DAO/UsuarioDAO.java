/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
public class UsuarioDAO {

    public static Usuario usuario;

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {

        UsuarioDAO.usuario = usuario;
    }

    public static boolean incluir(String nome, String email, String usuario, String senha) {
        boolean sucesso = false;
        try {
            String sql = "insert into usuario(nome, email, usuario, senha, status) values (?,?,?,?,?)";
            Usuario u = new Usuario(nome, email, usuario, senha, null, false, null);
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getUsuario());
            stmt.setString(4, u.getSenha());
            stmt.setBoolean(5, u.getStatus());
            if (stmt.executeUpdate() == 0) {
                return false;
            }
            return true;
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, email, e);
        }
        return sucesso;
    }

    public static boolean editar(String id, String nome, String email, String usuario, String senha, boolean status, String foto) {
        boolean sucesso = false;
        try {
            Usuario u = new Usuario(nome, email, usuario, senha, foto, status, null);
            u.setId(Integer.parseInt(id));
            String sql = "update usuario set nome = ?, email = ?, usuario = ?, senha = ?, foto = ?, status = ? where id = ?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getUsuario());
            stmt.setString(4, u.getSenha());
            stmt.setString(5, u.getFoto());
            stmt.setBoolean(6, u.getStatus());
            stmt.setInt(7, u.getId());
            return stmt.executeUpdate() != 0;
        } catch (NullPointerException | SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, email, e);
        }
        return sucesso;
    }

    public static boolean excluir(int id) {
        boolean sucesso = false;
        try {
            Usuario u = new Usuario();
            u.setId(id);
            String sql = "delete from usuario where id = ?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, u.getId());
            if (stmt.executeUpdate() == 0) {
                return false;
            }
            return true;
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return sucesso;
    }

    public static String buscar(String usuario) {
        try {
            String sql = "select * from usuario where usuario = ?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String user = rs.getString("usuario");
                String passworld = rs.getString("senha");
                String id = rs.getString("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");

                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setUsuario(rs.getString("usuario"));
                u.setSenha(rs.getString("senha"));
                u.setStatus(rs.getBoolean("status"));
                UsuarioDAO.setUsuario(u);
                rs.close();
                stmt.close();
                conn.close();
                return user + ":" + passworld + ":" + id + ":" + nome + ":" + email;
            }
            rs.close();
            stmt.close();
            conn.close();
            return "null";
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String listar() {
        String retorno = "";
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "select * from usuario";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                retorno = retorno + "<tr>"
                        + "<td>" + rs.getInt("id") + "<td>"
                        + "<td>" + rs.getString("nome") + "<td>"
                        + "<td>" + rs.getString("email") + "<td>"
                        + "<td>" + rs.getString("usuario") + "<td>"
                        + "<td>" + rs.getString("senha") + "<td>"
                        + "<td>" + rs.getString("foto") + "<td>"
                        + "<td>" + rs.getBoolean("status") + "<td>"
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
