package facade;

import java.util.List;

import dao.ProdutoDao;
import dao.ProdutoDaoMySql;
import entity.Produto;

public class ProdutoFacade {

    ProdutoDao dao = (ProdutoDao) new ProdutoDaoMySql();

    public List<Produto> getAll() {
        return dao.getAll();
    }

    public Produto getById(Integer id) {
        return dao.getById(id);
    }

    public Boolean excluir(Produto produto) {        
        return dao.excluir(produto);
    }

    public Produto salvar(Produto produto) {
        if (produto.getNomeProduto().equals("")) {
            return null;
        } else {
            return dao.salvar(produto);
        }
    }
    
    public Boolean autenticar(String user, String senha){
    return dao.autenticar(user, senha);
    }
    
}
