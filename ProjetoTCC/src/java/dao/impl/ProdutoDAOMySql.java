package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.Conexao;
import dao.ProdutoDao;
import entity.Produto;

public abstract class ProdutoDAOMySql implements ProdutoDao {

    private static final String INSERT = "INSERT INTO Produto"
            + "(nomeProduto,custoProduto,valorProduto, unidade) VALUE (?,?,?,?)";
    private static final String GET_BY_ID = "SELECT * FROM CONTATOS WHERE ID = ?";
    private static final String GET_ALL = "SELECT * FROM CONTATOS";
    private static final String DELETAR = "DELETE FROM CONTATOS WHERE ID = ? ";
    private static final String UPDATE = "UPDATE CONTATOS SET nomeProduto = ?, custoProduto=?, valorProduto=?, unidade=?  WHERE ID=?";

    @Override
    public Produto getById(Integer id) {
        Produto retorno = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        con = Conexao.conectar();
        try {
            ps = (PreparedStatement) con.prepareStatement(GET_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            retorno = new Produto();
            retorno.setIdProduto(rs.getInt("id"));
            retorno.setNomeProduto(rs.getString("nomeProduto"));
            retorno.setCustoProduto(Double.parseDouble(rs.getString("custoProduto")));
            retorno.setValorProduto(Double.parseDouble(rs.getString("valorProduto")));
            retorno.setUnidade(Integer.parseInt(rs.getString("unidade")));
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return retorno;
    }

    @Override
    public List<Produto> getAll() {
        List<Produto> lista = new ArrayList<Produto>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        con = Conexao.conectar();
        try {
            ps = (PreparedStatement) con.prepareStatement(GET_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Produto c = new Produto();
                c.setIdProduto(rs.getInt("id"));
                c.setNomeProduto(rs.getString("nomeProduto"));
                c.setCustoProduto(Double.parseDouble(rs.getString("custoProduto")));
                c.setValorProduto(Double.parseDouble(rs.getString("valorProduto")));
                c.setUnidade(Integer.parseInt(rs.getString("unidade")));
                lista.add(c);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public Produto salvar(Produto produto) {
        Produto retorno = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet generatedKeys = null;
        if (produto.getIdProduto() == null) {
            try {
                con = Conexao.conectar();
                ps = (PreparedStatement) con.prepareStatement(INSERT,
                        PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, produto.getNomeProduto());
                ps.setDouble(2, produto.getCustoProduto());
                ps.setDouble(3, produto.getValorProduto());
                ps.setInt(4, produto.getUnidade());
                ps.executeUpdate();
                generatedKeys = ps.getGeneratedKeys();
                generatedKeys.next();
                produto.setIdProduto(generatedKeys.getInt(1));
                ps.close();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Conexao.desconectar(con);
            }
        } else {
            try {
                con = Conexao.conectar();
                ps = (PreparedStatement) con.prepareStatement(UPDATE);
                ps.setString(1, produto.getNomeProduto());
                ps.setDouble(2, produto.getCustoProduto());
                ps.setDouble(3, produto.getValorProduto());
                ps.setInt(4, produto.getUnidade());
                ps.setInt(5, produto.getIdProduto());
                ps.executeUpdate();
                ps.close();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Conexao.desconectar(con);
            }
        }
        return retorno;
    }

    @Override
    public Boolean excluir(Produto produto) {
        Boolean retorno = false;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = Conexao.conectar();
            ps = (PreparedStatement) con.prepareStatement(DELETAR);
            ps.setInt(1, produto.getIdProduto());
            ps.executeUpdate();
            retorno = true;
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar(con);
        }
        return retorno;
    }

    @Override
    public Boolean autenticar(String user, String senha) {
        Boolean retorno = false;
        if (user.equals("senai") && senha.equals("123")) {
            retorno = true;
        }
        return retorno;
    }
}
