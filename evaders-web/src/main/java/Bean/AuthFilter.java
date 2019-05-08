package Bean;



import java.io.IOException;

import javax.faces.application.ResourceHandler;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;
public class AuthFilter implements Filter{


    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession(false);

        String loginURI = request.getContextPath() + "/login.jsf";
        String indexURI = request.getContextPath() + "/admin/user/listusers.jsf";
        String registerURI = request.getContextPath() + "/register.jsf";

        boolean loggedIn = session != null 
        		&&  session.getAttribute("user")!= null 
        		&& !((User)session.getAttribute("user")).getRole().contains("admin") ;
        boolean loginRequest = request.getRequestURI().equals(loginURI);
        boolean resourceRequest = request.getRequestURI().startsWith(request.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER);

        if (loggedIn || loginRequest || resourceRequest) {
            chain.doFilter(request, response);
        } else {

            if(session != null && session.getAttribute("user")!=null){
                response.sendRedirect(indexURI);
            }else{
                response.sendRedirect(loginURI);
            }        }

    }

    @Override
    public void destroy() {}

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }

}
 