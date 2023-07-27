package ru.kridmi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kridmi.dao.EmployeesDao;
import ru.kridmi.models.Employee;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeesController {

    private final EmployeesDao employeesDao;

    @Autowired
    public EmployeesController(EmployeesDao employeesDao) {
        this.employeesDao = employeesDao;
    }

    @GetMapping()
    public List<Employee> index() {
        return employeesDao.index();
    }

    @GetMapping("/{id}")
    public Employee showEmp(@PathVariable("id") int id) {
        return employeesDao.show(id);
    }

    @PostMapping()
    public Employee create(@RequestBody Employee employee) {
        employeesDao.create(employee);
        return employee;
    }

    @PatchMapping("/{id}")
    public Employee update(@RequestBody Employee employee, @PathVariable("id") int id) {
        employeesDao.update(id, employee);
        return employeesDao.show(id);
    }

    @DeleteMapping("/{id}")
    public List<Employee> delete(@PathVariable("id") int id) {
        employeesDao.delete(id);
        return employeesDao.index();
    }

    @GetMapping("/projects")
    public List<Employee> showProjects() {
        return employeesDao.showProjects();
    }

    @GetMapping("/search/{lastname}")
    public List<Employee> showProjectsEmp(@PathVariable("lastname") String lastname) {
        return employeesDao.showProjectsEmp(lastname);
    }
}
