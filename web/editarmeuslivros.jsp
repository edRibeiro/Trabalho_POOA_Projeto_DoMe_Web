<%-- 
    Document   : editarmeuslivros
    Created on : 28/12/2015, 13:40:33
    Author     : ederson
--%>
<%@page import="DAO.SerieDAO"%>
<% 
    String serie=SerieDAO.listaselect();    
    String isbn = request.getParameter("isbn");
    String id_serie = request.getParameter("serie");
    String titulo = request.getParameter("titulo");
    String autor = request.getParameter("autor");
    String editora = request.getParameter("editora");
    String cidade = request.getParameter("cidade");
    String ano = request.getParameter("ano");
    String edicao = request.getParameter("edicao");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        
        <section style="float: left; padding-left: 100px;">
            <header><h1>Cadastro de Livros</h1></header>
            <article>

                <form action="srvLivro" method="POST" style="background-color: wheat;">            



                    ISBM:<input type="text" name="isbn" value="" /><br>
                    Serie:<select name="serie">                   
                        <%=serie %>
                    </select>
                    <a href="cadastrodeSerie.jsp"><img src="Imagens/add.png" width="15" height="15" alt="add"/></a><br>
                    Titulo:<input type="text" name="titulo" value="" /><br>
                    Autor:<input type="text" name="autor" value="" /><br>
                    Editora:<input type="text" name="editora" value="" /><br>
                    Cidade:<input type="text" name="cidade" value="" /><br>
                    Ano:<input type="text" name="ano" value="" /><br>
                    Edição:<input type="text" name="edicao" value="" /><br>
                    
                    <input type="submit" value="Salvar" /><input type="reset" value="limpar" />
                </form>
            </article>

        </section>
    </body>
</html>
