package fi.puv.e1400521.project;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	List<Student> findById(int id);
}
