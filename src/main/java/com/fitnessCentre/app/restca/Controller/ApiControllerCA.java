package com.fitnessCentre.app.restca.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fitnessCentre.app.restca.Models.CommunityCentre;
import com.fitnessCentre.app.restca.Models.Member;
import com.fitnessCentre.app.restca.Models.Plan;
import com.fitnessCentre.app.restca.Models.Payment;
import com.fitnessCentre.app.restca.Repo.CommunityCentreRepo;
import com.fitnessCentre.app.restca.Repo.MemberRepo;
import com.fitnessCentre.app.restca.Repo.PaymentRepo;
import com.fitnessCentre.app.restca.Repo.PlanRepo;

@RestController
public class ApiControllerCA {
	
	@Autowired
	private CommunityCentreRepo communityCentreRepo;
	@Autowired
	private MemberRepo memberRepo;
	@Autowired
	private PlanRepo planRepo;
	@Autowired
	private PaymentRepo paymentRepo;
	
	@GetMapping(value = "/welcome")
	public String getWelcomeMessage() {
		return"hey";
	}
	
	@GetMapping(value = "/listAllCentres")
	public List<CommunityCentre> getCommunityCentres() {
		return communityCentreRepo.findAll();
	}
	
	@GetMapping(value = "/listAllMembers")
	public List<Member> getMembers() {
		return memberRepo.findAll();
	}
	
	@GetMapping(value = "/listAllPlans")
	public List<Plan> getPlans() {
		return planRepo.findAll();
	}

	@GetMapping(value = "/listAllPayments")
	public List<Payment> getPayments() {
		return paymentRepo.findAll();
	}
	
	@PostMapping(value = "/saveCommunityCentre")
	public String savecommunityCentre(@RequestBody CommunityCentre communityCentre) {
		communityCentreRepo.save(communityCentre);
		return "Saved centre...";
	}
	
	@PostMapping(value = "/saveMember")
	public String saveMember(@RequestBody Member member) {
		memberRepo.save(member);
		return "Saved member...";
	}

	@PostMapping(value = "/savePlan")
	public String savePlan(@RequestBody Plan plan) {
		planRepo.save(plan);
		return "Saved plan...";
	}
	
	@PostMapping(value = "/savePayment")
	public String savePayment(@RequestBody Payment payment) {
		paymentRepo.save(payment);
		return "Saved payment...";
	}
}
