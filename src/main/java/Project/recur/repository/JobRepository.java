package Project.recur.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Project.recur.model.Job;

public interface JobRepository extends JpaRepository<Job,Integer> {

	

}
