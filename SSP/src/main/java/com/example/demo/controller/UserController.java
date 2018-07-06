package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String Register(@ModelAttribute("user") User user, Model model){
        userService.insert(user);
        return "index";
    }


    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String Login(Model model){
        if(userService.findUser() != null){
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
    public String gotoLogin(Model model){
        model.addAttribute("user",new User());
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
