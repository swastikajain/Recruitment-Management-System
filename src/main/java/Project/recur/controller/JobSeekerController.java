package Project.recur.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Project.recur.model.JobSeeker;
import Project.recur.service.JobSeekerService;

@RestController
public class JobSeekerController {
	@Autowired
	private JobSeekerService jobSeekerService;
	@PostMapping("/jobSeeker/add")
	public JobSeeker insert(@RequestBody JobSeeker jobSeeker) {
		return jobSeekerService.insert(jobSeeker);
	}
}


	