package com.thoughtworks.capability.gtb.restfulapidesign.service.serviceImpl;

import com.thoughtworks.capability.gtb.restfulapidesign.entity.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.entity.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    StudentServiceImpl studentService;

    List<Group> groupList;
    static final int TOTAL_GROUP_NUMBER = 6;

    public GroupServiceImpl() {
        this.groupList = new ArrayList<>();
        long groupId = 1;
        for (int i = 0; i < TOTAL_GROUP_NUMBER; i++) {
            this.groupList.add(new Group(groupId++, "", ""));
        }
    }

    @Override
    public void updateGroupName(long id, String name) {
        Optional<Group> groupFounded = this.groupList.stream()
                .filter(group -> group.getId() == id)
                .findAny();
        groupFounded.ifPresent(group -> group.setName(name));
        System.out.println(this.groupList.toString());
    }

    @Override
    public Map<Long, List<Student>> getAllGroup() {
        return this.studentService.groups;
    }
}