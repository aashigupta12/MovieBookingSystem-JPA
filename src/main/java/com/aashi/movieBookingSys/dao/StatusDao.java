package com.aashi.movieBookingSys.dao;

import com.aashi.movieBookingSys.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusDao extends JpaRepository<Status, Integer> {
        public Status findByStatusName(String statusName);
    }

