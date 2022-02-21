package br.com.letscode.produtoapp.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Filter;

//chamado antes da servlet
@WebFilter("/controladora")
public class AutorizacaoFilter implements Filter {

    //    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest requisicao = (HttpServletRequest) servletRequest;
        HttpServletResponse resposta = (HttpServletResponse) servletResponse;

        String acao = requisicao.getParameter("acao");

        HttpSession session = requisicao.getSession();
        Object usuario_logado = session.getAttribute("usuario logado");

        List<String> rotasProtegidas = Arrays.asList("produto-form", "cadastrar-produto", "listar-produto", "remover-produto", "alterar-produtos");
        boolean ehUmaRotaProtegida = rotasProtegidas.contains(acao);

        if (ehUmaRotaProtegida && usuario_logado == null) {
            resposta.sendRedirect("/produto-app/login-form.jsp");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

}
