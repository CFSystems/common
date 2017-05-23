package br.com.cfsystems.erp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

public class Consumer extends Person {
	
	private static final String type = "consumer";

	public static String getType() {
		return type;
	}
	
	@OneToMany(mappedBy = "consumer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Account> accounts = new ArrayList<>();
	
}
