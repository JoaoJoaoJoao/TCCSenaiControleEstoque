package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Produto;
import facade.produtoFacade;

public class Servlet extends HttpServlet {

    produtoFacade facade = new produtoFacade();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String acao = req.getParameter("acao");
        if (acao.equals("listar")) {
            // List<Contato> lista123 = facade.getAll();
            req.setAttribute("listaDeProdutos", facade.getAll());
            RequestDispatcher rd = req.getRequestDispatcher("listarProduto.jsp");
            rd.forward(req, resp);
        }
        if (acao.equals("excluir")) {
            String idAsString = req.getParameter("id");
            Integer id = Integer.parseInt(idAsString);
            Produto produto = facade.getById(id);
            facade.excluir(produto);
            RequestDispatcher rd = req.getRequestDispatcher("servlet?acao=listar");
            rd.forward(req, resp);
        }
        if (acao.equals("editar")) {
            Integer id = Integer.parseInt(req.getParameter("id"));
            Produto contato = facade.getById(id);
            req.setAttribute("produto", contato);
            RequestDispatcher rd = req.getRequestDispatcher("editaProduto.jsp");
            rd.forward(req, resp);
        }
        if (acao.equals("novo")) {
            Produto produto = new Produto();
            req.setAttribute("produto", produto);
            RequestDispatcher rd = req.getRequestDispatcher("editaProduto.jsp");
            rd.forward(req, resp);
        }
        if (acao.equals("salvar")) {
            Produto produto = new Produto();
            produto.setNomeProduto(req.getParameter("nome"));
            produto.setCustoProduto(Double.parseDouble(req.getParameter("custo")));
            produto.setUnidade(Integer.parseInt(req.getParameter("email")));
            produto.setValorProduto(Double.parseDouble(req.getParameter("cidade")));
            if (!req.getParameter("id").equals("")) {
                Integer id = Integer.parseInt(req.getParameter("id"));
                produto.setIdProduto(id);
            }
            facade.salvar(produto);
            RequestDispatcher rd = req.getRequestDispatcher("servlet?acao=listar");
            rd.forward(req, resp);
        }

    }
}
