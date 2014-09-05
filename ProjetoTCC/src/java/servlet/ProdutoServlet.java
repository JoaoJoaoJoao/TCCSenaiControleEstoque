package servlet;

import entity.Produto;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProdutoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nomeProduto = req.getParameter("Nome do Produto");
        String custoProduto = req.getParameter("Custo do Produto");
        String valorProduto = req.getParameter("Valor do Produto");
        Produto novoProduto = new Produto();
        novoProduto.setNomeProduto(nomeProduto);
        novoProduto.setCustoProduto(Double.parseDouble(custoProduto));
        novoProduto.setValorProduto(Double.parseDouble(valorProduto));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

}
