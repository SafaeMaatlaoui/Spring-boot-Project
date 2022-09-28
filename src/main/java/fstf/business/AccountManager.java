package fstf.business;

import fstf.doa.UserDAO;
import fstf.models.Account;
import fstf.models.User;
import fstf.doa.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountManager {
    @Autowired
    private AccountDAO a_dao;

    @Autowired
    private UserDAO u_dao;

    public boolean add(User u, Account a){
        u.setAccount(a);
        a_dao.save(a);
        u_dao.save(u);
        return true;
    }

    public User authenticate(String user_cin,String user_pwd){
        User u = u_dao.findById(user_cin).orElse(null);
        if(u!=null){
            if(u.getAccount().getPassword().equals(user_pwd))
                return u;
            else return null;
        }else{
            return null;
        }
    }

    public List<User> getList(){
        List<User> list = new ArrayList<>();
        for(User u:u_dao.findAll()) list.add(u);
        return list;
    }

    public User findById(String id){
        return u_dao.findById(id).orElse(null);
    }
}
