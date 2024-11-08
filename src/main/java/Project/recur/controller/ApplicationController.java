/*package Project.recur.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Project.recur.model.Application;
import Project.recur.service.ApplicationService;



@RestController
public class ApplicationController {
	@Autowired
	private ApplicationService applicationService;
	@PostMapping("/application/add")
	public Application insert(@RequestBody Application application) {
		return applicationService.insert(application);
	}
}*/
package Project.recur.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
}


