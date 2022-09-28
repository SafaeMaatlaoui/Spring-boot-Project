package fstf.business;

import fstf.doa.ConstatDA0;
import fstf.models.Constat;
import fstf.models.Panne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConstatManager {
    @Autowired
    ConstatDA0 cd;


    public void save(Constat c){
        cd.save(c);
    }
    public List<Constat> listconstat(){return (List<Constat>) cd.findAll();}

    public Constat findById(Integer id) {
        return cd.findById(id).orElse(null);
    }
    public void delete(Integer id){
        cd.deleteById(id);
    }
}
