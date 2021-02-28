package com.thoughtworks.capability.gtb.restfulapidesign.service.serviceImpl;

import com.thoughtworks.capability.gtb.restfulapidesign.entity.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {


    Map<String,Student> students;

    public StudentServiceImpl() {
        this.students = new HashMap<>();
        this.students.put("1",new Student("1","student1","male",""));
        this.students.put("2",new Student("2","student2","male",""));
        this.students.put("3",new Student("3","student3","female",""));
    }

    @Override
    public Student create(Student student) {
        this.students.put(student.getId(),student);
        return student;
    }

    @Override
    public boolean deleteById(String id) {
        if (this.students.containsKey(id)) {
            this.students.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Student> getAll() {
        return new ArrayList<>(this.students.values());
    }

    @Override
    public List<Student> getAll(String gender) {
        return this.students.values().stream()
                .filter(student -> student.getGender().equals(gender))
                .collect(Collectors.toList());
    }

    @Override
    public Student getById(String id) {
        return this.students.get(id);
    }
}
