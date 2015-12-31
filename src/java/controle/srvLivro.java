/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import DAO.LivroDAO;
import dominio.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ederson
 */
public class srvLivro extends HttpServlet {

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
            String cmd = request.getParameter("cmd");
            String isbn = request.getParameter("isbn");
            String id_serie = request.getParameter("serie");
            String titulo = request.getParameter("titulo");
            String autor = request.getParameter("autor");
            String editora = request.getParameter("editora");
            String cidade = request.getParameter("cidade");
            String ano = request.getParameter("ano");
            String edicao = request.getParameter("edicao");
            String sinopse = request.getParameter("sinopse");
            String gotit = request.getParameter("gotit");
            String interesse = request.getParameter("interesse");
            String add = request.getParameter("add");
            String erro;

            if (LivroDAO.incluir(isbn, titulo, Integer.parseInt(id_serie), autor, editora, cidade, Integer.parseInt(ano), Integer.parseInt(edicao))) {
                if (add.equals("true")) {
                    HttpSession sessao = request.getSession();
                    Usuario usuario = (Usuario) sessao.getAttribute("usuario");
                    if (usuario != null) {
                        out.println(usuario.getId());
                        erro = usuario.toString();
                        RequestDispatcher rd = request.getRequestDispatcher("srvUserLivro?iduser=" + usuario.getId() + "&isbn=" + isbn + "&gotit=" + gotit + "&interesse=" + interesse);
                        rd.forward(request, response);
                    } else {
                        erro = "Usuário não encontrado!";
                    }

                }
                RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
                rd.forward(request, response);
            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet srvLivro</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet srvLivro at " + request.getContextPath() + "</h1>");
            out.println("<table>");

            out.println("</table>");
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
