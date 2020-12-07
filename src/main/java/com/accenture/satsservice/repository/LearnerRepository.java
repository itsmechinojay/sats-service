package com.accenture.satsservice.repository;

import com.accenture.satsservice.entity.Learner;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LearnerRepository extends JpaRepository<Learner, String> {
    Learner findByEid(String eid);
}
