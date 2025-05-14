package com.lagq.ms_project.repository;

import com.lagq.ms_project.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long>
{
    List<Project> findByProjectPersonnelContaining(Long employeeId);
}
