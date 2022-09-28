package fstf.presentation;

import fstf.business.AccountManager;
import fstf.business.OffreManager;
import fstf.models.Account;
import fstf.models.Offre;
import fstf.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    AccountManager account_manager;

    @Autowired
    OffreManager offre_manager;

    @RequestMapping("Init")
    @ResponseBody
    public String ima(){
      Account a = new Account();
      a.setEmail("idrissi@gmail.com");
      a.setPassword("123456");
      a.setRole(1);
      a.setAccount_id("M123456");

      User u = new User();
      u.setNom("IDRISSI");
      u.setPrenom("YOUNESS");
      u.setUser_id("M123456");

      if(account_manager.add(u,a))
          return "Account created successfully";
      else
          return "Failed to creat account!";
    }

    @RequestMapping(value = "/")
    public ModelAndView home(HttpSession session){
        ModelAndView mv = new ModelAndView("/index.jsp");
        User u = (User) session.getAttribute("user");
        if (u!=null){
            int role = u.getAccount().getRole();
            if(role == 1) mv.setViewName("responsable/index.jsp");
            if(role == 2) mv.setViewName("maintenance/index.jsp");
            if(role == 3) mv.setViewName("admin/index.jsp");
            if(role == 4) mv.setViewName("prof/index.jsp");
        }else{
            List<Offre> list = new ArrayList<>();
            List<Offre> list2 = new ArrayList<>();
            list = offre_manager.findAll();
            for(Offre o :list){
                if(o.getStatus()==0)
                    list2.add(o);
            }
            mv.addObject("Offre",list2);
        }
        return mv;
    }

    @RequestMapping("Logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        System.out.println("User Loged out");
        return "redirect:/";
    }

    @RequestMapping("/Login")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView("login.html");
        System.out.println("User trying to login");
        return mv;
    }

    @PostMapping("/Authentication")
    public ModelAndView Authentication(String user_cin,String user_pwd,HttpSession session){
        ModelAndView mv = new ModelAndView("index.jsp");
        User u = account_manager.authenticate(user_cin,user_pwd);
        System.out.println(u);
        if(u!=null){
            session.setAttribute("user",u);
            System.out.println("User authenticated as : " + u.getNom() + "_" + u.getPrenom() + "_" + u.getAccount().getEmail());
            int role = u.getAccount().getRole();
            if(role == 1) mv.setViewName("responsable/index.jsp");
            if(role == 2) mv.setViewName("maintenance/index.jsp");
            if(role == 3) mv.setViewName("admin/index.jsp");
            if(role == 4) mv.setViewName("prof/index.jsp");
        }else{
            System.out.println("user cin or password are incorrect!");
        }
        return mv;
    }
}
