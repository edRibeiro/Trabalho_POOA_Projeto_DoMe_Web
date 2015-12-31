<%-- 
    Document   : editarlivros
    Created on : 28/12/2015, 12:52:49
    Author     : ederson
--%>
<%@page import="dominio.Usuario"%>
<%@page import="DAO.SerieDAO"%>
<%
    String serie = SerieDAO.listaselect();
    HttpSession sessao = request.getSession();
    String id_user = request.getParameter("id");
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
        
        <section style="float: left; padding-left: 100px; ">
            
          
                
                <form action="srvLivrosEditar" method="POST" style="">  
                    
                     <fieldset style="background-color: wheat">
                         <h1>Cadastro de Livros</h1>
                    <input type="hidden" name="cmd" value="editar" />
                    ISBM:<input type="text" name="isbn" value="<%=isbn %>" /><br>
                    Serie:<select name="serie">                   
                        <%=serie%>
                    </select>
                    <a href="cadastrodeSerie.jsp"><img src="Imagens/add.png" width="15" height="15" alt="add"/></a><br>
                    Titulo:<input type="text" name="titulo" value="<%=titulo %>" /><br>
                    Autor:<input type="text" name="autor" value="<%=autor %>" /><br>
                    Editora:<input type="text" name="editora" value="<%=editora %>" /><br>
                    Cidade:<input type="text" name="cidade" value="<%=cidade %>" /><br>
                    Ano:<input type="text" name="ano" value="<%=ano %>" /><br>
                    Edição:<input type="text" name="edicao" value="<%=edicao %>" /><br>
                    Sinopse:<textarea name="sinopse" rows="5" cols="50">                
                    </textarea><br>
                    
                    <div style="float: left;">
                        <input type="submit" value="Salvar" /></div><center><input type="reset" value="limpar"/></center><div>
                            </fieldset>
                </form>
                    
           

        </section>
        <section style="float: right; margin-right:  100px;background-color: wheat;">
            <h1>Nova Série</h1>
            <form action="srvSerie?cmd=editar" method="POST">
                Titulo:Serie:<select name="serie">                   
                    <%=serie%>
                </select><br>
                Novo Titulo: <input type="text" name="titulo" value="" required/><br>
                <div style="float: left;">
                        <input type="submit" value="Salvar" /></div><center><input type="reset" value="limpar"/></center>
            </form>
        </section>

    </body>
</html>
