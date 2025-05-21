package com.lagq.ms_project.service;

import com.lagq.ms_project.model.Project;
import com.lagq.ms_project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService
{
    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects()
    {
        return projectRepository.findAll();
    }

    public Project getProjectById(Long id)
    {
        return projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found with id " + id));
    }

    public Project createProject(Project project)
    {
        return projectRepository.save(project);
    }

    public Project updateProject(Long id, Project updatedProject)
    {
        return projectRepository.findById(id).map(project -> {
            project.setName(updatedProject.getName());
            project.setDescription(updatedProject.getDescription());
            project.setProjectPersonnel(updatedProject.getProjectPersonnel());
            return projectRepository.save(project);
        }).orElse(null);
    }

    public void assignEmployeeToProject(Long projectId, Long employeeId)
    {
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new RuntimeException("Project not found with id " + projectId));

        List<Long> personnel = project.getProjectPersonnel();

        if (!personnel.contains(employeeId))
        {
            personnel.add(employeeId);
            project.setProjectPersonnel(personnel);
            projectRepository.save(project);
        }
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    public List<Project> getProjectsByEmployeeId(Long employeeId) {
        return projectRepository.findByProjectPersonnelContaining(employeeId);
    }
}

