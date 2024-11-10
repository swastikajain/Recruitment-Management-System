
package Project.recur.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Project.recur.dto.ResponseMessageDto;
import Project.recur.exception.ResourceNotFoundException;
import Project.recur.model.Application;
import Project.recur.model.JobSeeker;
import Project.recur.service.ApplicationService;



@RestController
public class ApplicationController {
	@Autowired
	private ApplicationService applicationService;
	@PostMapping("/application/add")
	public Application insert(@RequestBody Application application) {
		return applicationService.insert(application);
	}
	@GetMapping("/application/all")
	public List<Application> getAllApplication() {
		List<Application> list = applicationService.getAllApplication();
		return list;
	}
	@DeleteMapping("/application/delete/{id}")
	public ResponseEntity<?> deleteJob(@PathVariable int id, ResponseMessageDto dto) {
		//System.out.println(id);
		//validate id
		try {
			applicationService.validate(id);
			applicationService.delete(id);
		} catch (ResourceNotFoundException e) {
			dto.setMsg(e.getMessage());
			return ResponseEntity.badRequest().body(dto);
		} 
		dto.setMsg("Application deleted");
		return ResponseEntity.ok(dto);
		
	}
}


/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Project.recur.exception.ResourceNotFoundException;
import Project.recur.model.Application;
import Project.recur.service.ApplicationService;



@RestController

public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    // POST method to add a new application
    @PostMapping("/application/add")
    public ResponseEntity<?> addApplication(@RequestBody Application application) {
        try {
            // Calls the service to create an application with validation of JobSeeker and Job
            Application newApplication = applicationService.createApplication(application);
            return ResponseEntity.ok(newApplication);
        } catch (ResourceNotFoundException e) {
            // Returns a bad request response with an error message if validation fails
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}*/


