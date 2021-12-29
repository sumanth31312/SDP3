package com.sdp3.main.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sdp3.main.entity.Donate;
import com.sdp3.main.entity.User;
import com.sdp3.main.repository.DonteRepo;
import com.sdp3.main.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UserService service;
	@Autowired
	private DonteRepo drepo;
	
	@ModelAttribute
	public void addCommonData(Model model, Principal principal) {
		String userName = principal.getName();
		User user = service.getEmail(userName);
		model.addAttribute("user",user);
	}
	
	@GetMapping("/adminProfile")
	public String userProfile(Model model){
		model.addAttribute("title","This is Profile");
		return "admin/admin_profile";
	}
	
	@RequestMapping("/volunteer")
	public String volunteer(Model model){
		model.addAttribute("title","Volunteer");
		return "admin/volunteer";
	}
	
	@RequestMapping("/donate")
	public String donate(Model model){
		List<Donate> dlist = drepo.findAll();
		model.addAttribute("title","Donate");
		model.addAttribute("donate","dlist");
		return "admin/donate";
	}
	
	@GetMapping("/editProfile")
	public String editProfile(Model model){
		model.addAttribute("title","This is Profile");
		return "admin/edit_admin_profile";
	}
	
	@PostMapping("/saveProfile")
	public String saveProfile(@ModelAttribute("User") User user) {
		this.service.updateUser(user);
		return "admin/admin_profile";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model, Principal principal) {
		model.addAttribute("title","This is Dashboard");
		String username = principal.getName();
		return "admin/admin_dashboard";
	}

	@GetMapping("/request")
	public String myrequests(){
		return "admin/request";
	}
	
	
}