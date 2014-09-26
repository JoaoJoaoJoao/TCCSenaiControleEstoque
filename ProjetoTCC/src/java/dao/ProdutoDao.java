package dao;

import entity.Produto;
import java.util.List;

public interface ProdutoDao {

    public Produto salvar(Produto produto);

    public List<Produto> getAll();

    public Produto getById(Integer id);

    public Boolean excluir(Produto produto);

    public Boolean autenticar(String user, String senha);

}
