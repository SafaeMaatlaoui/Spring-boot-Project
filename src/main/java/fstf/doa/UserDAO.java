package fstf.doa;

import fstf.models.Adminstratif;
import fstf.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDAO extends CrudRepository<User,String> {
    Adminstratif findUserByNom(String nom);

}
