package com.bank.web.servicesImpl;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.bank.domains.AccountBean;
import com.bank.web.services.*;
public class AccountServiceImpl implements AccountService{
	
	private List<AccountBean> accounts;

	
	public AccountServiceImpl() {
		accounts = new ArrayList<>();		
	}
	
	@Override
	public void createAccount(String money) {
		AccountBean account = new AccountBean();
		account.setAccountNum(createAccountNum());
		account.setToday(findDate());
		account.setMoney(money);
		System.out.println(account);
		accounts.add(account);
	}

	@Override
	public String createAccountNum() {
		Random random = new Random();
		int t = random.nextInt(9999);
		int t1 = random.nextInt(9999);
		return String.format("%d-%04d",t,t1);
	}

	@Override
	public List<AccountBean> findAll() {
		return accounts;
	}

	@Override
	public AccountBean findByAccountNum(String accountNum) {
		AccountBean account = new AccountBean();
		for(AccountBean ac : accounts) {
			if(accountNum.equals(ac.getAccountNum())) {
				account = ac;
				break;
			}
		}
		return account;
	}

	@Override
	public int countAccounts() {
		return accounts.size();
	}

	@Override
	public boolean existAccountNum(String accountNum) {
		AccountBean ac = findByAccountNum(accountNum);
		return accounts.contains(ac)? true : false;
	}

	@Override
	public String findDate() {
		return new SimpleDateFormat("yyyy-MM-dd hh:mm")
				.format(new Date());
	}

	@Override
	public void depositMoney(AccountBean param) {
		
		
	}

	@Override
	public void withdrawMoney(AccountBean param) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAccountNum(String accountNum) {
		// TODO Auto-generated method stub
		
	}

}
