package dao;

import entity.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ProdutoDao {

    public void salvar(Produto produto) {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/ProjetoTCC", "root", "");
            PreparedStatement sttm = connection.prepareStatement("insert into ProjetoTCC.Produto(nomeProduto , custoProduto , valorProduto,unidade) values(?,?,?,?)");
            sttm.setString(1, produto.getNomeProduto());
            sttm.setDouble(2, produto.getCustoProduto());
            sttm.setDouble(3, produto.getValorProduto());
            sttm.setInt(4, produto.getUnidade());

            sttm.executeUpdate();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();

        }

    }
}
