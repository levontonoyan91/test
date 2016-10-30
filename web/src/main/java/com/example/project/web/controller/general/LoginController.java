package com.example.project.web.controller.general;

import com.example.project.common.data.model.User;
import com.example.project.common.data.model.lcp.UserType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage(@RequestParam Optional<String> error) {
        return new ModelAndView("login", "error", error);
    }

//    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @RequestMapping("/home")
    public String home(@AuthenticationPrincipal User user) {
        if (user.getUserType() == UserType.ADMIN) {
            return "redirect:admin/home";
        }
        return "redirect:user/home";
    }
}
