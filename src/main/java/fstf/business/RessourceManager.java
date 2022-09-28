package fstf.business;

import fstf.doa.AffectationDAO;
import fstf.doa.RessourceDAO;
import fstf.models.Affectation;
import fstf.models.Ressource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RessourceManager {
    @Autowired
    RessourceDAO r_dao;

    @Autowired
    AffectationDAO a_dao;

    public boolean add(Ressource r){
        r_dao.save(r);
        return true;
    }
    public Ressource findRessourceByCode(String code){
        return r_dao.findRessourceByCode(code);
    }

    public Ressource findById(String code){
        return r_dao.findById(code).orElse(null);
    }

    public void delete(String code){
        r_dao.delete(findById(code));
    }

    public List<Ressource> findAll(){
        List<Ressource> list = new ArrayList<>();
        Affectation aff;
        for(Ressource r:r_dao.findAll()){
            aff = a_dao.findAffectationByRessource_Code(r.getCode());
            if(aff!=null){
                r.setAffectation(aff);
                r.setAffected(true);
            }
            list.add(r);
        }
        return list;
    }
}
