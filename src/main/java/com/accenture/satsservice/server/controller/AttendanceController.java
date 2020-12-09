package com.accenture.satsservice.server.controller;

import java.util.List;

import com.accenture.satsservice.server.entity.Learner;
import com.accenture.satsservice.server.service.AttendanceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/timeIn")
    public Learner processTimeIn(@RequestBody Learner learner) {
        return attendanceService.timeIn(learner);
    }

    @PostMapping("/timeOut")
    public Learner processTimeOut(@RequestBody Learner learner) {
        return attendanceService.timeOut(learner);
    }

    @GetMapping("/learners")
    public List<Learner> getLearners() {
        return attendanceService.getLearners();
    }

    @GetMapping("/learners/{eid}")
    public Learner findByEid(@PathVariable String eid) {
        return attendanceService.findByEid(eid);
    }

}
