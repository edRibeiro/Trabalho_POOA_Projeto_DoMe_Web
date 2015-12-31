<%-- 
    Document   : index
    Created on : 01/12/2015, 21:24:33
    Author     : ederson
--%>
<%  
    
    String retorno = request.getParameter("retorno");  
   
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head >
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>

    </head>
    <body >
        <header>
            
        </header>
        
        <section id="centro">            
            <h1><%=retorno %></h1>
            <br>
            <br>
            <br>
            <a href="index.html">Ir para P&aacute;gina de login</a>
       </section>
        
        <footer>
            
        </footer>
    </body>
</html>
