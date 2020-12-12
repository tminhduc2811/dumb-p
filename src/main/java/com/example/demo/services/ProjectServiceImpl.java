package com.example.demo.services;

import com.example.demo.entities.Project;
import com.example.demo.entities.User;
import com.example.demo.repositories.ProjectRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;


    @Autowired
    private UserRepository userRepository;

    @Override
    public Project createProject(Long userId, Project project) {
        User user = userRepository.findById(userId).get();
        System.out.println(user);
        project.setUser(user);
        project.setProjectName("DEFAULT " + project.getProjectName());
        return projectRepository.save(project);
    }

    @Override
    public Project getProject(Long id) {
        return projectRepository.findById(id).get();
    }
}
