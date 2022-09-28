package fstf.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fstf.doa.BesoinDAO;
import fstf.doa.OffreDAO;
import fstf.models.Besoin;
import fstf.models.Offre;

@Service
public class OffreManager {
    @Autowired
    OffreDAO o_dao;

    public boolean creeroffre(Offre o) {
        // TODO Auto-generated method stub
        o_dao.save(o);
        return true;
    }

    public List<Offre> findAll() {
        // TODO Auto-generated method stub
        List<Offre> list = new ArrayList<>();
        for(Offre o:o_dao.findAll()) {
            list.add(o);
            //System.out.println(b.getNom_ressource());
        }
        return list;

    }

    public void delete(Integer id){
        o_dao.deleteById(id);
    }
}

