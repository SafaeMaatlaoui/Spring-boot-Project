package fstf.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fstf.doa.BesoinDAO;
import fstf.models.Besoin;
import fstf.models.Fournisseur;

@Service
public class BesoinManager {
    @Autowired
    BesoinDAO b_dao;

    public boolean add(Besoin b){
        b_dao.save(b);
        return true;
    }



    public void delete(Integer id){
        b_dao.deleteById(id);
    }




    public List<Besoin> findAll(){
        List<Besoin> list = new ArrayList<>();
        for(Besoin b:b_dao.findAll()) {
            list.add(b);
            //System.out.println(b.getNom_ressource());
        }
        return list;
    }



    public Besoin findById(int id) {
        // TODO Auto-generated method stub
        return b_dao.findById(id).orElse(null);

    }




    public List<Besoin> findbystatus() {
        // TODO Auto-generated method stub
        List<Besoin> list = new ArrayList<>();
        for(Besoin b:b_dao.findAll()) {
            if(b.getStatus()==0)
                list.add(b);
            //System.out.println(b.getNom_ressource());
        }
        return list;


    }}
