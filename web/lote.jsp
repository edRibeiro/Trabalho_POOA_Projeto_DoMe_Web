<%-- 
    Document   : lote
    Created on : 30/12/2015, 14:21:56
    Author     : ederson
--%>
<%@page import="dominio.Livro"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.Map"%>
<%@page import="DAO.SerieDAO"%>
<%
    String serie = SerieDAO.listaselect();
    String cadastro = "";
    String autor = "";
    String editora = "";
    String cidade = "";
    HttpSession sessao = request.getSession();
    Vector livros = (Vector) sessao.getAttribute("livros");
    if (livros != null) {
        Livro l = (Livro) livros.get(0);
        autor = l.getAutor();
        editora = l.getEditora();
        cidade = l.getCidade();
        int qtde = livros.size();
        if (qtde > 0) {
            for (int i = 0; i <= qtde; i++) {
                 l = (Livro) livros.get(i);
                cadastro += "ISBM:<input type=\"text\" name=\"isbn" + i + "\" value=\""+l.getIsbn()+"\" />"
                        + "Titulo:<input type=\"text\" name=\"titulo" + i + "\" value=\""+l.getTitulo()+"\" />"
                        + "Edição:<input type=\"text\" name=\"edicao" + i + "\" value=\""+l.getEdicao()+"\" />"
                        + "Ano:<input type=\"text\" name=\"ano" + i + "\" value=\""+l.getAno()+"\" /><br><br>";
            }
        }
    }
    cadastro += "ISBM:<input type=\"text\" name=\"isbn\" value=\"\" />"
            + "Titulo:<input type=\"text\" name=\"titulo\" value=\"\" />"
            + "Edição:<input type=\"text\" name=\"edicao\" value=\"\" />"
            + "Ano:<input type=\"text\" name=\"ano\" value=\"\" /><br><br>";

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
    <section style="padding-left: 100px; padding-right: 25%;">
        <form action="srvLote" method="GET" style="background-color: whitesmoke;">            
            <fieldset style="background-color: wheat">
                <h1>Cadastro de Livros</h1>


                Serie:<select name="serie">                   
                    <%=serie%>
                </select>
                <a href="cadastrodeSerie.jsp"><img src="Imagens/add.png" width="15" height="15" alt="add"/></a>                
                Autor:<input type="text" name="autor" value="<%=autor %>" />
                Editora:<input type="text" name="editora" value="<%=editora %>" />
                Cidade:<input type="text" name="cidade" value="<%=cidade %>" /><br>
                <%=cadastro %>

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
