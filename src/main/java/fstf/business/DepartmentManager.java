package fstf.business;

import fstf.doa.DepartmentDAO;
import fstf.doa.UserDAO;
import fstf.models.Adminstratif;
import fstf.models.Department;
import fstf.models.Enseignant;
import fstf.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentManager {
    @Autowired
    DepartmentDAO d_dao;

    @Autowired
    UserDAO u_dao;

    public void add(Department d){
        d_dao.save(d);
    }

    public Department findById(String name){
        return d_dao.findById(name).orElse(null);
    }

    public List<String> findAll(){
        List<String> list = new ArrayList<>();
        for(Department d:d_dao.findAll()) list.add(d.getName());
        return list;
    }

    public List<User> getPersons(Department d){
        List<User> users = new ArrayList<>();
        for(User u:u_dao.findAll()){
            if(u instanceof Enseignant){
                Enseignant e = (Enseignant) u;
                if(e.getDepartment() == d)
                    users.add(u);
            }else if(u instanceof Adminstratif) {
                Adminstratif e = (Adminstratif) u;
                if (e.getDepartment() == d)
                    users.add(u);
            }
        }
        return users;
    }
}
