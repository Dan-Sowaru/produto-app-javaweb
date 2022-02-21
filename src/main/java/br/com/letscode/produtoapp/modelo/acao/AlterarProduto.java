package br.com.letscode.produtoapp.modelo.acao;

import br.com.letscode.produtoapp.dao.BancoDeDados;
import br.com.letscode.produtoapp.modelo.Produto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AlterarProduto {

    private final HttpServletRequest requisicao;
    private final HttpServletResponse resposta;

    public AlterarProduto(HttpServletRequest requisicao, HttpServletResponse resposta) {
        this.requisicao = requisicao;
        this.resposta = resposta;
    }

    public void executar() {
        String id = requisicao.getParameter("id");
        Integer idcomoInteiro = Integer.valueOf(id);
        BancoDeDados bancoDeDados = new BancoDeDados();
        Produto produto = bancoDeDados.buscarPorId(idcomoInteiro);

        requisicao.setAttribute("produto", produto);

        try {
            requisicao.getRequestDispatcher("WEB-INF/produto-form.jsp").forward(requisicao, resposta);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
