package com.ensolution.ensol;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping("/")
  public String home(HttpSession session) {
    if (session.getAttribute("user") == null) {
      return "redirect:/login";
    }

    return "home";
  }

  @GetMapping("/home")
  public String home() {
    return "home";
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }
}
