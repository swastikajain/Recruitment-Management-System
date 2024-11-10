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
import Project.recur.model.Resume;
import Project.recur.service.ResumeService;
@RestController
public class ResumeController {
	
@Autowired
		public ResumeService resumeService;
		@PostMapping("/resume/add")
		public Resume addResume(@RequestBody Resume resume) {
			return resumeService.insert(resume);
		}
		@GetMapping("/resume/all")
		public List<Resume> getAllResume() {
			List<Resume> list = resumeService.getAllResume();
			return list;
		}
		@DeleteMapping("/resume/delete/{id}")
		public ResponseEntity<?> deleteJob(@PathVariable int id, ResponseMessageDto dto) {
			//System.out.println(id);
			//validate id
			try {
				resumeService.validate(id);
				resumeService.delete(id);
			} catch (ResourceNotFoundException e) {
				dto.setMsg(e.getMessage());
				return ResponseEntity.badRequest().body(dto);
			} 
			dto.setMsg("Resume deleted");
			return ResponseEntity.ok(dto);
			
		}
}





