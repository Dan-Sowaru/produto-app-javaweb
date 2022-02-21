package br.com.letscode.produtoapp.modelo.acao;

import br.com.letscode.produtoapp.dao.BancoDeDados;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoverProdutos {

    private final HttpServletRequest requisicao;
    private final HttpServletResponse resposta;

    public RemoverProdutos(HttpServletRequest requisicao, HttpServletResponse resposta) {
        this.requisicao = requisicao;
        this.resposta = resposta;
    }

    public void executar() {
        String id = requisicao.getParameter("id");
        Integer idComoInteger = Integer.valueOf(id);
        BancoDeDados bancoDeDados = new BancoDeDados();
        bancoDeDados.removerProduto(idComoInteger);

        try {
            resposta.sendRedirect("/produto-app/controladora?acao=listar-produtos");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
