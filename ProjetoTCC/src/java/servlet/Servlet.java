package servlet;

import entity.Produto;

import facade.ProdutoFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String comando = req.getParameter("acao");

        if (comando.equals("novo")) {
            RequestDispatcher rd = req.getRequestDispatcher("/editProduto.jsp");
            rd.forward(req, resp);
        }
        if (comando.equals("salvar")) {
            String nome = req.getParameter("campoNome");
            String custoProduto = req.getParameter("campoTelefone");
            Produto novoProduto = new Produto();
            novoProduto.setNomeProduto(nome);
            novoProduto.setCustoProduto(Double.parseDouble(""));
            ProdutoFacade facade = new ProdutoFacade();
            facade.salvar(novoProduto);
            RequestDispatcher rd = req.getRequestDispatcher("servlet?acao=listar");
            rd.forward(req, resp);

        }
        if (comando.equals("listar")) {
            ProdutoFacade facade = new ProdutoFacade();
            List<Produto> lista = facade.getAll();
            req.setAttribute("listaContato", lista);
            RequestDispatcher rd = req.getRequestDispatcher("/listaContato.jsp");
            rd.forward(req, resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

}
