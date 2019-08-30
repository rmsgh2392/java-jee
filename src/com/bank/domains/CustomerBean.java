package com.bank.domains;

public class CustomerBean extends MemberBean{
	private static final long serialVersionUID = 1L;
	private String credit;

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	@Override
	public String toString() {
		return "id=" + getId() 
		+ ",pw=" + getPw() + 
		  ",name=" + getName() + 
		  ",ssn=" + getSsn() + 
		  ",credit =" + credit;
	}
	
	
}
