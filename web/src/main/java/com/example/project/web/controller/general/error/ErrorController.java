package com.example.project.web.controller.general.error;

import com.example.project.web.interceptor.AdminRequired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorController {

    @RequestMapping("/404")
    @AdminRequired
    public String resourceNotFound(HttpServletRequest request, Model model) {
        String resourceName = getResourceName(request);
        model.addAttribute("requestedResource", resourceName);
        return "/error/404";
    }

    @RequestMapping("/403")
    public String accessDenied(HttpServletRequest request, Model model) {
        String resourceName = getResourceName(request);
        model.addAttribute("requestedResource", resourceName);
        return "/error/403";
    }

    @RequestMapping("/500")
    public String internalServerError(HttpServletRequest request, Model model) {
        return "/error/500";
    }

    private String getResourceName(HttpServletRequest request) {
        return (String) request.getAttribute("javax.servlet.error.request_uri");
    }
}
