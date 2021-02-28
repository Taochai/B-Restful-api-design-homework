package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.entity.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.serviceImpl.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "groups")
public class GroupController {

    @Autowired
    GroupServiceImpl groupService;


    @PutMapping(path = "/{id}")
    public void updateGroupName(@PathVariable long id, @RequestParam(name = "name") String name) {
        this.groupService.updateGroupName(id, name);
    }

    @GetMapping(path = "")
    public Map<Long, List<Student>> getGroupInfo() {
        return this.groupService.getAllGroup();
    }
}
