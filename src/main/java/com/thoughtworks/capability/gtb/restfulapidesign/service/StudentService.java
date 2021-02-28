package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.entity.Student;

import java.util.List;

public interface StudentService {
    Student create(Student student);

    boolean deleteById(String id);

    List<Student> getAll();

    List<Student> getAll(String gender);

    Student getById(String id);

    Student updateInfo(String id, String name, String gender, String note);
}
