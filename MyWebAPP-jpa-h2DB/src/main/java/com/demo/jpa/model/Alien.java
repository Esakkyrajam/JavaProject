package com.demo.jpa.model;

import jakarta.persistence.Id;


import javax.validation.constraints.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Alien {
	
	public Alien() {
		System.out.println("Alien Entity created....");
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aId;
	private String aName;
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
	
	
	
	
}
