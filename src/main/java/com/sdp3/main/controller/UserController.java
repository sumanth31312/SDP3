package com.sdp3.main.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sdp3.main.entity.Donate;
import com.sdp3.main.entity.Request;
import com.sdp3.main.entity.User;
import com.sdp3.main.repository.DonteRepo;
import com.sdp3.main.repository.RequestRepo;
import com.sdp3.main.repository.UserRepo;

import com.sdp3.main.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	
	@Autowired
	private UserRepo urepo;
	
	@Autowired
	private DonteRepo drepo;
	
	@Autowired
	private RequestRepo rrepo;
	
	
	@ModelAttribute
	public void addCommonData(Model model, Principal principal) {
		String userName = principal.getName();
		User user = service.getEmail(userName);
		model.addAttribute("user",user);
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model,Principal principal) {
		String userName = principal.getName();
		model.addAttribute("title","This is Dashboard");
		return "user/user_dashboard";
	}
	
	@RequestMapping("/mydonations")
	public String donate(Model model,Principal principal) {
		String userName = principal.getName();
		List<Donate> mydlist = drepo.findByDonatedBy(userName);
		model.addAttribute("title","My Donatations");
		return "user/donations";
	}
	
	@GetMapping("/requests")
	public String requests(Model model,Principal principal) {
		List<Request> rlist = rrepo.findAll();
		model.addAttribute("title","Requests");
		model.addAttribute("rlist",rlist);
		return "user/request";
	}
	
	@GetMapping("/myrequests")
	public String myrequests(Model model,Principal principal) {
		String userName = principal.getName();
		List<Request> myrlist = rrepo.findByRequestedBy(userName);
		model.addAttribute("title","My Requests");
		model.addAttribute("myrlist",myrlist);
		return "user/myrequests";
	}
	
	@GetMapping("/addRequest")
	public String addRequest(Model model){
		model.addAttribute("title","Add A Request");
		return "user/addRequest";
	}
	
	@PostMapping("/saveRequest")
	public String saveRequest(Model model,@ModelAttribute("Request") Request request){
		
		request.setAddedDate(new java.util.Date());
		rrepo.save(request);
		System.out.println("hi");
		
		model.addAttribute("title","Requests");
		return "user/request";
	}
	
	@GetMapping("/userProfile")
	public String userProfile(Model model){
		model.addAttribute("title","This is Profile");
		return "user/user_profile";
	}
	@GetMapping("/requestss")
	public String request(Model model,Principal principal) {
		List<Request> rlist = rrepo.findAll();
		model.addAttribute("title","Requests");
		model.addAttribute("rlist",rlist);
		return "user/request";
	}
	
}