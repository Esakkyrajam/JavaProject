package com.demo.jpa.Service;

import org.springframework.stereotype.Service;

import com.demo.jpa.Repo.AlienRepo;
import com.demo.jpa.model.Alien;

@Service
public class RepoService {
	
		private AlienRepo repo;
		public RepoService(AlienRepo repo) {
			this.repo = repo;
			System.out.println("repoService called...");
		}
		public  void saveUser(Alien a) {
			
			repo.save(a);
			
		}
}
