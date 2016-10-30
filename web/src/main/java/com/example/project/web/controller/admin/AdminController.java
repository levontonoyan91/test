package com.example.project.web.controller.admin;

import com.example.project.common.data.model.User;
import com.example.project.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Controller
public class AdminController {
    private UserService userService;

    private MessageSource messageSource;

    @Autowired
    public AdminController(UserService userService,  MessageSource messageSource) {
        this.userService = userService;
        this.messageSource = messageSource;
    }

    @RequestMapping("/home")
    public String home(@AuthenticationPrincipal User user) {
        return "admin/home";
    }

    @RequestMapping("/users")
    public String userList(@AuthenticationPrincipal User user, Model model, HttpSession session) {
        List<User> users = userService.getAll(Arrays.asList(user.getId()));
        model.addAttribute("users", users);
        if (!StringUtils.isEmpty(session.getAttribute("message"))) {
            model.addAttribute("message", session.getAttribute("message"));
            session.removeAttribute("message");
        }
        return "admin/users";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userView(Model model, @RequestParam(value = "id", defaultValue = "-1") Long id, HttpSession session) {
        User user = userService.getByID(id);
        model.addAttribute("user", user);
        session.setAttribute("editingUser", user);
        return "admin/user-edit";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String userEdit(@Valid User user, BindingResult result, Model model, HttpSession session) {

        if (user.getUserStatus() == null) {
            String message = messageSource.getMessage("User status required", null, LocaleContextHolder.getLocale());
            result.addError(new FieldError("user", "status", message));
        }

        if (user.getUserType() == null) {
            String message = messageSource.getMessage("User type required", null, LocaleContextHolder.getLocale());
            result.addError(new FieldError("user", "profile", message));
        }

        boolean isEmailExist = userService.isEmailExist(user.getEmail(), user.getId());
        if (isEmailExist) {
            String message = messageSource.getMessage("Email is already exists", null, LocaleContextHolder.getLocale());
            result.addError(new FieldError("user", "email", message));
        }

        if (result.hasErrors()) {
            return "admin/user-edit";
        }

        userService.edit(user);

        session.removeAttribute("editingUser");
        String message = messageSource.getMessage("User edited", null, Locale.getDefault());
        session.setAttribute("message", message);

        return "redirect:users";
    }

    @RequestMapping(value = "/user-delete", method = RequestMethod.GET)
    public String userDelete(@RequestParam("id") Long id, HttpSession session) {
        userService.removeByID(id);

        String message = messageSource.getMessage("User deleted", null, Locale.getDefault());
        session.setAttribute("message", message);

        return "redirect:users";
    }
}
