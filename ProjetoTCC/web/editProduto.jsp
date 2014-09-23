<%-- 
    Document   : editProduto
    Created on : 18/09/2014, 20:48:02
    Author     : joao_victor1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>

        <div><h1 style="color: whitesmoke;background: black">Cadastro de Produto </h1></div>
        <form style="background: black" action="servlet" method="get">

            <h2 style="color: gold ;font-size: 20px">
                Nome do Produto  : <input type="text" name="nome" /></h2>

            <h3 style="color: gold;font-size: 20px">
                Custo do Produto : <input  type="text" name="custo"/></h3>
            <h4 style="color: gold;font-size: 20px">
                Valor do Produto : <input type="text" name="valor"/></h4>
            <input style="background: gold" type="submit" value="salvar" />
        </form>
    </center>
</body>
</html>
