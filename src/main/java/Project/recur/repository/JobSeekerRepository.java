package Project.recur.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Project.recur.model.JobSeeker;

public interface JobSeekerRepository extends JpaRepository<JobSeeker, Integer>{
}