package fi.puv.e1400521.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProjectController {
	@Autowired
	private ProjectRepository repository;
	
	@RequestMapping("/test")
    public String test(@RequestParam(value="name", defaultValue="World") String name) {
        return "{\"id\":\"hello\"}";
    }
	
	@RequestMapping(value = "/api/project" , method = RequestMethod.POST)
    public @ResponseBody Project addProject(@RequestBody Project p) {
    	repository.save(p);
        return p;
	} 
	@RequestMapping(value = "/api/projects" , method = RequestMethod.GET)
    public Iterable<Project> findall() {
    	return repository.findAll();
	} 
	  @RequestMapping(value = "/api/project", method = RequestMethod.GET)
	    public Project get(@RequestParam(value="id", defaultValue="1") int id){
	    	return repository.findOne(id);
	} 
}
