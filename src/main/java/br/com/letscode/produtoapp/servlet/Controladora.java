package br.com.letscode.produtoapp.servlet;

import br.com.letscode.produtoapp.modelo.acao.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controladora")
public class Controladora extends HttpServlet {

    @Override
    protected void service(HttpServletRequest requisicao, HttpServletResponse resposta)
            throws ServletException, IOException {

        String acao = requisicao.getParameter("acao");
        System.out.println("ENTROU NA SERVLET CONTROLADORA COM A ACAO: " + acao);

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
