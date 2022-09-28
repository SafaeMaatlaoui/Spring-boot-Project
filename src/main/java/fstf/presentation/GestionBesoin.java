package fstf.presentation;

import fstf.business.BesoinManager;
import fstf.business.FournisseurManager;
import fstf.business.OffreManager;
import fstf.business.PostulatManager;
import fstf.models.Besoin;
import fstf.models.Fournisseur;
import fstf.models.Offre;
import fstf.models.Postulat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GestionBesoin {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    BesoinManager besoin_manager;
    @Autowired
    OffreManager offre_manager;
    @Autowired
    FournisseurManager fournisseur_manager;

    @Autowired
    PostulatManager Postulat_manager;

    static int p=0;
    static int id_post=0;

    @RequestMapping("/AjouterBesoin")
    public ModelAndView BesoinList(){

        List<Besoin> list = new ArrayList<>();
        List<Besoin> list2 = new ArrayList<>();
        ModelAndView mv = new ModelAndView("admin/ajouterbesoin.jsp");
        list = besoin_manager.findAll();
        for(Besoin b:list){
            if(b.getStatus()==0) list2.add(b);
        }
        mv.addObject("besoin",list2);
        return mv;
    }

    @PostMapping("AjouterBesoin")
    public String addBesoin(Besoin b){

        besoin_manager.add(b);

        System.out.println(b.getNom_ressource());
        return "redirect:/AjouterBesoin";
    }

    @PostMapping("BesoinAction")
    public String BesoinAction(String action,Integer id){
        if(action.equals("delete")){
            besoin_manager.delete(id);
            return "redirect:/AjouterBesoin";
        }
        return "redirect:/AjouterBesoin";

    }






    @RequestMapping("/CreerOffre")
    public ModelAndView BesoinList1(){

        List<Besoin> list = new ArrayList<>();
        ModelAndView mv = new ModelAndView("responsable/creer_offre.jsp");
        list = besoin_manager.findbystatus();


        mv.addObject("besoin",list);
        return mv;
    }

    @PostMapping("OffreAction")
    public String offreAction(String action){
        int i=0;
        int j=0;
        Offre o = new Offre();
        if(action.equals("CreerOffre")){
            List<Besoin> list = new ArrayList<>();
            list = besoin_manager.findbystatus();
            for(Besoin b:list) {
                if(b.getNom_ressource().equals("Imprimante"))
                    i+=b.getQte();

                else
                    j+=b.getQte();
                b.setStatus(1);
            }

            o.setQte_imprimante(i);
            o.setQte_ordinateur(j);
            offre_manager.creeroffre(o);

            return "redirect:/ListeOffre";
        }
        return "redirect:/ListeOffre";
    }

    @RequestMapping("/ListeOffre")
    public ModelAndView OffreList(){

        List<Offre> list = new ArrayList<>();
        ModelAndView mv = new ModelAndView("responsable/ListeOffre.jsp");
        list = offre_manager.findAll();

        mv.addObject("Offre",list);
        return mv;
    }

    @RequestMapping("/Postulation")
    public ModelAndView PostulationOffreList(){

        List<Offre> list = new ArrayList<>();
        ModelAndView mv = new ModelAndView("/index.jsp");
        list = offre_manager.findAll();

        mv.addObject("Offre",list);
        return mv;
    }

    @PostMapping("/PostulationF")
    public String PostulerAction(String action,Integer id){
        id_post=id;

        if(action.equals("Postuler")){

            System.out.println("id"+id_post);

            return "redirect:/FormulairePost";
        }
        return "redirect:/Postulation";
    }

    @RequestMapping("/FormulairePost")
    public ModelAndView PostulationFormulaire(){

        List<String> list = new ArrayList<>();
        ModelAndView mv = new ModelAndView("/FormulairePost.jsp");

        mv.addObject("fournisseur",list);
        return mv;
    }

    @PostMapping("PostAction")
    public String PostAction(String nom_fournisseur){
        Fournisseur f = fournisseur_manager.findById(nom_fournisseur);
        if(f!=null){
            if(f.getStatus() == 1){
                Postulat pos = new Postulat();
                pos.setId_offre(id_post);
                pos.setNom_Fournisseur(nom_fournisseur);
                Postulat_manager.add(pos);
            }else{
                SimpleMailMessage msg = new SimpleMailMessage();
                msg.setTo(f.getEmail());

                msg.setSubject("Declaration");
                msg.setText(f.getMotif());

                javaMailSender.send(msg);
                System.out.println("Sending message ...");
                System.out.println(f.getMotif());
            }
        }


        return "redirect:/";


    }


    @RequestMapping("/affectationoffre")
    public ModelAndView affOffreList(){

        List<String> list = new ArrayList<>();
        ModelAndView mv = new ModelAndView("responsable/affectationoffre.jsp");
        list = fournisseur_manager.findById(p);
        for(String b:list) {
            System.out.println(b);

        }

        mv.addObject("fournisseur",list);
        return mv;
    }

    @PostMapping("Offreaction")
    public String affecterAction(String action,Integer id){
        p=id;

        List<Offre> list = new ArrayList();
        if(action.equals("recu")){
            list = offre_manager.findAll();
            for(Offre f:list) {
                if(f.getOffre_id()==p) {
                    f.setEtat("livrée");
                    f.setStatus(2);
                    offre_manager.creeroffre(f);
                }
            }
            return "redirect:/ListeOffre";
        }
        if(action.equals("Affecter")){

            System.out.println("id"+p);
            return "redirect:/affectationoffre";
        }
        return "redirect:/ListeOffre";
    }

    @PostMapping("Affectation")
    public String valideAction(String action,String fournisseur){
        String a="En cours de livraison";
        System.out.println("id"+p);
        List<Offre> list = new ArrayList();
        if(action.equals("Valider")){
            list = offre_manager.findAll();
            for(Offre f:list) {
                if(f.getOffre_id()==p) {
                    f.setEtat(a);
                    f.setStatus(1);
                    f.setFournisseur(fournisseur);
                    offre_manager.creeroffre(f);
                }
            }
        }
        return "redirect:/ListeOffre";
    }


}
