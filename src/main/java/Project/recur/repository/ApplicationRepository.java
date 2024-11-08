package Project.recur.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Project.recur.model.Application;
public interface ApplicationRepository extends JpaRepository<Application, Integer>{
}