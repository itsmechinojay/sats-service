package com.accenture.satsservice.server.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "learner")
public class Learner {

    @Id
    @GeneratedValue
    private long id;
    private String eid;
    private LocalDateTime timeIn;
    private LocalDateTime timeOut;

}
