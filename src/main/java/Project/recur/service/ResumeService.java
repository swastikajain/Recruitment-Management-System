package Project.recur.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
