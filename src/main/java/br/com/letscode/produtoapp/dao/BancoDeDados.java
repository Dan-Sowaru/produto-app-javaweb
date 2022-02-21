package br.com.letscode.produtoapp.dao;

import br.com.letscode.produtoapp.modelo.Produto;

import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {

    private static List<Produto> produtos = new ArrayList<>();
    private static Integer identificador = 1;

    public void salvar(Produto produto) {
        produto.setId(identificador++);
        BancoDeDados.produtos.add(produto);

    }

    public List<Produto> listar() {
        return BancoDeDados.produtos;
    }

    public void removerProduto(Integer id) {
        for (int i = 0; i < BancoDeDados.produtos.size(); i++) {
            if (BancoDeDados.produtos.get(i).getId().equals(id)) {
                BancoDeDados.produtos.remove(i);
            }
            
        }


    }
}
