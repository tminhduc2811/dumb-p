package com.example.demo.controllers;

import com.example.demo.dto.ProjectDTO;
import com.example.demo.entities.Project;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.ProjectService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<User>createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
    }

    @GetMapping("/{id}/projects")
    public ResponseEntity<List<Project>> getUserProjects(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userRepository.findById(id).get().getProjects(), HttpStatus.OK);
    }


    @PostMapping("/{id}/projects")
    public ResponseEntity<ProjectDTO> createProject(@RequestBody Project project, @PathVariable("id") Long id) {
        Project projectResult = projectService.createProject(id, project);
        System.out.println(projectResult);
        ProjectDTO projectDTO = new ProjectDTO(project.getProjectName(), project.getUser().getId());
        return new ResponseEntity<>(projectDTO, HttpStatus.CREATED);
    }

}
