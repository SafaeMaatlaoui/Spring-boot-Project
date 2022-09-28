package fstf.business;

import fstf.doa.AffectationDAO;
import fstf.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AffecationManager {
    @Autowired
    AffectationDAO aff_dao;

    public void add(Affectation aff){
        aff_dao.save(aff);
    }

    public Affectation findById(Integer id){
        return aff_dao.findById(id).orElse(null);
    }

    public void delete(Affectation aff){
        if(aff!=null) aff_dao.delete(aff);
    }

    public List<Affectation> findAll(){
        List<Affectation> list = new ArrayList<>();
        for(Affectation a:aff_dao.findAll()){
            a.getRessource().setType(a.getRessource() instanceof Imprimente? "Impriment":"Ordinateur");
            a.setForAll(a instanceof Affectation_E? false:true);
            list.add(a);
        }
        return list;
    }
}
