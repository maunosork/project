package fi.puv.e1400521.project;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, Integer> {
	List<Tag> findById(int id);
}
