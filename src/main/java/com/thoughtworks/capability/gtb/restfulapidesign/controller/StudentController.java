package com.thoughtworks.capability.gtb.restfulapidesign.controller;


import com.thoughtworks.capability.gtb.restfulapidesign.entity.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.serviceImpl.StudentServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping(path = "/students")
public class StudentController {


    private final StudentServiceImpl studentService;

    @PostMapping(path = "")
    public Student create(@RequestBody Student student) {
        this.studentService.create(student);
        return student;
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable String id) {
        this.studentService.deleteById(id);
    }

    @GetMapping(path = "")
    public List<Student> getAll(@RequestParam(required = false) String gender) {
        return this.studentService.getAll(gender);
    }

    @GetMapping(path = "/{id}")
    public Student getById(@PathVariable String id) {
        return this.studentService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public Student updateInfo(@PathVariable String id, @RequestBody Student student) {

        return this.studentService.updateInfo(id, student.getName(), student.getGender(), student.getNote());

    }

    @GetMapping(path = "group")
    public List<Integer> group() {
        return this.studentService.group();
    }

}
