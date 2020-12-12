package com.example.demo.services;

import com.example.demo.entities.Project;

public interface ProjectService {

    Project createProject(Long userId, Project project);

    Project getProject(Long id);

}
