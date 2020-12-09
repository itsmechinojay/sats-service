package com.accenture.satsservice.server.repository;

import com.accenture.satsservice.server.entity.Learner;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LearnerRepository extends JpaRepository<Learner, Integer> {
    Learner findByEid(String eid);
}
