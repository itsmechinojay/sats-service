package com.accenture.satsservice.service;

import java.time.LocalDateTime;
import java.util.List;

import com.accenture.satsservice.entity.Learner;
import com.accenture.satsservice.exception.AttendanceException;
import com.accenture.satsservice.repository.LearnerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService {

    @Autowired
    private LearnerRepository learnerRepository;

    public Learner timeIn(Learner learner) {
        Learner existingLearner = learnerRepository.findByEid(learner.getEid());
        if (existingLearner.getTimeIn() == null) {
            existingLearner.setTimeIn(LocalDateTime.now());
            return learnerRepository.save(existingLearner);
        } else {
            throw new AttendanceException("Learner already timed-out");
        }
    }

    public Learner timeOut(Learner learner) {
        Learner existingLearner = learnerRepository.findByEid(learner.getEid());
        if (existingLearner.getTimeOut() == null) {
            if (existingLearner.getTimeIn() == null) {
                throw new AttendanceException("Learner not yet timed-in");
            } else {
                existingLearner.setTimeOut(LocalDateTime.now());
                return learnerRepository.save(existingLearner);
            }
        } else {
            throw new AttendanceException("Learner already timed-out");
        }
    }

    public List<Learner> getLearners() {
        return learnerRepository.findAll();
    }

    public Learner findByEid(String eid) {
        return learnerRepository.findByEid(eid);
    }
}
