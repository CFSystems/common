package br.com.cfsystems.erp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "consumer")
public class Consumer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false)
	private Integer id;

	@Column
	private Long document;
	
	@Column
	private Long phoneNumber;
	
	@Column
	@Size(min = 1, max = 100)
	private String name;
	
	@Column
	@org.hibernate.validator.constraints.Email
	@Size(min = 1, max = 100)
	private String email;
	
	@Column
	@Size(min = 1, max = 100)
	private String password;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="consumer", cascade=CascadeType.ALL)
	private List<Account> accounts = new ArrayList<>();
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="consumer", cascade=CascadeType.ALL)
	private List<Purchase> Purchases = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getDocument() {
		return document;
	}

	public void setDocument(Long document) {
		this.document = document;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
