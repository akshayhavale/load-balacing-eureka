package com.restuarant.model;

import java.util.List;

public class Restuarant {

	private List<String> restuarantNames;

	private Customer customer;

	public Restuarant(List<String> restuarantNames, Customer customer) {
		super();
		this.restuarantNames = restuarantNames;
		this.customer = customer;
	}

	public List<String> getRestuarantNames() {
		return restuarantNames;
	}

	public void setRestuarantNames(List<String> restuarantNames) {
		this.restuarantNames = restuarantNames;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((restuarantNames == null) ? 0 : restuarantNames.hashCode());
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
		Restuarant other = (Restuarant) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (restuarantNames == null) {
			if (other.restuarantNames != null)
				return false;
		} else if (!restuarantNames.equals(other.restuarantNames))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Restuarant [restuarantNames=" + restuarantNames + ", customer=" + customer + "]";
	}

}
