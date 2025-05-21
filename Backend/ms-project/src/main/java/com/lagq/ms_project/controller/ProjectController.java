package com.lagq.ms_project.controller;

import com.lagq.ms_project.model.Project;
import com.lagq.ms_project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController
{
    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        return ResponseEntity.ok(projectService.createProject(project));
    }

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        return ResponseEntity.ok(projectService.getProjectById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project project) {
        return ResponseEntity.ok(projectService.updateProject(id, project));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/employee/{employeeId}")
    public List<Project> getProjectsByEmployeeId(@PathVariable Long employeeId) {
        return projectService.getProjectsByEmployeeId(employeeId);
    }

    @PutMapping("/{projectId}/assign/{employeeId}")
    public ResponseEntity<String> assignEmployee(
            @PathVariable Long projectId,
            @PathVariable Long employeeId) {

        projectService.assignEmployeeToProject(projectId, employeeId);
        return ResponseEntity.ok("Employee " + employeeId + " assigned to project " + projectId);
    }

}

