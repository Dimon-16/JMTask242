package web.config.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import web.model.Role;
import web.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
        boolean isUser = false;
        boolean isAdmin = false;

        User user = (User) authentication.getPrincipal();
        httpServletRequest.getSession().setAttribute("user", user);
        Set<Role> roles = user.getRoles();
        for(Role role : roles) {
            if(role.getName().equals("ROLE_USER")) {
                isUser = true;
            } else if (role.getName().equals("ROLE_ADMIN")) {
                isAdmin = true;
            }
        }

        if (isUser) {
            httpServletResponse.sendRedirect("/user");
        } else if (isAdmin) {
            httpServletResponse.sendRedirect("/admin");
        } else {
            httpServletResponse.sendRedirect("/hello");
        }
    }
}