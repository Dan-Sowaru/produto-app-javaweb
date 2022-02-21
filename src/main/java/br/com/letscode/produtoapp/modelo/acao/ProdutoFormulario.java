package br.com.letscode.produtoapp.modelo.acao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProdutoFormulario {

    private final HttpServletRequest requisicao;
    private final HttpServletResponse resposta;

    public ProdutoFormulario(HttpServletRequest requisicao, HttpServletResponse resposta) {
        this.requisicao = requisicao;
        this.resposta = resposta;
    }

    public void executar() {
        try {
            requisicao.getRequestDispatcher("WEB-INF/produto-form.jsp").forward(requisicao, resposta);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
