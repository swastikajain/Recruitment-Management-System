package Project.recur.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Project.recur.exception.ResourceNotFoundException;
import Project.recur.model.Job;
import Project.recur.repository.JobRepository;
@Service
public class JobService {
	@Autowired
	private JobRepository jobRepository;
	public Job insert(Job job) {
		
		return jobRepository.save(job);
	}
	public List<Job> getAllJob() {
		
		return jobRepository.findAll();
	}
	public void delete(int id) {
		jobRepository.deleteById(id);
		
	}
	public Job validate(int id) throws ResourceNotFoundException {
		Optional<Job> optional = jobRepository.findById(id);
		if(optional.isEmpty())
			throw new ResourceNotFoundException("policy id invalid");
		
		Job job = optional.get();
		return job; 
		
	}
	public List <Job> insertInBatch(List<Job> list) {
		return jobRepository.saveAll(list);
		
	}


}
