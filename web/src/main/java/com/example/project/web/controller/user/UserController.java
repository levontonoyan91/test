package com.example.project.web.controller.user;

import com.example.project.common.data.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@PreAuthorize("hasRole('ROLE_USER')")
public class UserController {

    @RequestMapping("/user/home")
    public String homeUser(@AuthenticationPrincipal User user) {
        return "user/home";
    }

    @RequestMapping("/user/personal")
    public String personal(@AuthenticationPrincipal User user) {
        return "user/personal";
    }
}
