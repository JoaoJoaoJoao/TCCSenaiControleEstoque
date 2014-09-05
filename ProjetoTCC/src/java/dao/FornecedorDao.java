package dao;

import entity.Fornecedor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class FornecedorDao {

    public void salvar(Fornecedor fornecedor) {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/senai", "root", "");
            PreparedStatement sttm = connection.prepareStatement("insert into contatos(nome, telefone) values(?,?)");
            sttm.setString(1, fornecedor.getNomeFornecedor());
            sttm.setInt(2, fornecedor.getCnpj());
            sttm.setString(3, fornecedor.getTelefoneFornecedor());
            sttm.setInt(4, fornecedor.getIncricaoEstadual());
            sttm.setString(4, fornecedor.getNomeContatoFornecedor());

            sttm.executeUpdate();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
