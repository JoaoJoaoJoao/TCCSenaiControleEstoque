package dao;

import entity.Produto;
import java.util.List;

public interface ProdutoDao {

    public void salvar(Produto produto);

    public List<Produto> getAll();

}
