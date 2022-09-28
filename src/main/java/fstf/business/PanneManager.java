package fstf.business;

import fstf.doa.*;
import fstf.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PanneManager {

    @Autowired
    PanneDAO pd;
    @Autowired
    AffectationDAO af;
    @Autowired
    DepartmentDAO dd;
    @Autowired
    UserDAO ud;
    @Autowired
    EnseignantDAO ed;

    public void save(Panne p){
        pd.save(p);
    }
    public Panne findById(Integer Id){
        return pd.findById(Id).orElse(null);
    }
    public void deleteById(Integer Id){pd.deleteById(Id);}
    public List<Panne> listpanne(){return (List<Panne>) pd.findAll();}

    public List<Ressource> listRessource(Adminstratif user)
    {
        List<Ressource> listt =new ArrayList<>();
        List<Affectation> listeee =  af.findAffectationByDepartment(user.getDepartment());

        if(listeee!=null){

            System.out.println("succes");
            for (Affectation s : listeee) {
                System.out.println(s.getRessource().getMarque());
                listt.add(s.getRessource());
            }
        }

        System.out.println("echec");
        return listt;

    }





    public List<Ressource> listRessource(Enseignant user)
    {
        List<Ressource> listt =new ArrayList<>();
        List<Affectation_E> listeee =  af.findAffectationByUser(user);

        if(listeee!=null){

            System.out.println("succes");
            for (Affectation s : listeee) {
                System.out.println(s.getRessource().getMarque());
                listt.add(s.getRessource());
            }
        }

        System.out.println("echec");
        return listt;

    }
}
