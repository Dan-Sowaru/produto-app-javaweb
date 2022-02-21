package br.com.letscode.produtoapp.servlet;

import br.com.letscode.produtoapp.modelo.acao.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/controladora")
public class Controladora extends HttpServlet {

    @Override
    protected void service(HttpServletRequest requisicao, HttpServletResponse resposta)
            throws ServletException, IOException {

        String acao = requisicao.getParameter("acao");
        System.out.println("ENTROU NA SERVLET CONTROLADORA COM A ACAO: " + acao);

        HttpSession session = requisicao.getSession();
        Object usuario_logado = session.getAttribute("usuario logado");

        List<String> rotasProtegidas = Arrays.asList("produto-form", "produto-form", "listar-produto", "remover-produto", "alterar-produtos");
        boolean ehUmaRotaProtegida = rotasProtegidas.contains(acao);

        if (ehUmaRotaProtegida && usuario_logado == null) {
            resposta.sendRedirect("/produto-app/login-form.jsp");
            return;
        }


        switch (acao) {
            case "produto-form":
                ProdutoFormulario produtoFormulario = new ProdutoFormulario(requisicao, resposta);
                produtoFormulario.executar();
                break;

            case "cadastrar-produto":
                CadastrarProduto cadastrarProduto = new CadastrarProduto(requisicao, resposta);
                cadastrarProduto.executar();
                break;

            case "listar-produtos":
                ListarProduto listarProduto = new ListarProduto(requisicao, resposta);
                listarProduto.executar();
                break;

            case "remover-produtos":
                RemoverProdutos removerProdutos = new RemoverProdutos(requisicao, resposta);
                removerProdutos.executar();
            case "alterar-produtos":
                AlterarProduto alterarProduto = new AlterarProduto(requisicao, resposta);
                alterarProduto.executar();
            case "login":
                Login login = new Login(requisicao, resposta);
                login.executar();
                break;
        }
    }
}
