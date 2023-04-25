package com.example.StudentGradingSystem.controller;

import com.example.StudentGradingSystem.models.*;
import com.example.StudentGradingSystem.service.AccountService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.SQLException;

@Controller
@RequestMapping("/login")
public class AccountController {

    @Autowired
    private AccountService accountService;
    @GetMapping
    public String viewLoginChoice(Model model) {
        return "loginChoice";
    }

    @GetMapping(value = "/student")
    public String viewStudentLoginPage(Model model) {
        Account studentAccount = new Account();
        model.addAttribute("account", studentAccount);
        return "login";
    }

    @PostMapping("/student")
    public String checkStudentLoginInformation(@ModelAttribute("account") Account account, Model model,
                                               RedirectAttributes rd, HttpServletRequest request) throws SQLException, ClassNotFoundException {

        if (accountService.isValidAccount(account)) {
            int studentId = accountService.getStudentId(account);
            HttpSession session = request.getSession();
            session.setAttribute("studentId",studentId);
            rd.addFlashAttribute("studentId", studentId);
            return "redirect:/Dashboard/"+studentId;
        }
        return "redirect:/login/student";
    }

}
