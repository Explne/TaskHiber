package ru.kridmi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kridmi.dao.ProjectDao;
import ru.kridmi.models.Project;

import java.util.List;


@RestController
@RequestMapping("api/projects")
public class ProjectsController {
    private final ProjectDao projectDao;

    @Autowired
    public ProjectsController(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    @GetMapping()
    public List<Project> showAllProjects() {
        return projectDao.showAll();
    }

    @GetMapping("/{id}")
    public Project showEmp(@PathVariable("id") int id) {
        return projectDao.show(id);
    }

    @PostMapping
    public List<Project> create(@RequestBody Project project) {
        projectDao.create(project);
        return projectDao.showAll();
    }

    @PatchMapping("/{id}")
    public Project update(@RequestBody Project project, @PathVariable("id") int id) {
        projectDao.update(project, id);
        return projectDao.show(id);
    }

    @DeleteMapping("/{id}")
    public List<Project> delete(@PathVariable("id") int id) {
        projectDao.delete(id);
        return projectDao.showAll();
    }

    @GetMapping("/search/{project}")
    public List<Project> showProj(@PathVariable("project") String project) {
        return projectDao.showProj(project);
    }

}
