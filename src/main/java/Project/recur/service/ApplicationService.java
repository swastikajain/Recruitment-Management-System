package Project.recur.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Project.recur.exception.ResourceNotFoundException;
import Project.recur.model.Application;
import Project.recur.model.Job;
import Project.recur.repository.ApplicationRepository;
import java.util.List;
import java.util.Optional;


@Service
public class ApplicationService {
	@Autowired
	private ApplicationRepository applicationRepository;
	
	public Application insert(Application application) {
		
		return applicationRepository.save(application);
	}

	public List<Application> getAllApplication() {
		// TODO Auto-generated method stub
		return applicationRepository.findAll();
	}

	public void delete(int id) {
		applicationRepository.deleteById(id);
		
	}

	public Application validate(int id) throws ResourceNotFoundException{
		Optional<Application> optional = applicationRepository.findById(id);
		if(optional.isEmpty())
			throw new ResourceNotFoundException("application id invalid");
		
		Application application = optional.get();
		return application;
		
		
	}

}
/*package Project.recur.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Project.recur.model.Application;
import Project.recur.model.Job;
import Project.recur.model.JobSeeker;
import Project.recur.repository.ApplicationRepository;
import Project.recur.repository.JobRepository;
import Project.recur.repository.JobSeekerRepository;
import Project.recur.exception.ResourceNotFoundException;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    public Application createApplication(Application application) throws ResourceNotFoundException {
        // Validate if the JobSeeker exists
        JobSeeker jobSeeker = jobSeekerRepository.findById(application.getJobSeeker().getJobSeekerId())
                .orElseThrow(() -> new ResourceNotFoundException("JobSeeker not found with ID: " 
                        + application.getJobSeeker().getJobSeekerId()));

        // Validate if the Job exists
        Job job = jobRepository.findById(application.getJob().getIdJob())
                .orElseThrow(() -> new ResourceNotFoundException("Job not found with ID: " + application.getJob().getIdJob()));

        // Set the job seeker and job to the application (this step is redundant if they are already set in the Application object)
        application.setJobSeeker(jobSeeker);
        application.setJob(job);

        // Save the application
        return applicationRepository.save(application);
    }

}*/
