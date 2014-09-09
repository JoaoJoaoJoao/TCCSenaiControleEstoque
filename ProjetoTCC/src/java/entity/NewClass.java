/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import dao.ProdutoDao;

/**
 *
 * @author joao_victor1
 */
public class NewClass {

    public static void main(String[] args) {
        Produto pro = new Produto();
        pro.setNomeProduto("joao");
        pro.setCustoProduto(Double.parseDouble("545"));
        pro.setUnidade(Integer.parseInt("545"));
        pro.setValorProduto(Double.parseDouble("5454"));

        ProdutoDao dao = new ProdutoDao();
        dao.salvar(pro);
        System.out.println(pro);
    }
    
}
