package Project.recur.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Project.recur.exception.ResourceNotFoundException;
import Project.recur.model.Job;
import Project.recur.model.Resume;
import Project.recur.repository.ResumeRepository;
@Service
public class ResumeService {
	@Autowired
	private ResumeRepository resumeRepository;
	public Resume insert(Resume resume) {
		
		return resumeRepository.save(resume);
	}

	public List<Resume> getAllResume() {
		
		return resumeRepository.findAll();
	}

	public Resume validate(int id) throws ResourceNotFoundException {
		Optional<Resume> optional = resumeRepository.findById(id);
		if(optional.isEmpty())
			throw new ResourceNotFoundException("Resume id invalid");
		
		Resume resume = optional.get();
		return resume; 
		
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		resumeRepository.deleteById(id);
	}

}
