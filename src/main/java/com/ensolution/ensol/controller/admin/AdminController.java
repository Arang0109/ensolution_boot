package com.ensolution.ensol.controller.admin;

import com.ensolution.ensol.dto.auth.RoleDto;
import com.ensolution.ensol.dto.auth.UserDto;
import com.ensolution.ensol.service.auth.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

  private final AdminService adminService;

  @GetMapping()
  public String adminPageView(Model m) {
    m.addAttribute("users", adminService.findAllUsers());
    return "admin/adminPageView";
  }

  @GetMapping("/register")
  public String registerUser(Model m) {
    m.addAttribute("roles", adminService.findAllRoles());
    return "admin/CreateUserView";
  }

  @PostMapping("/register")
  public String createUser(UserDto userDto, RoleDto roleDto) {
    adminService.createUser(userDto, roleDto);

    return "redirect:/admin/register";
  }
}
