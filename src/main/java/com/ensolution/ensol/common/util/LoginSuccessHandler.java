package com.ensolution.ensol.common.util;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                      Authentication authentication) throws IOException, ServletException {
    HttpSession session = request.getSession();
    session.setAttribute("user", authentication.getPrincipal());

    String remember = request.getParameter("remember");
    if ("on".equals(remember)) {
      Cookie cookie = new Cookie("rememberedUsername", authentication.getName());
      cookie.setMaxAge(24 * 60 * 60);
      cookie.setPath("/");
      cookie.setHttpOnly(false); //
      response.addCookie(cookie);
    } else {
      Cookie cookie = new Cookie("rememberedUsername", null);
      cookie.setMaxAge(0);
      cookie.setPath("/");
      response.addCookie(cookie);
    }

    super.onAuthenticationSuccess(request, response, authentication);
  }
}
