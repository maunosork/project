package fi.puv.e1400521.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TagController {
	@Autowired
	private TagRepository repository;
	

	@RequestMapping(value = "/api/tag" , method = RequestMethod.POST)
    public @ResponseBody Tag addProject(@RequestBody Tag p) {
    	repository.save(p);
        return p;
	} 
	  @RequestMapping(value = "/api/tag", method = RequestMethod.GET)
	    public Tag get(@RequestParam(value="id", defaultValue="1") int id){
	    	return repository.findOne(id);
	} 
	  @RequestMapping(value = "/api/tags" , method = RequestMethod.GET)
	    public Iterable<Tag> findall() {
	    	return repository.findAll();
		}
}
