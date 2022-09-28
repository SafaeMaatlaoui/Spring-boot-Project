package fstf.doa;

import fstf.models.Affectation;
import fstf.models.Affectation_E;
import fstf.models.Department;
import fstf.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AffectationDAO extends CrudRepository<Affectation,Integer> {
    public Affectation findAffectationByRessource_Code(String code);
    public List<Affectation> findAffectationByDepartment(Department department);
    List <Affectation_E>  findAffectationByUser(User user);
}

