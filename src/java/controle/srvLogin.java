/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

//import DAO.UsuarioDAO;
//import dominio.Usuario;
import DAO.UsuarioDAO;
import dominio.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ederson
 */
@WebServlet(name = "srvLogin", urlPatterns = {"/srvLogin"})
public class srvLogin extends HttpServlet {

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
            String usuario = request.getParameter("usuario");
            String senha = request.getParameter("senha");
            String retorno = "";
            try {
                retorno = UsuarioDAO.buscar(usuario);
            } catch (Exception e) {
                RequestDispatcher rd = request.getRequestDispatcher("mensagem.jsp?retorno=Error!");
                rd.forward(request, response);
            }
            String r[] = retorno.split(":");
            if (usuario.equals(r[0]) && senha.equals(r[1])) {
                HttpSession sessao = request.getSession();
                Usuario user = (Usuario) sessao.getAttribute("usuario");
                if (user == null) {
                    user = (Usuario) UsuarioDAO.getUsuario();
                    sessao.setAttribute("usuario", user);
                } else {
                    user = (Usuario) UsuarioDAO.getUsuario();
                    sessao.setAttribute("usuario", user);
                }
                RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
                rd.forward(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("mensagem.jsp?retorno=Usuario ou Senha Invalidos!");
                rd.forward(request, response);
            }
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet srvLogin</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet srvLogin at " + request.getContextPath() + "</h1>");
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
