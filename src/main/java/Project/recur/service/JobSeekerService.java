package Project.recur.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Project.recur.exception.ResourceNotFoundException;
import Project.recur.model.Job;
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
	public void delete(int id) {
		jobSeekerRepository.deleteById(id);
		
	}
	public JobSeeker validate(int id) throws ResourceNotFoundException {
		Optional<JobSeeker> optional = jobSeekerRepository.findById(id);
		if(optional.isEmpty())
			throw new ResourceNotFoundException("Job Seeker id invalid");
		
		JobSeeker jobSeeker = optional.get();
		return jobSeeker; 
		
	}
	public List<JobSeeker> insertInBatch(List<JobSeeker> list) {
		// TODO Auto-generated method stub
		return jobSeekerRepository.saveAll(list);
	}

}


	
	
		 
		