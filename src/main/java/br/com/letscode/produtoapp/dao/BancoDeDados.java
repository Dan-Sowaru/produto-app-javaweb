package br.com.letscode.produtoapp.dao;

import br.com.letscode.produtoapp.modelo.Produto;

import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {

    private static List<Produto> produtos = new ArrayList<>();
    private static Integer identificador = 1;

    public void salvar(Produto produto) {

        if (produto.getId() == null) {
            produto.setId(identificador++);
            BancoDeDados.produtos.add(produto);

        } else {
            for (int i = 0; i < BancoDeDados.produtos.size(); i++) {
                if (BancoDeDados.produtos.get(i).equals(produto)) {
                    BancoDeDados.produtos.get(i).setNome(produto.getNome());
                    BancoDeDados.produtos.get(i).setDescricao(produto.getDescricao());
                    BancoDeDados.produtos.get(i).setValor(produto.getValor());
                }
            }
        }
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


    public Produto buscarPorId(Integer id) {
        for (int i = 0; i < BancoDeDados.produtos.size(); i++) {
            if (BancoDeDados.produtos.get(i).getId().equals(id)) {
                return BancoDeDados.produtos.get(i);
            }
        }
        return null;
    }
}
