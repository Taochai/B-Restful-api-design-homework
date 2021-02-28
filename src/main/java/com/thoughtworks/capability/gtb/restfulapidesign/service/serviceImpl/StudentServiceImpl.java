package com.thoughtworks.capability.gtb.restfulapidesign.service.serviceImpl;

import com.thoughtworks.capability.gtb.restfulapidesign.entity.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static java.util.Objects.isNull;

@Service
public class StudentServiceImpl implements StudentService {


    Map<String, Student> students;
    Map<Long, List<Student>> groups;
    static final int TOTAL_GROUP_NUMBER = 6;

    public StudentServiceImpl() {
        this.students = new HashMap<>();
        this.groups = new HashMap<>();
        LongStream.rangeClosed(1, 6).forEach(i -> this.groups.put(i, new ArrayList<>()));

        this.students.put("1", new Student("1", "student1", "male", ""));
        this.students.put("2", new Student("2", "student2", "male", ""));
        this.students.put("3", new Student("3", "student3", "female", ""));
    }

    @Override
    public Student create(Student student) {
        this.students.put(student.getId(), student);
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

    @Override
    public Student updateInfo(String id, String name, String gender, String note) {
        Student updatedStudent = this.students.get(id);

        if (!isNull(name)) updatedStudent.setName(name);
        if (!isNull(gender)) updatedStudent.setGender(gender);
        if (!isNull(note)) updatedStudent.setNote(note);

        return updatedStudent;
    }

    @Override
    public List<Integer> group() {

        List<String> studentIds = new ArrayList<>(this.students.keySet());
        long groupId = 0;

        List<Integer> randomNumbers = getNRandomNumbers(studentIds.size());
        for (int number : randomNumbers) {
            this.groups.get(groupId % (TOTAL_GROUP_NUMBER) + 1).add(this.students.get(studentIds.get(number)));
            groupId = ++groupId % TOTAL_GROUP_NUMBER;
        }
        List<Integer> studentNumberOfEachGroup = new ArrayList<>();
        for (List<Student> l : this.groups.values()) {
            studentNumberOfEachGroup.add(l.size());
        }
        return studentNumberOfEachGroup;
    }

    private List<Integer> getNRandomNumbers(int n) {

        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < n) {
            int randomNumber = (int) (Math.random() * n);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }
}
