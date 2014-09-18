package dao;

import entity.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDaoMySql {

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

    public List<Produto> getAll() {
        List<Produto> lista = new ArrayList<Produto>();
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            Connection conex = DriverManager.getConnection("jdbc:mysql://localhost/senai", "root", "");
            String sql = "select * from contatos";
            PreparedStatement stmt = conex.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Produto pro = new Produto();
                pro.setIdProduto(rs.getInt("id"));
                pro.setNomeProduto(rs.getString("nome"));
                pro.setCustoProduto(rs.getDouble("custo"));
                pro.setUnidade(rs.getInt("unidade"));
                pro.setValorProduto(rs.getInt("valor"));
                lista.add(pro);
            }

            conex.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }

}
