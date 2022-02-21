package br.com.letscode.produtoapp.modelo.acao;

import br.com.letscode.produtoapp.dao.BancoDeDados;
import br.com.letscode.produtoapp.modelo.Produto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CadastrarProduto {
    private final HttpServletRequest requisicao;
    private final HttpServletResponse resposta;

    public CadastrarProduto(HttpServletRequest requisicao, HttpServletResponse resposta) {
        this.requisicao = requisicao;
        this.resposta = resposta;
    }

    public void executar() {
        // Coletou parametros
        String nome = requisicao.getParameter("nome");
        String descricao = requisicao.getParameter("descricao");
        String valor = requisicao.getParameter("valor");
        Double valorDouble = Double.valueOf(valor);


        // Criou objeto
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setDescricao(descricao);
        produto.setValor(valorDouble);

        //trim() apara espaços desnecessarios na String;
        String id = requisicao.getParameter("id");
        if (id != null && id.trim().length() > 0) {
            Integer idComoInteiro = Integer.valueOf(id);
            produto.setId(idComoInteiro);
        }

        //salvou no banco
        BancoDeDados bancoDeDados = new BancoDeDados();
        bancoDeDados.salvar(produto);

        try {
            resposta.sendRedirect("/produto-app/controladora?acao=listar-produtos");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

