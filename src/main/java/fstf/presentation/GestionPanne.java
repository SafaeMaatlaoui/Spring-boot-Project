package fstf.presentation;

import fstf.business.ConstatManager;
import fstf.business.PanneManager;
import fstf.business.RessourceManager;
import fstf.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.print.attribute.ResolutionSyntax;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
public class GestionPanne {
    @Autowired
    ConstatManager cm;
    @Autowired
    PanneManager pm;
    @Autowired
    RessourceManager rm;
    @PostMapping("EnvoyerPanne")
    public String signalerPanne(Panne p,String codeee){

        System.out.println("le code de ressource est "+codeee);
        Ressource rr=rm.findById(codeee);

        System.out.println("le code de ressource est "+rr);
        p.setRessource(rr);
        System.out.println("pannnnneeee"+p.getRessource());
        pm.save(p);
        ModelAndView mv = new ModelAndView();

        System.out.println("print"+p.getOrdre());
        System.out.println(p);
        return "redirect:/ListerMyRessource";


    }


    @RequestMapping("SignalerPanne")
    public ModelAndView signalerpanne(String code , HttpSession session) {
        ModelAndView mv = new ModelAndView();
        Ressource r = rm.findById(code);
        System.out.println(r.getCode());
        User user = (User) session.getAttribute("user");
            if (user instanceof Adminstratif) {
                mv.setViewName("admin/signaler_panne.jsp");
            }

            if (user instanceof Enseignant) {
                mv.setViewName("prof/signaler_panne.jsp");
            }
        mv.addObject("Ressource", r);
        return mv;

    }

    @RequestMapping("ListerMyRessource")
    public ModelAndView listermyressource(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        User user = (User) session.getAttribute("user");
        List<Ressource> listr = null;
        if (user instanceof Adminstratif){
            mv.setViewName("prof/ressources.jsp");
            listr = pm.listRessource((Adminstratif) user);
        }

        if (user instanceof Enseignant){
            mv.setViewName("prof/ressources.jsp");
            listr = pm.listRessource((Enseignant) user);
        }

        mv.addObject("ressources", listr);
        return mv;
    }

    @RequestMapping("ListerPanne")
    public ModelAndView listerpanne(){
        ModelAndView mv = new ModelAndView();
       List<Panne> listp= pm.listpanne();
       mv.setViewName("maintenance/pannes.jsp");
       mv.addObject("liste",listp);
     return mv;
    }

    @RequestMapping("ConsulterPanne")
    public ModelAndView consulterpanne(Integer id){
        ModelAndView mv = new ModelAndView();
        System.out.println("id de panne"+id);
        Panne pan= pm.findById(id);
        mv.setViewName("maintenance/consulterpanne.jsp");
        mv.addObject("panne",pan);
        return mv;
    }

    @RequestMapping("DeletePanne")
    public String deletepanne(Integer id){
        pm.deleteById(id);
        return "redirect:/ListerPanne";
    }

    @RequestMapping("SaisirConstat")
    public ModelAndView saisirconstat(String id,HttpSession session){
        System.out.println("eeeee"+id);
        session.setAttribute("id",id);
        ModelAndView mv =new ModelAndView();
        mv.setViewName("maintenance/genererconstat.jsp");
        return mv;
    }
    @PostMapping("AddConstat")
    public String addconstat(Constat c,HttpSession session)
    {
     String id = (String) session.getAttribute("id");
     int aa=Integer.parseInt(id);
     Panne p=pm.findById(aa);
     p.setStatus(1);
     c.setPanne(p);


     cm.save(c);


     System.out.println(c.toString());
         return "redirect:/SaisirConstat";

    }

    @RequestMapping("ListerConstat")
    public ModelAndView listerconstat(){
        ModelAndView mv = new ModelAndView();
        List<Constat> listc= cm.listconstat();
        mv.setViewName("responsable/constat.jsp");
        mv.addObject("liste",listc);
        return mv;
    }

    @RequestMapping("ConsulterConstat")
    public ModelAndView consulterconstat(Integer id,HttpSession session) throws ParseException {

        ModelAndView mv = new ModelAndView();
        Constat con= cm.findById(id);
        System.out.println("le id de status est "+con.getPanne());
        System.out.println("le id de constat et"+con.getId());
        LocalDate date1 = LocalDate.parse(con.getPanne().getRessource().getDate_liv());
        LocalDate date2 =java.time.LocalDate.now();
        long g =con.getPanne().getRessource().getDuree_gar();
        int a=date1.getMonthValue();
        System.out.println("le garentie"+date1);
        date1=date1.plusYears(g);

        System.out.println("le garentie"+g);
        System.out.println("le garentie"+date1);
        int b=java.time.LocalDate.now().getMonthValue();
        int c=a-b;
        if(date1.compareTo(date2) < 0){
        System.out.println("garantie ");
        System.out.println("le garentie"+date1);
        System.out.println("le garentie"+date2);
        }
        int result =date1.compareTo(date2);

        mv.setViewName("responsable/consulterconstat.jsp");
        mv.addObject("constat",con);
        mv.addObject("result",result);
        return mv;
    }

    @RequestMapping("reparer")
    public String reparer(Integer id) {
        Constat con= cm.findById(id);
        con.getPanne().setStatus(2);
        cm.save(con);
        cm.delete(con.getId());
        System.out.println("le pppanne et"+con.getPanne());

     return "redirect:ListerConstat";
    }
    @RequestMapping("garantie")
    public String garantie(Integer id) {
        Constat con= cm.findById(id);
        con.getPanne().setStatus(2);
        cm.delete(con.getId());


        System.out.println("le id de constat et"+con.getId());
        System.out.println("le panne et"+con.getPanne());

        return "redirect:ListerConstat";
    }


}
