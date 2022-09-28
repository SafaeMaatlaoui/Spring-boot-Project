package fstf.presentation;

import fstf.business.*;
import fstf.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ResponsableGestionRessources {
    @Autowired
    FournisseurManager fournisseur_manager;

    @Autowired
    RessourceManager ressource_manager;

    @Autowired
    DepartmentManager department_manager;

    @Autowired
    AffecationManager affecation_manager;


    @Autowired
    AccountManager account_manager;

    @RequestMapping("AffectationsListe")
    public ModelAndView affectationsListe(){
        ModelAndView mv = new ModelAndView("responsable/affectations.jsp");
        mv.addObject("affectations",affecation_manager.findAll());
        System.out.println(affecation_manager.findAll());
        return mv;
    }

    @PostMapping("AffectationAction")
    public ModelAndView AffectationAction(Integer id,String action,HttpSession session){
        ModelAndView mv = new ModelAndView();
        Affectation aff = affecation_manager.findById(id);
        if(action.equals("delete")) {
            affecation_manager.delete(aff);
            mv.setViewName("responsable/affectations.jsp");
            mv.addObject("affectations",affecation_manager.findAll());
        }

        if(action.equals("edite")){
            session.setAttribute("code",aff.getRessource().getCode());
            session.setAttribute("affectation",aff);
            mv.setViewName("/AffectationDepartment");
        }
        return mv;
    }

    @RequestMapping("SaisirRessource")
    public ModelAndView saisirRessource(){
        ModelAndView mv = new ModelAndView("responsable/saisir_ressource.jsp");
        List<String> listeFournisseurs = fournisseur_manager.findAll();
        mv.addObject("listFournisseurs",listeFournisseurs);
        return mv;
    }

    @PostMapping("addRessource")
    public ModelAndView addRessource(Ressource r, String nom_soc, HttpSession session){
        ModelAndView mv = new ModelAndView();
        Fournisseur f = fournisseur_manager.findById(nom_soc);
        r.setFr(f);
        session.setAttribute("ressource",r);
        if(f==null){//fournisseur ne se trouve pas dans la base des données
            session.setAttribute("ressource",r);
            mv.addObject("nom_soc",nom_soc);
            mv.setViewName("responsable/ajouter_fournisseur.jsp");
        }else{
            if(r.getType().equals("I")) mv.setViewName("responsable/ajouter_impremente.jsp");
            else mv.setViewName("responsable/ajouter_ordinateur.jsp");
        }
        System.out.println(r + "\n" + nom_soc + ":" + nom_soc.split(",").length);
        return mv;
    }

    @PostMapping("AddFournisseur")
    public ModelAndView addFournisseur(Fournisseur f,HttpSession session){
        ModelAndView mv = new ModelAndView();
        Ressource r = (Ressource) session.getAttribute("ressource");
        f.setStatus(1);
        fournisseur_manager.add(f);
        if(r!=null){
            r.setFr(f);
            session.setAttribute("ressource",r);
            if(r.getType().equals("I")) mv.setViewName("responsable/ajouter_impremente.jsp");
            else mv.setViewName("responsable/ajouter_ordinateur.jsp");
        }
        return mv;
    }

    @PostMapping("AddImprimente")
    public String AddImprimente(Imprimente i, HttpSession session){
        Ressource r = (Ressource) session.getAttribute("ressource");
        i.copy(r);
        session.removeAttribute("ressource");
        ressource_manager.add(i);
        System.out.println(i);
        return "redirect:/RessourcesList";
    }

    @PostMapping("AddOrdinateur")
    public String addAddOrdinateur(Ordinateur o, HttpSession session){
        Ressource r = (Ressource) session.getAttribute("ressource");
        o.copy(r);
        session.removeAttribute("ressource");
        ressource_manager.add(o);
        System.out.println(o);
        return "redirect:/RessourcesList";
    }

    @RequestMapping("RessourcesList")
    public ModelAndView ressources_list(){
        List<Ressource> l = ressource_manager.findAll();
        ModelAndView mv = new ModelAndView("responsable/ressources.jsp");
        mv.addObject("ressources",l);
        return mv;
    }

    @PostMapping("RessourceAction")
    public String action(String code,String action,HttpSession session){
        if(action.equals("delete")){
            ressource_manager.delete(code);
            return "redirect:/RessourcesList";
        }

        if(action.equals("affect")){
            session.setAttribute("code",code);
            return "redirect:/AffectationDepartment";
        }
        return  "responsable/index.jsp";
    }

    @RequestMapping("AffectationDepartment")
    public ModelAndView affecation(HttpSession session){
        ModelAndView mv = new ModelAndView("responsable/affectationD.jsp");
        mv.addObject("deps",department_manager.findAll());
        return mv;
    }

    @PostMapping("AffecterDepartment")
    public ModelAndView affecterDepartment(String name,String action,HttpSession session){
        ModelAndView mv = new ModelAndView();
        Department d = department_manager.findById(name);
        System.out.println(d);
        if(action.equals("valider")){
            String code = (String) session.getAttribute("code");
            session.removeAttribute("code");
            Affectation aff = (Affectation) session.getAttribute("affectation");
            session.removeAttribute("affectation");
            affecation_manager.delete(aff);
            aff = new Affectation();
            Ressource  r = ressource_manager.findById(code);
            aff.setDepartment(d);
            aff.setRessource(r);
            affecation_manager.add(aff);
            mv.addObject("affectations",affecation_manager.findAll());
            mv.setViewName("responsable/affectations.jsp");
        }else{
            mv.addObject("users",department_manager.getPersons(d));
            mv.setViewName("responsable/affectationE.jsp");
            session.setAttribute("department",d);
        }
        return mv;
    }

    @PostMapping("AffecterEnseignant")
    public String affecterEnseignant(String user,HttpSession session){
        String code = (String) session.getAttribute("code");
        Ressource  r = ressource_manager.findById(code);
        session.removeAttribute("code");
        Department d = (Department) session.getAttribute("department");
        session.removeAttribute("department");
        User u = account_manager.findById(user);

        Affectation afff = (Affectation) session.getAttribute("affectation");
        session.removeAttribute("affectation");
        affecation_manager.delete(afff);

        Affectation_E aff = new Affectation_E();
        aff.setRessource(r);
        aff.setDepartment(d);
        aff.setUser(u);
        affecation_manager.add(aff);
        return "redirect:/AffectationsListe";
    }

    @RequestMapping("FournisseursList")
    public ModelAndView fournisseursList(){
        List<Fournisseur> l = fournisseur_manager.getList();
        ModelAndView mv = new ModelAndView("responsable/fournisseurs.jsp");
        mv.addObject("fournisseurs",l);
        System.out.println(l);
        return mv;
    }

    @PostMapping("FournisseurAction")
    public ModelAndView FournisseurAction(String action,String id){
        ModelAndView mv = new ModelAndView();
        if(action.equals("Blacklisted")){
            mv.addObject("id",id);
            mv.setViewName("responsable/blacklisted.jsp");
        }
        return mv;
    }

    @PostMapping("Blacklisted")
    public String balcklisted(String msg,String id){
        fournisseur_manager.blacklisted(msg,id);
        System.out.println(msg + id);
        return "redirect:/FournisseursList";
    }
}
