package fstf.business;

import fstf.doa.FournisseurDAO;
import fstf.doa.PostulatDAO;
import fstf.doa.RessourceDAO;
import fstf.models.Fournisseur;
import fstf.models.Postulat;
import fstf.models.Ressource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FournisseurManager {
    @Autowired
    FournisseurDAO f_dao;

    @Autowired
    RessourceDAO r_dao;

    @Autowired
    PostulatDAO p_dao;

    public boolean add(Fournisseur f){
        f_dao.save(f);
        return true;
    }
    public void blacklisted(String msg,String id){
        Fournisseur f = findById(id);
        f.setStatus(0);
        f.setMotif(msg);
        f_dao.save(f);
    }
    public List<String> findAll(){
        List<String> list = new ArrayList<>();
        for(Fournisseur f:f_dao.findAll()) list.add(f.getNom_soc());
        return list;
    }
    public List<Fournisseur> getList(){
        List<Fournisseur> list = new ArrayList<>();
        for(Fournisseur f:f_dao.findAll()) {
            if(f.getStatus() == 1)   list.add(f);
        }
        return list;
    }

    public void delete(String id){
        f_dao.deleteById(id);
    }

    public Fournisseur findById(String nom_soc){
        return f_dao.findById(nom_soc).orElse(null);
    }
    public List<String> findById(int p) {
        List<String> list = new ArrayList<>();
        for(Postulat pos:p_dao.findAll())
            if(pos.getId_offre()==p)
                list.add(pos.getNom_Fournisseur());
        return list;
    }
}
