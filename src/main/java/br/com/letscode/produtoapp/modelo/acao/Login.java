package br.com.letscode.produtoapp.modelo.acao;

import br.com.letscode.produtoapp.modelo.Usuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login {

    private final HttpServletRequest requisicao;
    private final HttpServletResponse resposta;

    public Login(HttpServletRequest requisicao, HttpServletResponse resposta) {
        this.requisicao = requisicao;
        this.resposta = resposta;
    }


    public void executar() {

        String nome = requisicao.getParameter("nome");
        String senha = requisicao.getParameter("senha");


        if (!nome.equals("jorge")) {
            try {
                resposta.sendRedirect("/produto-app/login-form.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (!senha.equals("1234")) {
            try {
                resposta.sendRedirect("/produto-app/login-form.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Usuario usuario = new Usuario(nome, senha);
        HttpSession session = requisicao.getSession();
        session.setAttribute("usuario logado", usuario);


        try {
            resposta.sendRedirect("/produto-app/controladora?acao=listar-produtos");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
