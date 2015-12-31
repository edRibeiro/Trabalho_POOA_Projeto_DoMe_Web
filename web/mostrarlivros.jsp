<%-- 
    Document   : mostrarlivros
    Created on : 28/12/2015, 21:25:08
    Author     : ederson
--%>

<%@page import="DAO.LivroDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String lista=LivroDAO.listar();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="scripts/jquery.js"></script>
        <link rel="stylesheet" type="text/css" href="bootstrap-3.3.6-dist/css/bootstrap.css" />
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
        
    </head>
    <body background="Imagens/306638.jpg">
        <header>
           <nav>
            <ul>
                <li><a href="home.jsp">HOME</a></li>
                <li><a href="cadastrodelivro.jsp">Cadastro de livros</a></li>
                <li><a href="mostrarlivros.jsp">Lista de Livros</a></li>
                <li><a href="editarlistar.jsp">Editar de Livros</a></li>
                <li><a href="listarmeuslivros.jsp">Meus Livros</a></li>
            </ul>
        </nav>
        <nav id="nav">
            <ul>
                
                <li><a href="minhaconta.jsp">Minha Conta</a></li>
                <li><a href="index.html">Sair</a></li>
            </ul>
        </nav>
        </header>
        
        <section>
            <table cellspacing="1" border="1">
                <%=lista %>
            </table> 
           
        </section>

        
    </body>
</html>

