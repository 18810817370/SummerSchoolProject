package com.example.demo.controller;

import com.example.demo.entity.Proposal;
import com.example.demo.entity.Recommendation;
import com.example.demo.entity.User;
import com.example.demo.service.ProposalService;
import com.example.demo.service.RecommendationService;
import com.example.demo.service.UserService;
import org.apache.ibatis.annotations.Mapper;
import org.apache.tomcat.util.bcel.classfile.Constant;
import org.springframework.http.HttpRequest;
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

    @Autowired
    private ProposalService proposalService;

    @Autowired
    private RecommendationService recommendationService;

    private User user;



    @RequestMapping(value = "/passpp",method = RequestMethod.GET)
    public String Passpp(@ModelAttribute("proposal") Proposal proposal){
        proposalService.pass(proposal);
        return "redirect:/ProposalQueryAdmin.html";
    }

    @RequestMapping(value = "/delpp",method = RequestMethod.GET)
    public String Delpp(@ModelAttribute("proposal") Proposal proposal){
        proposalService.delete(proposal);
        return "redirect:/ProposalQueryAdmin.html";
    }

    @RequestMapping(value = "/vote",method = RequestMethod.GET)
    public String Vote(@ModelAttribute("proposal") Proposal proposal){
        proposalService.vote(proposal);
        return "redirect:/ProposalQuery.html";
    }

    @RequestMapping(value = "/disvote",method = RequestMethod.GET)
    public String Disvote(@ModelAttribute("proposal") Proposal proposal){
        proposalService.disvote(proposal);
        return "redirect:/ProposalQuery.html";
    }

    @RequestMapping(value = "/vipuser",method = RequestMethod.GET)
    public String Vipuser(@ModelAttribute("vipuser") User vipuser){
        userService.givevip(vipuser);
        return "redirect:/MaintainAdmin.html";
    }

    @RequestMapping(value = "/deluser",method = RequestMethod.GET)
    public String Deluser(@ModelAttribute("deluser") User deluser){
        userService.delete(deluser);
        return "redirect:/MaintainAdmin.html";
    }

    @RequestMapping(value = "pages/examples/passpp.html",method = RequestMethod.GET)
    public String gotoPasspp(Model model){
        model.addAttribute("proposal",new Proposal());
        return "pages/examples/passpp";
    }

    @RequestMapping(value = "pages/examples/delpp.html",method = RequestMethod.GET)
    public String gotoDelpp(Model model){
        model.addAttribute("proposal",new Proposal());
        return "pages/examples/delpp";
    }

    @RequestMapping(value = "pages/examples/vote.html",method = RequestMethod.GET)
    public String gotoVote(Model model){
        model.addAttribute("proposal",new Proposal());
        return "pages/examples/vote";
    }

    @RequestMapping(value = "pages/examples/disvote.html",method = RequestMethod.GET)
    public String gotoDisVote(Model model){
        model.addAttribute("proposal",new Proposal());
        return "pages/examples/disvote";
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
            return "redirect:/index.html";
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
                return "redirect:/indexadmin.html";
            }
            else {
                request.getSession().setAttribute("user",user);
                return "redirect:/indexlogined.html";
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

    @RequestMapping(value = "submitpp",method = RequestMethod.GET)
    public String Submitpp(@ModelAttribute("proposal") Proposal proposal){
        proposalService.insert(proposal,user);
        return "redirect:/ProposalQuery.html";
    }

    @RequestMapping(value = "submitppadmin",method = RequestMethod.GET)
    public String SubmitppAdmin(@ModelAttribute("proposal") Proposal proposal){
        proposalService.insert(proposal,user);
        return "redirect:/ProposalQueryAdmin.html";
    }


    @RequestMapping(value = "RecommendlistAdmin.html",method = RequestMethod.GET)
    public String getRcommendlistAdmin(HttpServletRequest request){
        request.setAttribute("user",user);
        List<Recommendation> list = recommendationService.getAllRecommendation();
        request.setAttribute("recommends",list);
        return "RecommendlistAdmin";
    }

    @RequestMapping(value = "Recommendlist.html",method = RequestMethod.GET)
    public String getRcommendlist(HttpServletRequest request){
        request.setAttribute("user",user);
        List<Recommendation> list = recommendationService.getAllRecommendation();
        request.setAttribute("recommends",list);
        return "Recommendlist";
    }

    @RequestMapping(value = "/recommend",method = RequestMethod.GET)
    public String recommend(@ModelAttribute("recommendation") Recommendation recommendation){
        recommendationService.insert(recommendation,user);
        return "redirect:/Recommendlist.html";
    }

    @RequestMapping(value = "recommend.html",method = RequestMethod.GET)
    public String gotoRecommend(HttpServletRequest request,Model model){
        request.setAttribute("user",user);
        model.addAttribute("recommendation",new Recommendation());
        return "recommend";
    }

    @RequestMapping(value = "NonViplist.html",method = RequestMethod.GET)
    public String NonViplist(HttpServletRequest request){
        request.setAttribute("user",user);
        List<User> list = userService.getNonVipUser();
        request.setAttribute("users",list);
        return "NonViplist";
    }

    @RequestMapping(value = "ProposalEditAdmin.html",method = RequestMethod.GET)
    public String ProposalEditAdmin(HttpServletRequest request,Model model){
        request.setAttribute("user",user);
        model.addAttribute("proposal",new Proposal());
        return "ProposalEditAdmin";
    }

    @RequestMapping(value = "ProposalEdit.html",method = RequestMethod.GET)
    public String ProposalEdit(HttpServletRequest request,Model model){
        request.setAttribute("user",user);
        model.addAttribute("proposal",new Proposal());
        return "ProposalEdit";
    }

    @RequestMapping(value = "ProposalQueryAdmin.html",method = RequestMethod.GET)
    public String ProposalQueryAdmin(HttpServletRequest request,Model model){
        request.setAttribute("user",user);
        List<Proposal> pplist = proposalService.getAllProposal();
        request.setAttribute("proposals",pplist);
        return "ProposalQueryAdmin";
    }

    @RequestMapping(value = "ProposalQuery.html",method = RequestMethod.GET)
    public String ProposalQuery(HttpServletRequest request,Model model){
        request.setAttribute("user",user);
        List<Proposal> pplist = proposalService.getAllProposal();
        request.setAttribute("proposals",pplist);
        return "ProposalQuery";
    }

    @RequestMapping(value = "indexadmin.html",method = RequestMethod.GET)
    public String indexadmin(HttpServletRequest request){
        request.setAttribute("user",user);
        List<Proposal> pplist = proposalService.getPassProposal();
        request.setAttribute("proposals",pplist);
        return "indexadmin";
    }

    @RequestMapping(value = "indexlogined.html",method = RequestMethod.GET)
    public String indexlogined(HttpServletRequest request){
        request.setAttribute("user",user);
        List<Proposal> pplist = proposalService.getPassProposal();
        request.setAttribute("proposals",pplist);
        return "indexlogined";
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(){
        user = null;
        return "redirect:index.html";
    }

    @RequestMapping(value = "index.html",method = RequestMethod.GET)
    public String index(HttpServletRequest request){
        List<Proposal> pplist = proposalService.getPassProposal();
        request.setAttribute("proposals",pplist);
        return "index";
    }

}
