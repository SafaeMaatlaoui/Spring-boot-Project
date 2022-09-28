package fstf.doa;

import fstf.models.Constat;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ConstatDA0 extends CrudRepository<Constat,Integer> {

    Optional<Constat> findById(Integer id);
}
