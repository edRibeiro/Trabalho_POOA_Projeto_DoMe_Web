<%-- 
    Document   : cadastroUsuario
    Created on : 24/12/2015, 19:05:53
    Author     : ederson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body background="Imagens/306638.jpg">
        <header>

        </header>

        <section>
            <article>
                <form action="srvUsuario?opc=cadastro" method="POST">
                    <fieldset style="background-color: wheat">
                    Nome:<input type="text" name="nome" value="" required/><br>
                    Email:<input type="email" name="email" value="" required/><br>
                    Usuario:<input type="text" name="usuario" value="" required/><br>
                    Senha:<input type="text" name="senha" value="" required/><br>
                    <input type="submit" value="Cadastrar" /><input type="reset" value="Limpar" />
                    </fieldset>
                </form>

            </article>


        </section>

        <footer>

        </footer>
    </body>
</html>
