package com.lagq.ms_project.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "project")
public class Project
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @ElementCollection
    @CollectionTable(name = "project_personnel", joinColumns = @JoinColumn(name = "project_id"))

    @Column(name = "employee_id")
    private List<Long> projectPersonnel;

    public Project() {}

    public Project(Long id, String name, String description, List<Long> projectPersonnel) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.projectPersonnel = projectPersonnel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Long> getProjectPersonnel() {
        return projectPersonnel;
    }

    public void setProjectPersonnel(List<Long> projectPersonnel) {
        this.projectPersonnel = projectPersonnel;
    }
}
