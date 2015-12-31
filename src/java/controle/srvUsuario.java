/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import DAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ederson
 */
@WebServlet(name = "srvUsuario", urlPatterns = {"/srvUsuario"})
public class srvUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String opc = request.getParameter("opc");

            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String usuario = request.getParameter("usuario");
            String senha = request.getParameter("senha");
            if (opc.equals("cadastro")) {
                try {
                    if (UsuarioDAO.incluir(nome, email, usuario, senha)) {
                        RequestDispatcher rd = request.getRequestDispatcher("mensagem.jsp?retorno=Usuário cadastrado com sucesso!");
                        rd.forward(request, response);
                    } else {
                        RequestDispatcher rd = request.getRequestDispatcher("mensagem.jsp?retorno=Falha ao cadastrar usuário!");
                        rd.forward(request, response);
                    }
                } catch (ServletException | IOException e) {
                    RequestDispatcher rd = request.getRequestDispatcher("mensagem.jsp?retorno=Error!<br> Falha do cadastro de  usu&aacute;rios!");
                    rd.forward(request, response);
                }
            } else if (opc.equals("editar")) {
                try {
                   String id = request.getParameter("id");
                    //boolean status = Boolean.parseBoolean(request.getParameter("status"));
                    if (UsuarioDAO.editar(id, nome, email, usuario, senha, true, null)) {
                        RequestDispatcher rd = request.getRequestDispatcher("mensagem.jsp?retorno=Usuario aletado com sucesso!");
                        rd.forward(request, response);
                    } else {
                        RequestDispatcher rd = request.getRequestDispatcher("mensagem.jsp?retorno=Falha ao alterar usuario!");
                        rd.forward(request, response);
                    }
                } catch (NumberFormatException | ServletException | IOException e) {
                    RequestDispatcher rd = request.getRequestDispatcher("mensagem.jsp?retorno=Error!<br> Falha na atualização de  usuarios! " + e.getMessage());
                    rd.forward(request, response);
                }
            }
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet srvUsuario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet srvUsuario at " + request.getContextPath() + "</h1>");
            out.println(opc);
            out.println(nome);
            out.println(email);
            out.println(usuario);
            out.println(senha);
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
