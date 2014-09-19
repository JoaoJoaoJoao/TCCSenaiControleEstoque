<%-- 
    Document   : listarProduto
    Created on : 18/09/2014, 20:44:16
    Author     : joao_victor1
--%>

<%@page import="java.util.List"%>
<%@page import="entity.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
           <%
            List<Produto> lista = (List<Produto>)request.getAttribute("listaProduto");
            for(Produto umProduto: lista){
                %>
                <%=umProduto.getNomeProduto()%><br/>
                
            }
            
    </body>
</html>
