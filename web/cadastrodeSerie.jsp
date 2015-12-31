<%-- 
    Document   : cadastrodeSerie
    Created on : 27/12/2015, 16:34:50
    Author     : ederson
--%>

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
        
        <h1>Nova Série</h1>
        <form action="srvSerie" method="POST">
             <fieldset style="background-color: wheat">
            Titulo: <input type="text" name="titulo" value="" required/><br>
            <input type="submit" value="Salvar" /><input type="reset" value="Limpar" />
            </fieldset>
        </form>
    </body>
</html>
