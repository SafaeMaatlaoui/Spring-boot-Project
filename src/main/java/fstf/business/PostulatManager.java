package fstf.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fstf.doa.BesoinDAO;
import fstf.doa.PostulatDAO;
import fstf.models.Postulat;
@Service
public class PostulatManager {
    @Autowired
    PostulatDAO p_dao;

    public Boolean add(Postulat p) {
        // TODO Auto-generated method stub
        p_dao.save(p);
        return true;
    }

}
