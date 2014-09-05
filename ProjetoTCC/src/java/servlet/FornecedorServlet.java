package servlet;

import entity.Fornecedor;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FornecedorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nomeFornecedor = req.getParameter("Nome do Fornecedor");
        String telefoneFornecedor = req.getParameter("Telefone do Fornecedor");
        String cnpj = req.getParameter("CNPJ do Fornecedor");
        String nomeContatoFornecedor = req.getParameter("Nome do contato do Fornecedor");
        String inscricaoEstadual = req.getParameter("Inscrição Estadual");
        Fornecedor novoFornecedor = new Fornecedor();
        novoFornecedor.setNomeFornecedor(nomeFornecedor);
        novoFornecedor.setTelefoneFornecedor(telefoneFornecedor);
        novoFornecedor.setCnpj(Integer.parseInt(cnpj));
        novoFornecedor.setNomeContatoFornecedor(nomeContatoFornecedor);
        novoFornecedor.setInscricaoEstadual(Integer.parseInt(inscricaoEstadual));

    }
    
    
    
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

}
