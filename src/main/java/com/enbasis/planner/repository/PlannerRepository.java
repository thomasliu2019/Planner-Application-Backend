package com.enbasis.planner.repository;

import com.enbasis.planner.entity.Planner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlannerRepository extends JpaRepository<Planner, Long> {

    List<Planner> findByCompleted(boolean completed);

}
