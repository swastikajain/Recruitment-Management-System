	package Project.recur.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Project.recur.dto.ResponseMessageDto;
import Project.recur.exception.ResourceNotFoundException;
import Project.recur.model.Job;
import Project.recur.service.JobService;

@RestController
public class JobController {
	@Autowired
	public JobService jobService;
	@PostMapping("/job/add")
	public Job addJob(@RequestBody Job job) {
		return jobService.insert(job);
	}
	@GetMapping("/job/all")
	public List<Job> getAllJob() {
		List<Job> list = jobService.getAllJob();
		return list;
	}
	@DeleteMapping("/job/delete/{id}")
	public ResponseEntity<?> deleteJob(@PathVariable int id, ResponseMessageDto dto) {
		//System.out.println(id);
		//validate id
		try {
			jobService.validate(id);
			jobService.delete(id);
		} catch (ResourceNotFoundException e) {
			dto.setMsg(e.getMessage());
			return ResponseEntity.badRequest().body(dto);
		} 
		dto.setMsg("Job deleted");
		return ResponseEntity.ok(dto);
		
	}
	@PostMapping("/job/batch/add")
	public List <Job> batchInsert(@RequestBody List<Job> list) {
		return jobService.insertInBatch(list);
	}
	@PutMapping("/update/{id}")
    public ResponseEntity<?> updateJob(@PathVariable int id, @RequestBody Job newJob, ResponseMessageDto dto) {
        try {
            Job existingJobDb = jobService.validate(id);
            
            if (newJob.getTitle() != null)
                existingJobDb.setTitle(newJob.getTitle());
            if (newJob.getDescription() != null)
                existingJobDb.setDescription(newJob.getDescription());
            if (newJob.getLocation() != null)
                existingJobDb.setLocation(newJob.getLocation());
            if (newJob.getQualifications() != null)
                existingJobDb.setQualifications(newJob.getQualifications());
            if (newJob.getExperienceRequired() != null)
                existingJobDb.setExperienceRequired(newJob.getExperienceRequired());
            if (newJob.getCompanyName() != null)
                existingJobDb.setCompanyName(newJob.getCompanyName());
            if (newJob.getJobType() != null)
                existingJobDb.setJobType(newJob.getJobType());
            if (newJob.getSalaryRange() != null)
                existingJobDb.setSalaryRange(newJob.getSalaryRange());
            if (newJob.getApplicationDeadline() != null)
                existingJobDb.setApplicationDeadline(newJob.getApplicationDeadline());
            if (newJob.getDatePosted() != null)
                existingJobDb.setDatePosted(newJob.getDatePosted());

            // Re-save the existing job with new values
            existingJobDb = jobService.insert(existingJobDb);
            return ResponseEntity.ok(existingJobDb);
        } catch (ResourceNotFoundException e) {
            dto.setMsg(e.getMessage());
            return ResponseEntity.badRequest().body(dto);
        }
    }
}
