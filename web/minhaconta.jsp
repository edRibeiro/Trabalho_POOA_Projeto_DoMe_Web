<%-- 
    Document   : minhaconta
    Created on : 25/12/2015, 14:11:15
    Author     : ederson
--%>

<%@page import="DAO.UsuarioDAO"%>
<%@page import="dominio.Usuario"%>
<%
    HttpSession sessao = request.getSession();
    Usuario u = (Usuario) sessao.getAttribute("usuario");
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body background="Imagens/306638.jpg">
        <header>
           <nav>
               <ul style="display: inline;">
                <li><a href="home.jsp">HOME</a></li>
                <li><a href="cadastrodelivro.jsp">Cadastro de livros</a></li>
                <li><a href="mostrarlivros.jsp">Lista de Livros</a></li>
                <li><a href="editarlistar.jsp">Editar de Livros</a></li>
                <li><a href="listarmeuslivros.jsp">Meus Livros</a></li>
            </ul>
        </nav>
        <nav>
            <ul style="display: inline;">
                
                <li><a href="minhaconta.jsp">Minha Conta</a></li>
                <li><a href="index.html">Sair</a></li>
            </ul>
        </nav>
        </header>

        <section>
            <article>
                <form action="srvUsuario?opc=editar" method="POST" style="background-color: beige;">
                     <fieldset style="background-color: wheat">
                    ID:<input type="text" name="id" value="<%=u.getId()%>" readonly/><br>
                    Nome:<input type="text" name="nome" value="<%=u.getNome()%>" required/><br>
                    Email:<input type="email" name="email" value="<%=u.getEmail()%>" required/><br>
                    Usuario:<input type="text" name="usuario" value="<%=u.getUsuario()%>" required/><br>
                    Senha:<input type="password" name="senha" value="<%=u.getSenha()%>" required/><br>

                    <input type="submit" value="salvar" />
                    </fieldset>
                </form>

            </article>


        </section>

        <footer>

        </footer>

    </body>
</html>
