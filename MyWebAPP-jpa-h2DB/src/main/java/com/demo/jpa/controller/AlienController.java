package com.demo.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.jpa.Repo.AlienRepo;
import com.demo.jpa.Service.RepoService;
import com.demo.jpa.model.Alien;

@Controller
public class AlienController {
	
	private RepoService repoService;
	
	public AlienController(RepoService repoService) {
		this.repoService = repoService;
		System.out.println("AlienRepo Created...");
	}
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	@RequestMapping("/addAlien")
	public String saveProduct(Alien a) {
		String b=a.getaName();
		System.out.println(b);
		repoService.saveUser(a);
		
		return "home.jsp";
	}
}
