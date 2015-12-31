
<%@page import="DAO.SerieDAO"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : newjsp
    Created on : 18/12/2015, 16:23:35
    Author     : ederson
--%>
<% 
    String serie=SerieDAO.listaselect();    
    
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
        
        <section style="padding-left: 100px; padding-right: 60%;">
            <a href="lote.jsp">Cadastrar lote de Livros</a>
            <form action="srvLivro?cmd=cadastrar" method="POST" style="background-color: whitesmoke;">            
                <fieldset style="background-color: wheat">
                <h1>Cadastro de Livros</h1>
                
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
                Sinopse:<textarea name="sinopse" rows="5" cols="50">                
                </textarea><br>
                Adicionar a minha biblioteca?<select name="add">
                    <option value="false">Não</option>
                    <option value="true">Sim</option>
                </select><br>
                GotIt:<select name="gotit">
                    <option value="false">Não</option>
                    <option value="true">Sim</option>
                </select><br>
                Interesse: <select name="interesse">
                    <option value="false">Não</option>
                    <option value="true">Sim</option>
                </select><br><br>
                <input type="submit" value="Salvar" /><input type="reset" value="Limpar" />
               </fieldset>
            </form>
        </section>

       
    </body>
</html>

