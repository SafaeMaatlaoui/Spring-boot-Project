package fstf.presentation;

import fstf.business.*;
import fstf.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class ResponsableGestionAccounts {
    @Autowired
    AccountManager account_manager;

    @Autowired
    DepartmentManager department_manager;

    @Autowired
    LabManager lab_manager;

    @RequestMapping("addDepartmentLabReq")
    public ModelAndView addDepartmentLabReq(){
        ModelAndView mv = new ModelAndView("responsable/add_department_lab.jsp");
        mv.addObject("departments",department_manager.findAll());
        return mv;
    }

    @PostMapping("AjouterDeppartement")
    public String addDepartment(Department d){
        department_manager.add(d);
        System.out.println(d);
        return "responsable/index.jsp";
    }

    @PostMapping("AjouterLaboratoir")
    public String addLab(String name,Lab l){
        Department d = department_manager.findById(name);
        l.setDepartment(d);
        lab_manager.add(l);
        System.out.println(l);
        return "responsable/index.jsp";
    }


    @RequestMapping("AccountList")
    public ModelAndView accountList(){
        List<User> l = account_manager.getList();
        ModelAndView mv = new ModelAndView("responsable/accounts.jsp");
        mv.addObject("accounts",l);
        System.out.println(l);

        return mv;
    }

    @GetMapping("/AddAccount")
    public String addAccount(){
        System.out.println("Request for adding account");
        return "responsable/addAccount.html";
    }

    @PostMapping("/AddAccount")
    public ModelAndView addAccount(Account a, HttpSession session) throws ServletException, IOException {
        ModelAndView mv = new ModelAndView("responsable/addUser.jsp");
        session.setAttribute("account",a);

        if(a.getRole()==3) { //Administratif
            mv.addObject("departments",department_manager.findAll());
            mv.setViewName("responsable/addAdmin.jsp");
        }
        if(a.getRole()==4) { //Enseignant
            mv.addObject("deps",department_manager.findAll());
            mv.addObject("labs",lab_manager.findAll());
            mv.setViewName("responsable/addProf.jsp");
        }
        System.out.println(a);
        return mv;
    }

    @PostMapping("AddAdmin")
    public String addAccount(Adminstratif u,String name, HttpSession session){
        Account    a = (Account) session.getAttribute("account");
        Department d = department_manager.findById(name);
        u.setAccount(a);
        u.setUser_id(a.getAccount_id());
        u.setDepartment(d);
        System.out.println(u);
        session.removeAttribute("account");
        if(account_manager.add(u,a))
            return "redirect:/AccountList";
        else
            return "error.html";
    }

    @PostMapping("AddProf")
    public String addAccount(Enseignant u,String dep,String lab, HttpSession session){
        Account    a = (Account) session.getAttribute("account");
        Department d = department_manager.findById(dep);
        Lab        l = lab_manager.findById(lab);
        u.setAccount(a);
        u.setLab(l);
        u.setUser_id(a.getAccount_id());
        u.setDepartment(d);
        System.out.println("Prof:" + u);
        session.removeAttribute("account");
        if(account_manager.add(u,a))
            return "redirect:/AccountList";
        else
            return "error.html";
    }

    @PostMapping("/AddUser")
    public String addAccount(User u, HttpSession session){
        Account a = (Account) session.getAttribute("account");
        u.setAccount(a);
        u.setUser_id(a.getAccount_id());
        System.out.println(u);
        session.removeAttribute("account");
        if(account_manager.add(u,a))
            return "redirect:/AccountList";
        else
            return "error.html";
    }









}

