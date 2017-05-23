package br.com.cfsystems.erp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Employee extends Person{
	
	private static final String type = "employee";

	public static String getType() {
		return type;
	}
	
	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Purchase> purchases = new ArrayList<>();
	
}
