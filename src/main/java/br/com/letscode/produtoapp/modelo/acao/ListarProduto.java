package br.com.letscode.produtoapp.modelo.acao;

import br.com.letscode.produtoapp.dao.BancoDeDados;
import br.com.letscode.produtoapp.modelo.Produto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListarProduto {

    private final HttpServletRequest requisicao;
    private final HttpServletResponse resposta;

    public ListarProduto(HttpServletRequest requisicao, HttpServletResponse resposta) {
        this.requisicao = requisicao;
        this.resposta = resposta;
    }

    public void executar() {
        BancoDeDados bd = new BancoDeDados();
        List<Produto> produtos = bd.listar();
        requisicao.setAttribute("produtos", produtos);
        requisicao.setAttribute("titulo", "Lista de Produtos");
        try {
            requisicao. getRequestDispatcher("WEB-INF/listar-produtos.jsp").forward(requisicao, resposta);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }

    }
}
