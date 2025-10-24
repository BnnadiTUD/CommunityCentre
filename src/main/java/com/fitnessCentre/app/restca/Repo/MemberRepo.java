package com.fitnessCentre.app.restca.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fitnessCentre.app.restca.Models.Member;

public interface MemberRepo extends JpaRepository<Member, Long>{

}