package com.accenture.satsservice.server.service;

import java.time.LocalDateTime;
import java.util.List;

import com.accenture.satsservice.server.entity.Learner;
import com.accenture.satsservice.server.exception.AttendanceException;
import com.accenture.satsservice.server.repository.LearnerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService {

    @Autowired
    private LearnerRepository learnerRepository;

    public Learner timeIn(Learner learner) {
        Learner existingLearner = learnerRepository.findByEid(learner.getEid());
        if (existingLearner == null) {
            Learner newLearner = new Learner();
            newLearner.setEid(learner.getEid());
            newLearner.setTimeIn(LocalDateTime.now());
            learnerRepository.save(newLearner);
            existingLearner = newLearner;
            return existingLearner;
        } else {
            throw new AttendanceException("Learner already timed-in");
        }
    }

    public Learner timeOut(Learner learner) {
        Learner existingLearner = learnerRepository.findByEid(learner.getEid());

        if (existingLearner == null) {
            throw new AttendanceException("Learner not yet timed-in");
        } else {
            if (existingLearner.getTimeOut() == null) {
                existingLearner.setTimeOut(LocalDateTime.now());
                return learnerRepository.save(existingLearner);
            } else {
                throw new AttendanceException("Learner already timed-out");
            }
        }
    }

    public List<Learner> getLearners() {
        return learnerRepository.findAll();
    }

    public Learner findByEid(String eid) {
        return learnerRepository.findByEid(eid);
    }
}
