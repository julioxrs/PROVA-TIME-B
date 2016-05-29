package br.ceuma.agendamento.sessao;

import br.ceuma.agendamento.modelo.Usuario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     @Override
    public void doFilter(ServletRequest request,
            ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        Usuario usuario = null;

        // recupera sessão atual ou cria uma caso não exista
        HttpSession sessao = ((HttpServletRequest) request).getSession(false);

        if (sessao != null) {
            usuario = (Usuario) sessao.getAttribute("usuarioLogado");
        } else { 
            // se a sessão for null ou tiver sido encerrada
            String contextPath = ((HttpServletRequest) request).getContextPath();
            
            ((HttpServletResponse) response).sendRedirect(""
                    + "index.xhtml");
        }
        chain.doFilter(request, response);

    }

    
    @Override
    public void destroy() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
