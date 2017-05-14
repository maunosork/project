package fi.puv.e1400521.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentController {
	@Autowired
	private StudentRepository repository;
	
	@RequestMapping("/test2")
    public String test(@RequestParam(value="name", defaultValue="World") String name) {
        return "{\"id\":\"hello\"}";
    }
	
	@RequestMapping(value = "/api/student" , method = RequestMethod.POST)
    public @ResponseBody Student addstudent(@RequestBody Student p) {
    	repository.save(p);
        return p;
	}
	@RequestMapping(value = "/api/students" , method = RequestMethod.GET)
    public Iterable<Student> findall() {
    	return repository.findAll();
	}
	  @RequestMapping(value = "/api/student", method = RequestMethod.GET)
	    public Student get(@RequestParam(value="id", defaultValue="1") int id){
	    	return repository.findOne(id);
	} 
}
