/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dominio.Livro;
import dominio.Serie;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ederson
 */
public class srvLote extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            String isbn = request.getParameter("isbn");
            String id_serie = request.getParameter("serie");
            String titulo = request.getParameter("titulo");
            String autor = request.getParameter("autor");
            String editora = request.getParameter("editora");
            String cidade = request.getParameter("cidade");
            String ano = request.getParameter("ano");
            String edicao = request.getParameter("edicao");
            HttpSession sessao = request.getSession();
            List<Livro> livros = (Vector) sessao.getAttribute("livros");
            if (livros== null) {
                livros = new ArrayList<>(3);
                sessao.setAttribute("livros", livros);
            }else{
                livros =  (List<Livro>) sessao.getAttribute("livros");
            }
            Serie s = new Serie();
            s.setId(Integer.parseInt(id_serie));
            Livro l = new Livro();
            l.setIsbn(isbn);
            l.setSerie(s);
            l.setTitulo(titulo);
            l.setAutor(autor);
            l.setEditora(editora);
            l.setEdicao(Integer.parseInt(edicao));
            l.setAno(Integer.parseInt(ano));
            l.setCidade(cidade);
            livros.add(l);
            sessao.setAttribute("livros", livros);
            response.sendRedirect("lote.jsp");
            out.println();
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
