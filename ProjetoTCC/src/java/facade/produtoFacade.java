package facade;

import dao.ProdutoDaoMySql;
import entity.Produto;
import java.util.List;

public class produtoFacade {

      public void salvar(Produto produto) {
        ProdutoDaoMySql dao = new ProdutoDaoMySql();
        dao.salvar(produto);
    }

    
    public List<Produto> getAll(){
        ProdutoDaoMySql dao = new ProdutoDaoMySql();
        return dao.getAll();
    }
}
