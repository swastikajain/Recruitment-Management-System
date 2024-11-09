package Project.recur.service;

import java.util.List;

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
	public List<JobSeeker> getAllJobSeeker() {
		
		return jobSeekerRepository.findAll();
	}

}


	
	
		 
		