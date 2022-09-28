package fstf.doa;

import fstf.models.Adminstratif;
import fstf.models.Lab;
import fstf.models.Panne;
import org.springframework.data.repository.CrudRepository;

public interface PanneDAO extends CrudRepository<Panne,Integer> {
    Panne findPanneByCode(String code);



}
