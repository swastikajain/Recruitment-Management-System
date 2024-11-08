package Project.recur.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Project.recur.model.JobSeeker;
import Project.recur.repository.JobSeekerRepository;
@Service
public class JobSeekerService {
	@Autowired
	private JobSeekerRepository jobSeekerRepository;
	public JobSeeker insert(JobSeeker jobSeeker) {
		
		return jobSeekerRepository.save(jobSeeker);
	}

}


	
	
		 
		