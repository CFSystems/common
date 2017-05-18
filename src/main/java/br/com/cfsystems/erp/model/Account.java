package br.com.cfsystems.erp.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

@Entity
@Table(name = "account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false)
	private Integer id;

	@ManyToOne
	@JoinColumn(name="id_consumer")
	private Consumer consumer;

	@Column(name="amount_spent")
//	@Column(scale = 2)
	@Digits(integer=20, fraction=2)
	private BigDecimal amountSpent;

	@Column(name="amount_paid")
//	@Column(scale = 2)
	@Digits(integer=20, fraction=2)
	private BigDecimal amountPaid;
	
	@OneToMany(mappedBy="account", fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Purchase> purchaseProducts = new ArrayList<>();
	
	@OneToMany(mappedBy="account", fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Payment> payments = new ArrayList<>();

	private boolean status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Consumer getConsumer() {
		return consumer;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

	public BigDecimal getAmountSpent() {
		return amountSpent;
	}

	public void setAmountSpent(BigDecimal amountSpent) {
		this.amountSpent = amountSpent;
	}

	public BigDecimal getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(BigDecimal amountPaid) {
		this.amountPaid = amountPaid;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amountPaid == null) ? 0 : amountPaid.hashCode());
		result = prime * result + ((amountSpent == null) ? 0 : amountSpent.hashCode());
		result = prime * result + ((consumer == null) ? 0 : consumer.hashCode());
		result = prime * result + (status ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (amountPaid == null) {
			if (other.amountPaid != null)
				return false;
		} else if (!amountPaid.equals(other.amountPaid))
			return false;
		if (amountSpent == null) {
			if (other.amountSpent != null)
				return false;
		} else if (!amountSpent.equals(other.amountSpent))
			return false;
		if (consumer == null) {
			if (other.consumer != null)
				return false;
		} else if (!consumer.equals(other.consumer))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

}
