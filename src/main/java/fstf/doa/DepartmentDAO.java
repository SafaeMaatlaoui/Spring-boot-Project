package fstf.doa;

import fstf.models.Department;
import fstf.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentDAO extends CrudRepository<Department,String> {
    Department findDepartmentByName(String name);

}
