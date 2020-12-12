package com.example.demo.dto;

import com.example.demo.entities.Project;

public class ProjectDTO {
    private String projectName;

    private Long id;

    public ProjectDTO(String projectName, Long id) {
        this.projectName = projectName;
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
