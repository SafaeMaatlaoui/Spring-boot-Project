package fstf.business;

import fstf.doa.LabDAO;
import fstf.models.Lab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LabManager {
    @Autowired
    LabDAO d_dao;

    public void add(Lab d){
        d_dao.save(d);
    }

    public List<String> findAll(){
        List<String> list = new ArrayList<>();
        for(Lab d:d_dao.findAll()) list.add(d.getNom());
        return list;
    }

    public Lab findById(String name){
        return d_dao.findById(name).orElse(null);
    }
}
