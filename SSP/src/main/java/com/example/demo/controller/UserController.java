package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String Register(HttpServletRequest request,@ModelAttribute("user") User user, Model model){
        String email= request.getParameter("email");
        if (userService.getUserbyEmail(email) == null){
            userService.insert(user);
            return "index";
        }
        else {
            return "pages/examples/register.html";
        }
    }


    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String Login(HttpServletRequest request, Model model){
        String email = request.getParameter("email");
        String passwd = request.getParameter("passwd");
        User user = userService.findUser(email, passwd);
        if(user != null){

            return "index";
        }
        else {
            return "pages/examples/404";
        }
    }

    @RequestMapping(value = "pages/examples/register.html",method = RequestMethod.GET)
    public String gotoRegister(Model model){
        model.addAttribute("user",new User());
        return "pages/examples/register";
    }

    @RequestMapping(value = "pages/examples/login.html",method = RequestMethod.GET)
    public String gotoLogin(){

        return "pages/examples/login";
    }

    @RequestMapping(value = "Maintain.html",method = RequestMethod.GET)
    public String Maintain(Model model){
        return "Maintain";
    }

    @RequestMapping(value = "ProposalEdit.html",method = RequestMethod.GET)
    public String ProposalEdit(Model model){
        return "ProposalEdit";
    }

    @RequestMapping(value = "ProposalQuery.html",method = RequestMethod.GET)
    public String ProposalQuery(Model model){
        return "ProposalQuery";
    }

    @RequestMapping(value = "index.html",method = RequestMethod.GET)
    public String index(Model model){
        return "index";
    }

}
