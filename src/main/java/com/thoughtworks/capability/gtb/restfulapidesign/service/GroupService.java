package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.entity.Student;

import java.util.List;
import java.util.Map;

public interface GroupService {
    void updateGroupName(long id, String name);

    Map<Long, List<Student>> getAllGroup();
}
