package com.springboot.micro.web.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@Configuration("successHandler")
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private static final Logger LOGGER = LoggerFactory.
                                    getLogger(CustomAuthenticationSuccessHandler.class);

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,HttpServletResponse response,
                            Authentication authentication) throws IOException, ServletException {
        LOGGER.info("<<<<<<< Authentication Success handler executing >>>>>>>");
        handleSuccess(request, response, authentication);

    }

    protected void handleSuccess(HttpServletRequest request, HttpServletResponse response,
                                                Authentication authentication) throws IOException{
        LOGGER.info("<<<<<<< Authentication handleSuccess executing >>>>>>>");
        String targetUrl = determineTargetUrl(authentication);
        if (response.isCommitted()){
            LOGGER.info("Response has already been committed. Unable to redirect to " + targetUrl);
        }
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    protected String determineTargetUrl(Authentication authentication) {
        LOGGER.info("<<<<<<< Generating Dashboard as per role >>>>>>>");
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        String targetUrl = null;
        if (authorities != null) {
            for (GrantedAuthority authority : authorities) {
                if (authority.getAuthority().equals("ROLE_USER")) {
                    LOGGER.info("<<<<<<< Redirecting to User Dashboard >>>>>>>");
                    targetUrl = "user";
                }else if (authority.getAuthority().equals("ROLE_ADMIN")){
                    LOGGER.info("<<<<<<< Redirecting to Admin Dashboard >>>>>>>");
                    targetUrl = "admin";
                }
            }
        }
        return targetUrl;
    }


    public RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }

    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }
}
