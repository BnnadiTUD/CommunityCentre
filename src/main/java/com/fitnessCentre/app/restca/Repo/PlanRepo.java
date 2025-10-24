package com.fitnessCentre.app.restca.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitnessCentre.app.restca.Models.Plan;

public interface PlanRepo extends JpaRepository<Plan, Long>{

}
