package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    private User user;


    @RequestMapping(value = "/deluser",method = RequestMethod.GET)
    public String Deluser(@ModelAttribute("deluser") User deluser){
        userService.delete(deluser);
        return "redirect:/MaintainAdmin.html";
    }

    @RequestMapping(value = "/vipuser",method = RequestMethod.GET)
    public String Vipuser(@ModelAttribute("vipuser") User vipuser){
        userService.givevip(vipuser);
        return "redirect:/MaintainAdmin.html";
    }

    @RequestMapping(value = "pages/examples/vipuser.html",method = RequestMethod.GET)
    public String gotogiveVip(Model model){
        model.addAttribute("vipuser",new User());
        return "/pages/examples/vipuser";
    }

    @RequestMapping(value = "pages/examples/deluser.html",method = RequestMethod.GET)
    public String gotoDeleteVip(Model model){
        model.addAttribute("deluser",new User());
        return "pages/examples/deluser";
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String Register(HttpServletRequest request,@ModelAttribute("user") User user, Model model){
        String email = request.getParameter("email");
        if (userService.getUserbyEmail(email) == null){
            userService.insert(user);
            return "index";
        }
        else {
            return "pages/examples/registererror";
        }
    }


    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String Login(HttpServletRequest request, Model model){
        String email = request.getParameter("email");
        String passwd = request.getParameter("passwd");
        user = userService.findUser(email, passwd);
        if(user != null){
            request.setAttribute("user",user);
            if (email.equals("admin@email") && passwd.equals("admin")){
                return "indexadmin";
            }
            else {
                return "indexlogined";
            }
        }
        else {
            return "pages/examples/loginerror";
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

    @RequestMapping(value = "MaintainAdmin.html",method = RequestMethod.GET)
    public String gotoMaintainAdmin(HttpServletRequest request){
        List<User> list = userService.getAllUser();
        request.setAttribute("user", user);
        request.setAttribute("users",list);
        return "MaintainAdmin";
    }

    @RequestMapping(value = "ProposalEditAdmin.html",method = RequestMethod.GET)
    public String ProposalEditAdmin(HttpServletRequest request,Model model){
        request.setAttribute("user",user);
        return "ProposalEditAdmin";
    }

    @RequestMapping(value = "ProposalEdit.html",method = RequestMethod.GET)
    public String ProposalEdit(HttpServletRequest request,Model model){
        request.setAttribute("user",user);
        return "ProposalEdit";
    }

    @RequestMapping(value = "ProposalQueryAdmin.html",method = RequestMethod.GET)
    public String ProposalQueryAdmin(HttpServletRequest request,Model model){
        request.setAttribute("user",user);
        return "ProposalQueryAdmin";
    }

    @RequestMapping(value = "ProposalQuery.html",method = RequestMethod.GET)
    public String ProposalQuery(HttpServletRequest request,Model model){
        request.setAttribute("user",user);
        return "ProposalQuery";
    }

    @RequestMapping(value = "indexadmin.html",method = RequestMethod.GET)
    public String indexadmin(HttpServletRequest request){
        request.setAttribute("user",user);
        return "indexadmin";
    }

    @RequestMapping(value = "indexlogined.html",method = RequestMethod.GET)
    public String indexlogined(HttpServletRequest request){
        request.setAttribute("user",user);
        return "indexlogined";
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(){
        user = null;
        return "index";
    }

    @RequestMapping(value = "index.html",method = RequestMethod.GET)
    public String index(Model model){
        return "index";
    }

}
